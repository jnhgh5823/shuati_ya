package com.zjy.shuati_ya.pojo.entity;

import com.zjy.shuati_ya.constant.IdentityConstant;
import lombok.Data;

@Data
public class Student extends User {
    private String grade;
    private String major;
    private String clazz;
    private String institute;

    @Override
    public Integer identity() {
        return IdentityConstant.STUDENT;
    }
}