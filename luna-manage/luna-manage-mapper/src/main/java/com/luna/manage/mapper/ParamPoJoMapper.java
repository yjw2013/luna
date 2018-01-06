package com.luna.manage.mapper;

import com.luna.manage.pojo.ParamPoJo;
import com.luna.manage.pojo.ParamPoJoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParamPoJoMapper {
    long countByExample(ParamPoJoExample example);

    int deleteByExample(ParamPoJoExample example);

    int deleteByPrimaryKey(String paramId);

    int insert(ParamPoJo record);

    int insertSelective(ParamPoJo record);

    List<ParamPoJo> selectByExample(ParamPoJoExample example);

    ParamPoJo selectByPrimaryKey(String paramId);

    int updateByExampleSelective(@Param("record") ParamPoJo record, @Param("example") ParamPoJoExample example);

    int updateByExample(@Param("record") ParamPoJo record, @Param("example") ParamPoJoExample example);

    int updateByPrimaryKeySelective(ParamPoJo record);

    int updateByPrimaryKey(ParamPoJo record);
}