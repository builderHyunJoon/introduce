package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.dto.MailMessageDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

	@Value("${spring.mail.username}")
	private String smtpMailAddress;

	@Value("${receive.mail.address}")
    private String receiveMailAddress;

	private final SesClient sesClient;

	private final JavaMailSender javaMailSender;

	public void sendEmailWithGoogleSMTP(MailMessageDto mailMessageDto) {
		log.info("send email with Google SMTP... messageDto: {}", mailMessageDto);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mailMessageDto.getFrom() + " <" + smtpMailAddress + ">");
		message.setTo(receiveMailAddress);
		message.setSubject(mailMessageDto.getName() + ": " + mailMessageDto.getSubject());
		message.setText(mailMessageDto.getText());
		javaMailSender.send(message);
	}

	public void sendEmailWithAwsSES(MailMessageDto mailMessageDto) {
		log.info("send email with AWS SES... messageDto: {}", mailMessageDto);
		Destination destination = Destination.builder()
				.toAddresses(receiveMailAddress)
				.build();
		Content content = Content.builder()
				.data(mailMessageDto.getText())
				.build();
		Message message = Message.builder()
				.subject(Content.builder().data(mailMessageDto.getSubject()).build())
				.body(Body.builder().html(content).build())
				.build();
		SendEmailRequest request = SendEmailRequest.builder()
				.destination(destination)
				.message(message)
				.source(mailMessageDto.getFrom())
				.build();
		sesClient.sendEmail(request);
	}
}
