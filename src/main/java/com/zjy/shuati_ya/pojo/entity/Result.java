package com.zjy.shuati_ya.pojo.entity;

import lombok.Data;

@Data
public class Result<T> {
    private Integer Code;
    private String msg;
    private T data;

    public static <T> Result<T> success(){
        Result<T> result = new Result<>();
        result.Code=1;
        return result;
    }

    public static <T> Result<T> success(T object){
        Result<T> result = new Result<>();
        result.Code=1;
        result.data=object;
        return result;
    }

    public static <T> Result<T> error(String msg){
        Result<T> result = new Result<>();
        result.Code=0;
        result.msg=msg;
        return result;
    }
}
