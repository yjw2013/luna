package com.luna.manage.mapper;

import com.luna.manage.pojo.CodePojo;
import com.luna.manage.pojo.CodePojoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodePojoMapper {
    long countByExample(CodePojoExample example);

    int deleteByExample(CodePojoExample example);

    int insert(CodePojo record);

    int insertSelective(CodePojo record);

    List<CodePojo> selectByExample(CodePojoExample example);

    int updateByExampleSelective(@Param("record") CodePojo record, @Param("example") CodePojoExample example);

    int updateByExample(@Param("record") CodePojo record, @Param("example") CodePojoExample example);
}