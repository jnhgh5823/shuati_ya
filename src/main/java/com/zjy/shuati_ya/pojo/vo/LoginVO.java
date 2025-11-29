package com.zjy.shuati_ya.pojo.vo;

import lombok.Data;

@Data
public class LoginVO {
    //private Integer identity;   // 1 管理员 2 老师 3 学生
    private Integer id;
    private String  name;
    private String  sex;
    private String  tel;
    private String  email;
    private String  cardId;
    private String  role;
    private String  token;
    // 子类专有字段全部放进来，用 Jackson 的 @JsonInclude 控制非空才输出
    private String  institute;  // 老师、学生
    private String  type;       // 老师
    private String  grade;      // 学生
    private String  major;      // 学生
    private String  clazz;      // 学生
}
