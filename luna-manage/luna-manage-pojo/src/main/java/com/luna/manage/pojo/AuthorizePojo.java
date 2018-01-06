package com.luna.manage.pojo;

public class AuthorizePojo {
    private String authorizeId;

    private String roleId;

    private String userId;

    public String getAuthorizeId() {
        return authorizeId;
    }

    public void setAuthorizeId(String authorizeId) {
        this.authorizeId = authorizeId == null ? null : authorizeId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

	@Override
	public String toString() {
		return "AuthorizePojo [authorizeId=" + authorizeId + ", roleId="
				+ roleId + ", userId=" + userId + "]";
	}
    
}