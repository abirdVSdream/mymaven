package com.cai.pojo;

import java.util.Date;
import java.util.List;


public class PT_DataField {
    private String dataField;

    private String sequence;

    private String dataTag;

    private String description;

    private String fieldType;

    private String ptMaskGroupBo;

    private String fieldUnit;

    private String booleanOneValue;

    private String booleanZeroValue;

    private Date createDate;

    private Date modifiedDate;
    
    private List<PT_DataFileList> dataFieldValueList;
    
    public List<PT_DataFileList> getDataFieldValueList() {
		return dataFieldValueList;
	}
	

	public void setDataFieldValueList(List<PT_DataFileList> dataFieldValueList) {
		this.dataFieldValueList = dataFieldValueList;
	}
	

	public String getDataField() {
        return dataField;
    }

    public void setDataField(String dataField) {
        this.dataField = dataField == null ? null : dataField.trim();
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence == null ? null : sequence.trim();
    }

    public String getDataTag() {
        return dataTag;
    }

    public void setDataTag(String dataTag) {
        this.dataTag = dataTag == null ? null : dataTag.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType == null ? null : fieldType.trim();
    }

    public String getPtMaskGroupBo() {
        return ptMaskGroupBo;
    }

    public void setPtMaskGroupBo(String ptMaskGroupBo) {
        this.ptMaskGroupBo = ptMaskGroupBo == null ? null : ptMaskGroupBo.trim();
    }

    public String getFieldUnit() {
        return fieldUnit;
    }

    public void setFieldUnit(String fieldUnit) {
        this.fieldUnit = fieldUnit == null ? null : fieldUnit.trim();
    }

    public String getBooleanOneValue() {
        return booleanOneValue;
    }

    public void setBooleanOneValue(String booleanOneValue) {
        this.booleanOneValue = booleanOneValue == null ? null : booleanOneValue.trim();
    }

    public String getBooleanZeroValue() {
        return booleanZeroValue;
    }

    public void setBooleanZeroValue(String booleanZeroValue) {
        this.booleanZeroValue = booleanZeroValue == null ? null : booleanZeroValue.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}