package org.builder.joon.service;

import org.builder.joon.dto.MailMessageDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SendEmailService {

	@Value("${spring.mail.username}")
    private String mailAddress;

	private final JavaMailSender javaMailSender;

	public SendEmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendMail(MailMessageDto mailMessageDto) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mailMessageDto.getFrom());
		message.setTo(mailAddress);
		message.setSubject(mailMessageDto.getSubject());
		message.setText(mailMessageDto.getText());
		javaMailSender.send(message);
		log.info("Email sent successfully with message: {}", message);
	}
}
