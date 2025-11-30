package com.zjy.shuati_ya.mapper;

import com.zjy.shuati_ya.pojo.vo.AnswerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface AnswerMapper {

    /**
     * 当前页数据
     */
    @Select("select * from ( " +
            " select question, subject, score, section, level, '选择题' as type from multi_question " +
            " union all " +
            " select question, subject, score, section, level, '判断题' from judge_question " +
            " union all " +
            " select question, subject, score, section, level, '填空题' from fill_question " +
            ") t order by t.level desc limit #{offset},#{size}")
    List<AnswerVO> pageUnion(@Param("offset") int offset, @Param("size") int size);

    /**
     * 总记录数
     */
    @Select("select count(*) from ( " +
            " select 1 from multi_question " +
            " union all " +
            " select 1 from judge_question " +
            " union all " +
            " select 1 from fill_question " +
            ") t")
    long countUnion();
}
