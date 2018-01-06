package com.luna.manage.mapper;

import com.luna.manage.pojo.RolePojo;
import com.luna.manage.pojo.RolePojoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePojoMapper {
    long countByExample(RolePojoExample example);

    int deleteByExample(RolePojoExample example);

    int insert(RolePojo record);

    int insertSelective(RolePojo record);

    List<RolePojo> selectByExample(RolePojoExample example);

    int updateByExampleSelective(@Param("record") RolePojo record, @Param("example") RolePojoExample example);

    int updateByExample(@Param("record") RolePojo record, @Param("example") RolePojoExample example);
    
    // 查询用户所属的角色
    List<RolePojo> selectRolePoJos(@Param("userId") String userId);
}