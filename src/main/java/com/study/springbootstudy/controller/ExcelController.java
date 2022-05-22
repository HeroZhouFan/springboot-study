package com.study.springbootstudy.controller;

import com.alibaba.excel.EasyExcel;
import com.study.springbootstudy.model.User;
import com.study.springbootstudy.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @program: springboot-study
 * @description: Excel读写
 * @author: ZhouFan
 * @create: 2022-05-05 23:04
 **/
@RestController
@RequestMapping("/excel")
public class ExcelController {
    @Resource
    private UserService userService;

    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("用户信息", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), User.class).sheet("模板")
                .doWrite(userService.queryAllUser());
    }

}
