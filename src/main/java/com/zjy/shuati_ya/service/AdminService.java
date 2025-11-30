package com.zjy.shuati_ya.service;

import com.zjy.shuati_ya.pojo.entity.Admin;

import java.util.List;

public interface AdminService {
    public List<Admin> findAll();

    public Admin findById(Integer adminId);

    public int deleteById(int adminId);

    public int update(Admin admin);

    public int add(Admin admin);
}
