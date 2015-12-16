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

//		String smtp = "smtp.163.com";// smtp������
//
//		String from = "thankyouwl@163.com";// �ʼ���ʾ����
//
//		String to = "572546226@qq.com";// �ռ��˵��ʼ���ַ����������ʵ��ַ
//
//		String copyto = "";// �������ʼ���ַ
//
//		String subject = "�����ʼ�";// �ʼ�����
//
//		String content = "��ã�";// �ʼ�����
//
//		String username = "jiachengyu";// ��������ʵ���˻���
//
//		String password = "newpass533925";// ����������
//
//		Mail.sendAndCc(smtp, from, to, copyto, subject, content, username, password);
		
		sendMail("smtp.qq.com", "jcy533925", "cjia@eclassmate.cn", "572546226@qq.com", "test", "www.baidu.com");
		
		
	}

	public static void sendMail(String host, String pwd, String sourceAddr, String destAddr,
            String subject, String text) throws AddressException, MessagingException
    {
        Properties props = new Properties();
        props.put("mail.smtp.host", host); // ���÷����ʼ����ʼ�������������
        props.put("mail.smtp.auth", "true"); // ��Ҫ������Ȩ��֤
        Session session = Session.getDefaultInstance(props); // ����һ��session
        session.setDebug(true); // console����ʾ������Ϣ

        MimeMessage message = new MimeMessage(session); // ��sessionΪ����������Ϣ����
        message.setFrom(new InternetAddress(sourceAddr)); // ���ط����˵�ַ
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destAddr)); // �����ռ��˵�ַ
        message.setSubject(subject); // ���ر���
        Multipart multipart = new MimeMultipart(); // ��multipart����������ʼ��ĸ����������ݣ������ı����ݺ͸���
        BodyPart contentPart = new MimeBodyPart();
        contentPart.setText(text); // �����ʼ����ı�����
        multipart.addBodyPart(contentPart);
        message.setContent(multipart); // ��multipart����ŵ�message��
        message.saveChanges(); // �����ʼ�
        Transport transport = session.getTransport("smtp"); // �����ʼ�
        transport.connect(host, sourceAddr, pwd); // ���ӷ�����������
        transport.sendMessage(message, message.getAllRecipients()); // �����ʼ�
        transport.close();
    }
}
