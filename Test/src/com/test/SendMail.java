package com.test;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {
	public static void main(String[] args) throws AddressException, MessagingException {

//		String smtp = "smtp.163.com";// smtp服务器
//
//		String from = "thankyouwl@163.com";// 邮件显示名称
//
//		String to = "572546226@qq.com";// 收件人的邮件地址，必须是真实地址
//
//		String copyto = "";// 抄送人邮件地址
//
//		String subject = "测试邮件";// 邮件标题
//
//		String content = "你好！";// 邮件内容
//
//		String username = "jiachengyu";// 发件人真实的账户名
//
//		String password = "newpass533925";// 发件人密码
//
//		Mail.sendAndCc(smtp, from, to, copyto, subject, content, username, password);
		
		sendMail("smtp.qq.com", "jcy533925", "cjia@eclassmate.cn", "572546226@qq.com", "test", "www.baidu.com");
		
		
	}

	public static void sendMail(String host, String pwd, String sourceAddr, String destAddr,
            String subject, String text) throws AddressException, MessagingException
    {
        Properties props = new Properties();
        props.put("mail.smtp.host", host); // 设置发送邮件的邮件服务器的属性
        props.put("mail.smtp.auth", "true"); // 需要经过授权验证
        Session session = Session.getDefaultInstance(props); // 构建一个session
        session.setDebug(true); // console处显示过程信息

        MimeMessage message = new MimeMessage(session); // 用session为参数定义消息对象
        message.setFrom(new InternetAddress(sourceAddr)); // 加载发件人地址
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destAddr)); // 加载收件人地址
        message.setSubject(subject); // 加载标题
        Multipart multipart = new MimeMultipart(); // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
        BodyPart contentPart = new MimeBodyPart();
        contentPart.setText(text); // 设置邮件的文本内容
        multipart.addBodyPart(contentPart);
        message.setContent(multipart); // 将multipart对象放到message中
        message.saveChanges(); // 保存邮件
        Transport transport = session.getTransport("smtp"); // 发送邮件
        transport.connect(host, sourceAddr, pwd); // 连接服务器的邮箱
        transport.sendMessage(message, message.getAllRecipients()); // 发送邮件
        transport.close();
    }
}
