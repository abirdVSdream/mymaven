package com.cai.pojo.user;
//权限关联类
public class Correlationupt {
	//关联id
	private String correlationid;
	//用户id
	private String userid;
	//操作的表id
	private String tableid;
	//权限id
	private String permissionid;
	//table表数据
	private Table table;
	//Permission表数据
	private Permission permission;
	
    public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public String getCorrelationid() {
        return correlationid;
    }

    public void setCorrelationid(String correlationid) {
        this.correlationid = correlationid == null ? null : correlationid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid == null ? null : tableid.trim();
    }

    public String getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(String permissionid) {
        this.permissionid = permissionid == null ? null : permissionid.trim();
    }
}