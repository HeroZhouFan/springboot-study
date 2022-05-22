//package com.study.springbootstudy.aspect;
//
//import com.study.springbootstudy.annotation.DistributedLock;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.lang.reflect.Method;
//import java.util.concurrent.TimeUnit;
//
///**
// * @program: openroad-platform
// * @description: 分布式锁
// * @author: Mr.Zhou
// * @create: 2022-01-09 15:39
// **/
//@Slf4j
//@Aspect
//@Component
//public class DistributedLockAspect {
//
//    @Resource
//    private RedissonClient redissonClient;
//
//    public DistributedLockAspect() {
//    }
//
//    @Pointcut("@annotation(com.study.springbootstudy.annotation.DistributedLock)")
//    private void aspectjMethod() {
//    }
//
//    @Before("aspectjMethod()")
//    public void beforeAdvice(JoinPoint joinPoint) {
//    }
//
//    @After("aspectjMethod()")
//    public void afterAdvice(JoinPoint joinPoint) {
//    }
//
//    @Around("aspectjMethod()")
//    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
//        String methodName = pjp.getSignature().getName();
//        Class<?> targetClass = pjp.getTarget().getClass();
//        Class<?>[] paraTypes = ((MethodSignature) pjp.getSignature()).getParameterTypes();
//        Method method = targetClass.getMethod(methodName, paraTypes);
//        log.info("分布式锁拦截,方法:{}", methodName);
//        DistributedLock annotation = method.getAnnotation(DistributedLock.class);
//        String lockKey = annotation.prefix() +"."+ annotation.lockKey();
//        long leaseTime = annotation.leaseTime();
//        TimeUnit timeUnit = annotation.timeUnit();
//
//        RLock rLock = redissonClient.getLock(lockKey);
//
//        if (rLock.tryLock(leaseTime, timeUnit)) {
//            log.info("加锁成功:{}", lockKey);
//            try {
//                return pjp.proceed();
//            } finally {
//                rLock.unlock();
//                log.info("释放分布式锁{}", lockKey);
//            }
//        } else {
//            log.info("获取锁失败 方法:{}", methodName);
//            return null;
//        }
//    }
//
//}
