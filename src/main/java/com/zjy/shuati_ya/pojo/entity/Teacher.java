package com.zjy.shuati_ya.pojo.entity;

import com.zjy.shuati_ya.constant.IdentityConstant;
import lombok.Data;

@Data
public class Teacher extends User {
    private String institute;
    private String type;

    @Override
    public Integer identity() {
        return IdentityConstant.TEACHER;
    }
}