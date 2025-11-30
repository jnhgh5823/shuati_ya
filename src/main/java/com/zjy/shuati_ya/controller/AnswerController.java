package com.zjy.shuati_ya.controller;

import com.zjy.shuati_ya.pojo.entity.PageResult;
import com.zjy.shuati_ya.pojo.entity.Result;
import com.zjy.shuati_ya.pojo.vo.AnswerVO;
import com.zjy.shuati_ya.service.AnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping("/answers/{page}/{size}")
    public Result findAllQuestion(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        log.info("查询第{}页的{}条数据",page,size);
        PageResult<AnswerVO> pageResult= answerService.page(page,size);
        return Result.success(pageResult);
    }
}
