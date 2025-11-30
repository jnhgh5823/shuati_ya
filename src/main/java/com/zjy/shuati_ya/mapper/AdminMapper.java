package com.zjy.shuati_ya.mapper;

import com.zjy.shuati_ya.pojo.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select name,sex,tel,email,cardId,role from adminuser")
    public List<Admin> findAll();

    @Select("select name,sex,tel,email,cardId,role from adminuser where id = #{adminId}")
    public Admin findById(Integer adminId);

    @Delete("delete from adminuser where id = #{adminId}")
    public int deleteById(int adminId);

    @Update("update adminuser set name = #{name},sex = #{sex}," +
            "tel = #{tel}, email = #{email},pwd = #{pwd},cardId = #{cardId},role = #{role} where id = #{id}")
    public int update(Admin admin);

    @Options(useGeneratedKeys = true,keyProperty = "adminId")
    @Insert("insert into adminuser(name,sex,tel,email,pwd,cardId,role) " +
            "values(#{name},#{sex},#{tel},#{email},#{pwd},#{cardId},#{role})")
    public int add(Admin admin);
}