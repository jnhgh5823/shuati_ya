package com.zjy.shuati_ya.service;

import com.zjy.shuati_ya.pojo.entity.PageResult;
import com.zjy.shuati_ya.pojo.vo.AnswerVO;

public interface AnswerService {
    PageResult<AnswerVO> page(Integer page, Integer size);
}
