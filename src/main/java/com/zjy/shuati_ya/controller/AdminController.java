package com.zjy.shuati_ya.controller;

import com.zjy.shuati_ya.pojo.entity.Admin;
import com.zjy.shuati_ya.pojo.entity.Result;
import com.zjy.shuati_ya.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/admins")
    public Result findAll(){
        log.info("查询全部");
        return Result.success(adminService.findAll());
    }

    @GetMapping("/admin/{adminId}")
    public Result findById(@PathVariable("adminId") Integer adminId){
        log.info("根据ID{}查找",adminId);
        return Result.success(adminService.findById(adminId));
    }

    @DeleteMapping("/admin/{adminId}")
    public Result deleteById(@PathVariable("adminId") Integer adminId){
        log.info("根据ID{}删除",adminId);
        adminService.deleteById(adminId);
        return Result.success();
    }

    @PutMapping("/admin/{adminId}")
    public Result update(@PathVariable("adminId") Integer adminId, Admin admin){
        log.info("根据ID{}更新",adminId);
        return Result.success(adminService.update(admin));
    }

    @PostMapping("/admin")
    public Result add(Admin admin){
        log.info("新增管理员");
        return Result.success(adminService.add(admin));
    }
}
