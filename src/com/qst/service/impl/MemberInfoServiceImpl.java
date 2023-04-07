package com.qst.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.dao.MemberInfoMapper;
import com.qst.dao.UserInfoMapper;
import com.qst.entity.MemberInfo;
import com.qst.entity.UserInfo;
import com.qst.service.MemberInfoService;

/**
 * @author 杨惠yanghui
 * @date 2019-9-2上午10:09
 * @version v1.0
 * 会员管理
 */
@Service
public class MemberInfoServiceImpl implements MemberInfoService{
	@Autowired
	private MemberInfoMapper memberDao;
	@Override
	public void addMemberInfo(MemberInfo memberInfo) {
		memberDao.addMemberInfo(memberInfo);
		
	}
	@Override
	public void updateMembers(MemberInfo memberInfo) {
		memberDao.updateMembers(memberInfo);
		
	}
}
