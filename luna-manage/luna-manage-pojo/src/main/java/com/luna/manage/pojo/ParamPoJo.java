package com.luna.manage.pojo;

public class ParamPoJo {
    private String paramId;

    private String paramKey;

    private String paramValue;

    private String remark;

    private String paramType;

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId == null ? null : paramId.trim();
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey == null ? null : paramKey.trim();
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }

	@Override
	public String toString() {
		return "ParamPoJo [paramId=" + paramId + ", paramKey=" + paramKey
				+ ", paramValue=" + paramValue + ", remark=" + remark
				+ ", paramType=" + paramType + "]";
	}
    
}