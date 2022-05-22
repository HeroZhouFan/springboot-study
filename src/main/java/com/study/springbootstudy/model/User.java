package com.study.springbootstudy.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.Serializable;

/**
 * @program: springboot-study
 * @description: 用户
 * @author: ZhouFan
 * @create: 2022-05-05 22:50
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@HeadStyle(horizontalAlignment = HorizontalAlignment.CENTER)
@ContentStyle(horizontalAlignment = HorizontalAlignment.CENTER)
//@ApiModel("用户模型")
public class User implements Serializable {

    private static final long serialVersionUID = -8535597088351206448L;
    @ExcelProperty("编号")
    @ColumnWidth(10)
    //@ApiModelProperty("编号")
    private Integer id;

    @ExcelProperty("用户名")
    @ColumnWidth(20)
    //@ApiModelProperty("用户名")
    private String username;

    @ExcelProperty("密码")
    @ColumnWidth(20)
    //@ApiModelProperty("密码")
    private String password;

    @ExcelProperty("邮箱")
    @ColumnWidth(20)
    //@ApiModelProperty("邮箱")
    private String email;

    @ExcelProperty("年龄")
    @ColumnWidth(10)
    //@ApiModelProperty("年龄")
    private Integer age;

    @ExcelProperty("性别")
    @ColumnWidth(10)
    //@ApiModelProperty("性别")
    private String sex;

    @ExcelProperty("电话")
    @ColumnWidth(20)
    //@ApiModelProperty("电话")
    private String tel;

    @ExcelProperty("地址")
    @ColumnWidth(10)
    //@ApiModelProperty("地址")
    private String addr;

    @ExcelProperty("身份证")
    @ColumnWidth(20)
    //@ApiModelProperty("身份证")
    private String card;

    @ExcelProperty("婚姻")
    @ColumnWidth(10)
    //@ApiModelProperty("婚姻")
    private Integer married;

    @ExcelProperty("收入")
    @ColumnWidth(10)
    //@ApiModelProperty("收入")
    private Double salary;
}
