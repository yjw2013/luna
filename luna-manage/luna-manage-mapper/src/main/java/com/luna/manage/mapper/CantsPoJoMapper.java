package com.luna.manage.mapper;

import com.luna.manage.pojo.CantsPoJo;
import com.luna.manage.pojo.CantsPoJoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CantsPoJoMapper {
    long countByExample(CantsPoJoExample example);

    int deleteByExample(CantsPoJoExample example);

    int deleteByPrimaryKey(String cantCode);

    int insert(CantsPoJo record);

    int insertSelective(CantsPoJo record);

    List<CantsPoJo> selectByExample(CantsPoJoExample example);

    CantsPoJo selectByPrimaryKey(String cantCode);

    int updateByExampleSelective(@Param("record") CantsPoJo record, @Param("example") CantsPoJoExample example);

    int updateByExample(@Param("record") CantsPoJo record, @Param("example") CantsPoJoExample example);

    int updateByPrimaryKeySelective(CantsPoJo record);

    int updateByPrimaryKey(CantsPoJo record);
}