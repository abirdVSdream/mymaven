package com.cai.dao;

import com.cai.pojo.CmFgMember;

public interface CmFgMemberMapper {
    int insert(CmFgMember record);

    int insertSelective(CmFgMember record);
}