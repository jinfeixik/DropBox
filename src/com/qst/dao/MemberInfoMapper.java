package com.qst.dao;

import org.springframework.stereotype.Component;

import com.qst.entity.MemberInfo;

/**
 * @author 袁滢yuanying
 * @date 2019-8-28下午3:36:15
 * @version v1.0
 * 会员管理
 */
@Component
public interface MemberInfoMapper {
	//添加会员信息
	public void addMemberInfo(MemberInfo memberInfo);
	
	//修改会员信息
	public void updateMembers(MemberInfo memberInfo);

}
