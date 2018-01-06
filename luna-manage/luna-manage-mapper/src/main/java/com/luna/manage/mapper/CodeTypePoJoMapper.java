package com.luna.manage.mapper;

import com.luna.manage.pojo.CodeTypePoJo;
import com.luna.manage.pojo.CodeTypePoJoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeTypePoJoMapper {
    long countByExample(CodeTypePoJoExample example);

    int deleteByExample(CodeTypePoJoExample example);

    int insert(CodeTypePoJo record);

    int insertSelective(CodeTypePoJo record);

    List<CodeTypePoJo> selectByExample(CodeTypePoJoExample example);

    int updateByExampleSelective(@Param("record") CodeTypePoJo record, @Param("example") CodeTypePoJoExample example);

    int updateByExample(@Param("record") CodeTypePoJo record, @Param("example") CodeTypePoJoExample example);
}