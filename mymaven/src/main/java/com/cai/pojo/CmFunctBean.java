package com.cai.pojo;

import java.util.List;



public class CmFunctBean {

	private String funct;
	private Integer isValid;
	private String functName;
	private String links;
	private String functType;
	private String functLevel;
	private String memo;
	private String image;
	private CmFunctGroupBean cmFunctGroupBo;
	 
	
//	private List<CmRoleBean> functRoleList;
//	private List<CmRoleBean> functRoleNotInList;
	
	
	
	public CmFunctBean(){};
//	
//	public CmFunctBean(String handleRef) throws Exception
//	{
//		if(!StringUtils.isEmpty(handleRef)&&handleRef.startsWith(String.valueOf(TablePrefix.CM_FUNCT)))
//		{
//			handleRef=handleRef.replaceFirst(String.valueOf(TablePrefix.CM_FUNCT), "");
//			String[] handleKeys= handleRef.split(",");
//			if(handleKeys.length==2)
//			{
//				this.company=handleKeys[0];
//				this.funct=handleKeys[1];
//			}else
//			{
//				throw new Exception("非法的handleRef值，不适用于"+this.getClass().getName());
//			}
//		}else
//		{
//			throw new Exception("非法的handleRef值，不适用于"+this.getClass().getName());
//		}
//	}
//	
//	public List<CmRoleBean> getFunctRoleNotInList() {
//		return functRoleNotInList;
//	}
//
//	public void setFunctRoleNotInList(List<CmRoleBean> functRoleNotInList) {
//		this.functRoleNotInList = functRoleNotInList;
//	}
//
//	public String getFunctName() {
//		return functName;
//	}
//
//	public void setFunctName(String functName) {
//		this.functName = functName;
//	}
//
//	public String getFunctType() {
//		return functType;
//	}
//
//	public void setFunctType(String functType) {
//		this.functType = functType;
//	}
//
//	public String getFunctLevel() {
//		return functLevel;
//	}
//
//	public void setFunctLevel(String functLevel) {
//		this.functLevel = functLevel;
//	}
//
//	public CmFunctGroupBean getCmFunctGroupBo() {
//		return cmFunctGroupBo;
//	}
//
//	public void setCmFunctGroupBo(CmFunctGroupBean cmFunctGroupBo) {
//		this.cmFunctGroupBo = cmFunctGroupBo;
//	}
//
//	public List<CmRoleBean> getFunctRoleList() {
//		return functRoleList;
//	}
//
//	public void setFunctRoleList(List<CmRoleBean> functRoleList) {
//		this.functRoleList = functRoleList;
//	}
//
//	public String getFunct() {
//		return funct;
//	}
//
//	public void setFunct(String funct) {
//		this.funct = funct;
//	}
//
//	public Integer getIsValid() {
//		return isValid;
//	}
//
//	public void setIsValid(Integer isValid) {
//		this.isValid = isValid;
//	}
//
//	public void setIsValid(int isValid) {
//		this.isValid = isValid;
//	}
//
//	public String getLinks() {
//		return links;
//	}
//
//	public void setLinks(String links) {
//		this.links = links;
//	}
//
//	public String getMemo() {
//		return memo;
//	}
//
//	public void setMemo(String memo) {
//		this.memo = memo;
//	}
//
//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}
//
//	@Override
//	public String getHandle() {
//		if(validHandleKey())
//		{
//			StringBuffer handle=new StringBuffer().append(TablePrefix.CM_FUNCT).append(this.getCompany()).append(",").append(this.getFunct());
//			return handle.toString();
//		}else
//		{
//			return this.handle;
//		}
//	}
//
//	@Override
//	public boolean validHandleKey() {
//		if(!super.validHandleKey())
//			return false;
//		if(StringUtils.isEmpty(this.getFunct()))
//			return false;
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "CmFunctBean [funct=" + funct + ", isValid=" + isValid
//				+ ", functName=" + functName + ", links=" + links
//				+ ", functType=" + functType + ", functLevel=" + functLevel
//				+ ", memo=" + memo + ", image=" + image + ", cmFunctGroupBo="
//				+ cmFunctGroupBo + ", functRoleList=" + functRoleList
//				+ ", handle=" + handle + ", company=" + company
//				+ ", createDate=" + createDate + ", createUserBo="
//				+ createUserBo + ", modifiedDate=" + modifiedDate
//				+ ", modifiedUserBo=" + modifiedUserBo + ", getHandle()="
//				+ getHandle() + "]";
//	}
//	

}
