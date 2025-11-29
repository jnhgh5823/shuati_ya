package com.zjy.shuati_ya.mapper;

import com.zjy.shuati_ya.pojo.entity.Admin;
import com.zjy.shuati_ya.pojo.entity.Login;
import com.zjy.shuati_ya.pojo.entity.Student;
import com.zjy.shuati_ya.pojo.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("select id,name,sex,tel,email,cardId,role from adminuser where id = #{username} and pwd = #{password}")
    public Admin searchFromAdmin(Login login);

    @Select("select id,name,institute,sex,tel,email,cardId," +
            "type,role from teacher where id = #{username} and pwd = #{password}")
    public Teacher searchFromTeacher(Login login);

    @Select("select id,name,grade,major,clazz,institute,tel," +
            "email,cardId,sex,role from student where id = #{username} and pwd = #{password}")
    public Student searchFromStudent(Login login);
}
