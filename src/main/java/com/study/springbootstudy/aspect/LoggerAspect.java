package com.study.springbootstudy.aspect;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson2.JSON;
import com.study.springbootstudy.model.ResDto;
import com.study.springbootstudy.exception.ServiceException;
import com.study.springbootstudy.model.Logger;
import com.study.springbootstudy.service.LoggerService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 操作日志拦截器
 *
 * @author v_merzhang
 * @since 2021/7/6 10:37
 */
@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Resource
    private LoggerService loggerService;

    /**
     * 切入点
     */
    @Pointcut("execution(public * com..controller.*Controller.*(..)) ")
            //+ "&& !execution(public * com.study.springbootstudy.controller.LoggerController(..))")
    public void logger() {

    }

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("logger()")
    public Object loggerAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取请求对象
        HttpServletRequest request = getRequest();
        Logger logger = new Logger();
        Object result = null;
        long start = System.currentTimeMillis();
        try {
            logger.setClientIp(getIp(request));
            logger.setUri(request.getRequestURI());
            logger.setType(getType(request));
            logger.setMethod(request.getMethod());
            logger.setParamData(JSON.toJSONString(getParams(joinPoint)));
            Cookie[] cookies = request.getCookies();
            if (null != cookies) {
                logger.setCookie(JSON.toJSONString(cookies));
                for (Cookie cookie1 : cookies) {
                    if ("user_uuid".equals(cookie1.getName())) {
                        logger.setUserId(cookie1.getValue());
                    }
                }
            }
            logger.setTime(DateUtil.date(start));

            result = joinPoint.proceed();
            if (result instanceof ResDto) {
                logger.setSystemStatusCode(((ResDto<?>) result).getCode().toString());
            }
            logger.setReturnData(JSON.toJSONString(result));
        } catch (Throwable e) {
            if (e instanceof ServiceException) {
                ServiceException serviceException = (ServiceException) e;
                logger.setSystemStatusCode(serviceException.getCode().toString());
            }
            logger.setError(e.getMessage());
            throw e;
        } finally {
            long end = System.currentTimeMillis();
            long timeCost = end - start;
            logger.setReturnTime(DateUtil.date(end));
            logger.setTimeConsuming((int) timeCost);
            logger.setHttpStatusCode(getResponse().getStatus() + "");
            loggerService.insert(logger);
        }
        return result;
    }

    private Object getParams(ProceedingJoinPoint joinPoint) {
        // 参数名
        String[] paramNames = getMethodSignature(joinPoint).getParameterNames();
        // 参数值
        Object[] paramValues = joinPoint.getArgs();
        // 存储参数
        Map<String, Object> params = new LinkedHashMap<>();
        for (int i = 0; i < paramNames.length; i++) {
            Object value = paramValues[i];
            if (value instanceof HttpServletRequest) {
                continue;
            }
            // MultipartFile对象以文件名作为参数值
            if (value instanceof MultipartFile) {
                MultipartFile file = (MultipartFile) value;
                value = file.getOriginalFilename();
            }
            params.put(paramNames[i], value);
        }
        return params;
    }

    private MethodSignature getMethodSignature(ProceedingJoinPoint joinPoint) {
        return (MethodSignature) joinPoint.getSignature();
    }


    private HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        return requestAttributes.getRequest();
    }

    private HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        return requestAttributes.getResponse();
    }

    private String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    private String getType(HttpServletRequest request) {
        String requestedWith = request.getHeader("X-Requested-With");
        if (!ObjectUtils.isEmpty(requestedWith)
                && "XMLHttpRequest".equalsIgnoreCase(requestedWith)) {
            return "ajax";
        } else {
            return "default";
        }
    }
}
