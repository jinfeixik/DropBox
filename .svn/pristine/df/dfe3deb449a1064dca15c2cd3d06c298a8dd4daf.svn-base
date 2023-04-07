package com.qst.util;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

public class Email {
@Test
	public void main()  {
		String ss = Code.getNumber(4);
		try {
			Email.send("15274455996@163.com", ss);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("11111");
		
		

	}

	public static void send(String email, String ss) throws MessagingException  {
		System.out.println("邮件发送"+email);
		// 创建Properties 类用于记录邮箱的一些属性
		final Properties props = new Properties();
		props.put("mail.transport.protocol", "SMTP");
		// 表示SMTP发送邮件，必须进行身份验证
		props.put("mail.smtp.auth", "true");
		// 此处填写SMTP服务器
		props.put("mail.smtp.host", "smtp.qq.com");
		// 端口号，QQ邮箱端口587
		props.put("mail.smtp.port", "587");
		// 此处填写，写信人的账号
		props.put("mail.user", "1768118023@qq.com");
		// 此处填写16位STMP口令
		props.put("mail.password", "qwfwtovmirocchac");
		
		// 构建授权信息，用于进行SMTP进行身份验证
		Authenticator authenticator = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名、密码
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};
		// 使用环境属性和授权信息，创建邮件会话
		Session mailSession = Session.getInstance(props, authenticator);
		// 创建邮件消息
		MimeMessage message = new MimeMessage(mailSession);
		// 设置发件人
		InternetAddress form = new InternetAddress(
				props.getProperty("mail.user"));
		message.setFrom(form);

		// 设置收件人的邮箱
		InternetAddress to = new InternetAddress(email);
		message.setRecipient(RecipientType.TO, to);
		Code c = new Code();
		//String ss = c.getNumber(4);
		// 设置邮件标题
		message.setSubject("90网盘");

		// 设置邮件的内容体
		message.setContent("您的验证码为：" + ss
				+ "为了保证您的帐户安全，请勿向任何人提供此验证码,若不是本人操作，请忽略本封邮件",
				"text/html;charset=UTF-8");

		
		// 最后当然就是发送邮件啦
		Transport.send(message);

	}
}
