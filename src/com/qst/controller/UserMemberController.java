package com.qst.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qst.entity.MemberInfo;
import com.qst.entity.UserInfo;
import com.qst.service.MemberInfoService;
import com.qst.service.UserInfoService;

@Controller
public class UserMemberController {

	@Autowired
	private UserInfoService userService;
	@Autowired
	private MemberInfoService memberService;
	
	@RequestMapping("becomeMember.form")
	public String beMember(HttpServletRequest request){
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("user");
		MemberInfo memberInfo = (MemberInfo) session.getAttribute("memberInfo");
		//保存会员原信息
		MemberInfo memberInfo2 = (MemberInfo) session.getAttribute("memberInfo");
		
		
		System.out.println("用户信息："+userInfo.toString());
		System.out.println("会员信息"+memberInfo.toString());
		
		userInfo.setTotalSpace(2048.0);
		
		Timestamp t1 =  memberInfo2.getMemberStartTime();
		Timestamp t2 =  memberInfo2.getMemberEndTime();
		String realStartTime = t1.toString();
		String realEndTime = t2.toString();
		
		long nd = 1000 * 24 * 60 * 60;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		Date date1 = new Date();
		
		System.out.println("当前按时间"+sdf.format(date));
		//开始时间
		String dateStart = sdf.format(new Date(date.getTime()));
		//30天以后
		String dateEnd = sdf.format(new Date(date.getTime() + (long)30 * 24 * 60 * 60 * 1000));
		//当前时间
		String nowDate = sdf.format(new Date(date.getTime()));
		System.out.println("开始时间"+dateStart);
		System.out.println("结束时间"+dateEnd);
		
		//计算原会员剩余天数
		Date d1 = null;
		Date d2 = null ;
		try {
			d1 = sdf.parse(realStartTime);
			d2 = sdf.parse(realEndTime);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
        long diff = d2.getTime() - d1.getTime();
        //相差天数
        long day = diff/nd;
        System.out.println("还剩"+day+"到期");
        
		try {
			date = sdf.parse(dateEnd);
			date1 = sdf.parse(dateStart);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp startTime = new Timestamp(date1.getTime());
		Timestamp time=new Timestamp(date.getTime());
		System.out.println("string"+dateEnd);
		System.out.println("会员截止时间"+time);
		
		//改变用户状态
	    memberInfo.setMemberStatus(1);
		
		
		//判断永辉是否为会员，是则会员开始时间不变，否开始时间为当前时间
		if(memberInfo2.getMemberStatus()==0){
			System.out.println("改变开始时间");
			memberInfo.setMemberStartTime(startTime);
		}else{
			System.out.println("开始时间不变");
			memberInfo.setMemberStartTime(memberInfo2.getMemberStartTime());
		}
		
		
		//判断会员截止时间，改变用户空间大小
		if(dateEnd.compareTo(nowDate)==1){
			System.out.println("截止日期大于当前日期");
		userInfo.setTotalSpace(2048.0);
		}else{
			System.out.println("截止日期小于当前日期");
			userInfo.setTotalSpace(1024.0);
		}
		
		System.out.println("会员状态"+memberInfo2.getMemberStatus());
		
		//用户是否为会员，否截止到30天以后，是剩余时间+30
		if(memberInfo2.getMemberStatus()==0){
			System.out.println("改变结束时间位30天后");
			memberInfo.setMemberEndTime(time);
			System.out.println("总截至totalTime时间"+time);
		}else{
			//为会员结束时间为未到期的会员时间+30
			System.out.println("会员结束时间为未到期的会员时间+30");
			Date date3 = new Date();
			String endDate  = sdf.format(new Date(date.getTime() + (long)(30+day) * 24 * 60 * 60 * 1000));
			System.out.println("总截至时间"+endDate);
			try {
				date3 = sdf.parse(endDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Timestamp totalTime = new Timestamp(date3.getTime());;
			System.out.println("总截至totalTime时间"+totalTime);
			memberInfo.setMemberEndTime(totalTime);
		}
		//修改会员信息
		memberService.updateMembers(memberInfo);
		//修改用户相关信息
		userService.updateUsers(userInfo);
		
		System.out.println("修改后的会员信息"+memberInfo.toString());
		System.out.println("修改后的用户信息"+userInfo.toString());
		
		HttpSession session2 = request.getSession();
		session2.setAttribute("user", userInfo);
		session2.setAttribute("memberInfo", memberInfo);
		
		return "index";
	}
}
