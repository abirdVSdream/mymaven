package com.cai.pojo;

public class DataFileValueList {
    private String handle;

    private String ptDataFieldBo;

    private String sequence;

    private String dataValue;

    private String dataTag;

    private String isDefault;

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle == null ? null : handle.trim();
    }

    public String getPtDataFieldBo() {
        return ptDataFieldBo;
    }

    public void setPtDataFieldBo(String ptDataFieldBo) {
        this.ptDataFieldBo = ptDataFieldBo == null ? null : ptDataFieldBo.trim();
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence == null ? null : sequence.trim();
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue == null ? null : dataValue.trim();
    }

    public String getDataTag() {
        return dataTag;
    }

    public void setDataTag(String dataTag) {
        this.dataTag = dataTag == null ? null : dataTag.trim();
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }
}