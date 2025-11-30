package com.zjy.shuati_ya.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zjy.shuati_ya.mapper.AnswerMapper;
import com.zjy.shuati_ya.pojo.entity.PageResult;
import com.zjy.shuati_ya.pojo.vo.AnswerVO;
import com.zjy.shuati_ya.service.AnswerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public PageResult<AnswerVO> page(Integer page, Integer size) {
        int offset = (page - 1) * size;
        List<AnswerVO> list = answerMapper.pageUnion(offset, size);
        long total = answerMapper.countUnion();
        //log.info("查到{}条数据，内容是{}",total,list);
        return new PageResult<>(total, list);
    }
}
