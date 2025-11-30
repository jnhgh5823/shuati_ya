package com.zjy.shuati_ya.service.impl;

import com.zjy.shuati_ya.constant.IdentityConstant;
import com.zjy.shuati_ya.mapper.LoginMapper;
import com.zjy.shuati_ya.pojo.entity.*;
import com.zjy.shuati_ya.pojo.vo.LoginVO;
import com.zjy.shuati_ya.service.LoginService;
import com.zjy.shuati_ya.util.jwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public LoginVO check(Login login) {
        if(login.getIdentity()==IdentityConstant.ADMIN){
            Admin admin=loginMapper.searchFromAdmin(login);
            return setToken(admin);
        }else if(login.getIdentity()==IdentityConstant.TEACHER){
            Teacher teacher=loginMapper.searchFromTeacher(login);
            return setToken(teacher);
        }else if(login.getIdentity()==IdentityConstant.STUDENT){
            Student student=loginMapper.searchFromStudent(login);
            return setToken(student);
        }
        return null;
    }

    private static LoginVO setToken(User user) {
        LoginVO loginVO=new LoginVO();
        if(user!=null){
            Map<String,Object> map=new HashMap<>();
            map.put("id",user.getId());
            map.put("name",user.getName());
            map.put("role",user.getRole());
            String token = jwtUtils.generateToken(map);
            log.info("token:{}",token);
            user.setToken(token);
            BeanUtils.copyProperties(user,loginVO);
            return loginVO;
        }
        return null;
    }
}
