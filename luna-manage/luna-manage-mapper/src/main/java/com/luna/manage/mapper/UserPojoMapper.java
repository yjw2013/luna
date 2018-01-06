package com.luna.manage.mapper;

import com.luna.manage.pojo.UserPojo;
import com.luna.manage.pojo.UserPojoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPojoMapper {
    long countByExample(UserPojoExample example);

    int deleteByExample(UserPojoExample example);

    int deleteByPrimaryKey(String userId);

    int insert(UserPojo record);

    int insertSelective(UserPojo record);

    List<UserPojo> selectByExample(UserPojoExample example);

    UserPojo selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserPojo record, @Param("example") UserPojoExample example);

    int updateByExample(@Param("record") UserPojo record, @Param("example") UserPojoExample example);

    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);
}