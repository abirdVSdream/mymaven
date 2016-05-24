package com.cai.dao;

import java.util.List;

import com.cai.pojo.CmFgMember;

public interface CmFgMemberMapper {
    int insert(CmFgMember record);
    
    List<CmFgMember> selectByFunctGroupBo(String functGroupBo);
    
    List<CmFgMember> selectByFunctBo(String functBo);

    int insertSelective(CmFgMember record);
}