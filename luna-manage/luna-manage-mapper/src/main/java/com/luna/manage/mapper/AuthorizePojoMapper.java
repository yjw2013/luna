package com.luna.manage.mapper;

import com.luna.manage.pojo.AuthorizePojo;
import com.luna.manage.pojo.AuthorizePojoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorizePojoMapper {
    long countByExample(AuthorizePojoExample example);

    int deleteByExample(AuthorizePojoExample example);

    int deleteByPrimaryKey(String authorizeId);

    int insert(AuthorizePojo record);

    int insertSelective(AuthorizePojo record);

    List<AuthorizePojo> selectByExample(AuthorizePojoExample example);

    AuthorizePojo selectByPrimaryKey(String authorizeId);

    int updateByExampleSelective(@Param("record") AuthorizePojo record, @Param("example") AuthorizePojoExample example);

    int updateByExample(@Param("record") AuthorizePojo record, @Param("example") AuthorizePojoExample example);

    int updateByPrimaryKeySelective(AuthorizePojo record);

    int updateByPrimaryKey(AuthorizePojo record);
}