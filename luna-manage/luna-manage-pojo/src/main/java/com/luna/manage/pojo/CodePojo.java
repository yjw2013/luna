package com.luna.manage.pojo;

public class CodePojo {
    private String codeId;

    private String field;

    private String fieldName;

    private String codeEa;

    private String codeDesc;

    private String enabled;

    private String codeType;

    private Integer sortno;

    private Integer createTime;

    private Integer updateTime;

    private String operId;

    private String remark;

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId == null ? null : codeId.trim();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getCodeEa() {
        return codeEa;
    }

    public void setCodeEa(String codeEa) {
        this.codeEa = codeEa == null ? null : codeEa.trim();
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc == null ? null : codeDesc.trim();
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType == null ? null : codeType.trim();
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId == null ? null : operId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "CodePojo [codeId=" + codeId + ", field=" + field
				+ ", fieldName=" + fieldName + ", codeEa=" + codeEa
				+ ", codeDesc=" + codeDesc + ", enabled=" + enabled
				+ ", codeType=" + codeType + ", sortno=" + sortno
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", operId=" + operId + ", remark=" + remark + "]";
	}
    
}