package com.luna.manage.pojo;

public class CantsPoJo {
    private String cantCode;

    private String cantName;

    private String shortName;

    private String cantType;

    private String superCode;

    private String countryCode;

    private String cantNote;

    private String inUse;

    private String fUscode;

    public String getCantCode() {
        return cantCode;
    }

    public void setCantCode(String cantCode) {
        this.cantCode = cantCode == null ? null : cantCode.trim();
    }

    public String getCantName() {
        return cantName;
    }

    public void setCantName(String cantName) {
        this.cantName = cantName == null ? null : cantName.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getCantType() {
        return cantType;
    }

    public void setCantType(String cantType) {
        this.cantType = cantType == null ? null : cantType.trim();
    }

    public String getSuperCode() {
        return superCode;
    }

    public void setSuperCode(String superCode) {
        this.superCode = superCode == null ? null : superCode.trim();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    public String getCantNote() {
        return cantNote;
    }

    public void setCantNote(String cantNote) {
        this.cantNote = cantNote == null ? null : cantNote.trim();
    }

    public String getInUse() {
        return inUse;
    }

    public void setInUse(String inUse) {
        this.inUse = inUse == null ? null : inUse.trim();
    }

    public String getfUscode() {
        return fUscode;
    }

    public void setfUscode(String fUscode) {
        this.fUscode = fUscode == null ? null : fUscode.trim();
    }

	@Override
	public String toString() {
		return "CantsPoJo [cantCode=" + cantCode + ", cantName=" + cantName
				+ ", shortName=" + shortName + ", cantType=" + cantType
				+ ", superCode=" + superCode + ", countryCode=" + countryCode
				+ ", cantNote=" + cantNote + ", inUse=" + inUse + ", fUscode="
				+ fUscode + "]";
	}
	
}