package com.cai.pojo;

public class PT_DataField2 {
    private String datafieldbo;

    private String datafield;

    private String datatag;

    private String description;

    private String fieldtype;

    private String maskgroupbo;

    private String fieldunit;

    public String getDatafieldbo() {
        return datafieldbo;
    }

    public void setDatafieldbo(String datafieldbo) {
        this.datafieldbo = datafieldbo == null ? null : datafieldbo.trim();
    }

    public String getDatafield() {
        return datafield;
    }

    public void setDatafield(String datafield) {
        this.datafield = datafield == null ? null : datafield.trim();
    }

    public String getDatatag() {
        return datatag;
    }

    public void setDatatag(String datatag) {
        this.datatag = datatag == null ? null : datatag.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFieldtype() {
        return fieldtype;
    }

    public void setFieldtype(String fieldtype) {
        this.fieldtype = fieldtype == null ? null : fieldtype.trim();
    }

    public String getMaskgroupbo() {
        return maskgroupbo;
    }

    public void setMaskgroupbo(String maskgroupbo) {
        this.maskgroupbo = maskgroupbo == null ? null : maskgroupbo.trim();
    }

    public String getFieldunit() {
        return fieldunit;
    }

    public void setFieldunit(String fieldunit) {
        this.fieldunit = fieldunit == null ? null : fieldunit.trim();
    }
}