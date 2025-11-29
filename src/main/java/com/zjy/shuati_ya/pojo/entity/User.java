package com.zjy.shuati_ya.pojo.entity;

import lombok.Data;

@Data
public abstract class User {
    private Integer id;          // 对应 admin_id / teacher_id / student_id
    private String  name;        // 对应 admin_name / teacher_name / student_name
    private String  sex;
    private String  tel;
    private String  email;
    private String  pwd;
    private String  cardId;
    private String  role;
    private String  token;

    /* 每个子类需要告诉外界“我是什么身份” */
    public abstract Integer identity();
}
