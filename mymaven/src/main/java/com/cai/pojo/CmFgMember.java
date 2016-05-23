package com.cai.pojo;

public class CmFgMember {
    private String cmFunctGroupBo;

    private String cmFunctBo;

    public String getCmFunctGroupBo() {
        return cmFunctGroupBo;
    }

    public void setCmFunctGroupBo(String cmFunctGroupBo) {
        this.cmFunctGroupBo = cmFunctGroupBo == null ? null : cmFunctGroupBo.trim();
    }

    public String getCmFunctBo() {
        return cmFunctBo;
    }

    public void setCmFunctBo(String cmFunctBo) {
        this.cmFunctBo = cmFunctBo == null ? null : cmFunctBo.trim();
    }
}