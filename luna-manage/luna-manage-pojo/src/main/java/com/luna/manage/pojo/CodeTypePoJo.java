package com.luna.manage.pojo;

public class CodeTypePoJo {
    private String typeId;

    private String field;

    private String fieldName;

    private String codeType;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
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

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType == null ? null : codeType.trim();
    }

	@Override
	public String toString() {
		return "CodeTypePoJo [typeId=" + typeId + ", field=" + field
				+ ", fieldName=" + fieldName + ", codeType=" + codeType + "]";
	}
    
}