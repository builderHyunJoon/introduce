package org.builder.joon;

import org.builder.joon.dto.MailMessageDto;
import org.builder.joon.service.SendEmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BuilderjoonApplicationTests {

	@Autowired
    private SendEmailService sendEmailService;

	@Test
	void contextLoads() {
		MailMessageDto mailMessageDto = MailMessageDto.builder()
				.subject("Test subject for SMTP")
				.text("Test text for SMTP")
				.build();
		sendEmailService.sendMail(mailMessageDto);
	}

}
