package com.cai.pojo.user;

public class Permission {
    private String permissionid;

    private String append;

    private String del;

    private String upd;

    private String search;

    private String exp;

    private String che;

    public String getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(String permissionid) {
        this.permissionid = permissionid == null ? null : permissionid.trim();
    }

    public String getAppend() {
        return append;
    }

    public void setAppend(String append) {
        this.append = append == null ? null : append.trim();
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del == null ? null : del.trim();
    }

    public String getUpd() {
        return upd;
    }

    public void setUpd(String upd) {
        this.upd = upd == null ? null : upd.trim();
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search == null ? null : search.trim();
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp == null ? null : exp.trim();
    }

    public String getChe() {
        return che;
    }

    public void setChe(String che) {
        this.che = che == null ? null : che.trim();
    }
}