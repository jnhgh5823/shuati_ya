package com.zjy.shuati_ya.pojo.entity;

import com.zjy.shuati_ya.constant.IdentityConstant;

public class Admin extends User {
    @Override
    public Integer identity() {
        return IdentityConstant.ADMIN;
    }
}