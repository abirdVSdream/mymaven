package com.cai.pojo;

import java.util.List;

public class CmFunctGroupBean {

	private String functGroup;
	private String groupName;
	private String memo;
	private String image;
	private List<CmFunctBean> functMemberList;
	private List<CmFunctGroupBean> functGroupMemberList;
	
	private List<CmFunctBean> functUnAssignedList;
	private List<CmFunctGroupBean> functGroupNotInList;
	
	
//
//	public List<CmFunctBean> getFunctUnAssignedList() {
//		return functUnAssignedList;
//	}
//
//	public void setFunctUnAssignedList(List<CmFunctBean> functUnAssignedList) {
//		this.functUnAssignedList = functUnAssignedList;
//	}
//
//	public List<CmFunctGroupBean> getFunctGroupNotInList() {
//		return functGroupNotInList;
//	}
//
//	public void setFunctGroupNotInList(List<CmFunctGroupBean> functGroupNotInList) {
//		this.functGroupNotInList = functGroupNotInList;
//	}
//
//	public CmFunctGroupBean(){}
//	
//	public CmFunctGroupBean(String handleRef) throws Exception
//	{
//		if(!StringUtils.isEmpty(handleRef)&&handleRef.startsWith(String.valueOf(TablePrefix.CM_FUNCT_GROUP)))
//		{
//			handleRef.replaceFirst(String.valueOf(TablePrefix.CM_FUNCT_GROUP), "");
//			String[] handleKeys= handleRef.split(",");
//			if(handleKeys.length==2)
//			{
//				this.company=handleKeys[0];
//				this.functGroup=handleKeys[1];
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
//	public CmFunctGroupBean(String company,String functGroup)
//	{
//		this.company=company;
//		this.functGroup=functGroup;
//	}
//	
//	public List<CmFunctGroupBean> getFunctGroupMemberList() {
//		return functGroupMemberList;
//	}
//
//	public void setFunctGroupMemberList(List<CmFunctGroupBean> functGroupMemberList) {
//		this.functGroupMemberList = functGroupMemberList;
//	}
//	
//	
//	public List<CmFunctBean> getFunctMemberList() {
//		return functMemberList;
//	}
//
//	public void setFunctMemberList(List<CmFunctBean> functMemberList) {
//		this.functMemberList = functMemberList;
//	}
//
//	public String getFunctGroup() {
//		return functGroup;
//	}
//
//	public void setFunctGroup(String functGroup) {
//		this.functGroup = functGroup;
//	}
//
//	
//
//	public String getGroupName() {
//		return groupName;
//	}
//
//	public void setGroupName(String groupName) {
//		this.groupName = groupName;
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
//			StringBuffer handle=new StringBuffer().append(TablePrefix.CM_FUNCT_GROUP).append(this.getCompany()).append(",").append(this.getFunctGroup());
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
//		if(StringUtils.isEmpty(this.getFunctGroup()))
//			return false;
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "CmFunctGroupBean [functGroup=" + functGroup + ", groupName="
//				+ groupName + ", memo=" + memo + ", image=" + image
//				+ ", functMemberList=" + functMemberList
//				+ ", functGroupMemberList=" + functGroupMemberList
//				+ ", handle=" + handle + ", company=" + company
//				+ ", createDate=" + createDate + ", createUserBo="
//				+ createUserBo + ", modifiedDate=" + modifiedDate
//				+ ", modifiedUserBo=" + modifiedUserBo + ", getHandle()="
//				+ getHandle() + "]";
//	}
//
//	
}
