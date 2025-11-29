package com.zjy.shuati_ya.controller;

import com.zjy.shuati_ya.constant.IdentityConstant;
import com.zjy.shuati_ya.pojo.entity.*;
import com.zjy.shuati_ya.pojo.vo.LoginVO;
import com.zjy.shuati_ya.service.LoginService;
import com.zjy.shuati_ya.util.jwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result<Object> login(@RequestBody Login login){
        LoginVO user=loginService.check(login);
        return Result.success(user);
    }
}
