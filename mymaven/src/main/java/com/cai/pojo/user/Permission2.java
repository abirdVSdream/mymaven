package com.cai.pojo.user;
//权限类
public class Permission2 {
    //关联id
	private String permissionid;

    //增加权限
  	private String add;
  	//删除权限
  	private String delete;
  	//更新权限
  	private String update;
  	//查找权限
  	private String search;
  	//导出数据权限
  	private String export;
  	//审核权限
  	private String check;

    public String getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(String permissionid) {
        this.permissionid = permissionid == null ? null : permissionid.trim();
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add == null ? null : add.trim();
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete == null ? null : delete.trim();
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update == null ? null : update.trim();
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search == null ? null : search.trim();
    }

    public String getExport() {
        return export;
    }

    public void setExport(String export) {
        this.export = export == null ? null : export.trim();
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check == null ? null : check.trim();
    }
}