package org.builder.joon;

import lombok.extern.slf4j.Slf4j;
import org.builder.joon.dto.DynamoDto;
import org.builder.joon.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class BuilderjoonApplicationTests {

	@Autowired
    private EmailService sendEmailService;

	@Autowired
	private PortfolioInfoService portfolioInfoService;

	@Autowired
	private DynamoService dynamoService;

/*	@Test
	void smtpTest() {
		MailMessageDto mailMessageDto = MailMessageDto.builder()
				.subject("Test subject for SMTP")
				.message("Test text for SMTP")
				.build();
		sendEmailService.sendMail(mailMessageDto);
	}*/

/*	@Test
	void jpaTest() throws Exception {
		List<PortfolioInfoDto> portfolioInfoDtoList = portfolioInfoService.getAllPortfoliosWithAllData();
		log.info("portfolioInfoDtoList: {}", portfolioInfoDtoList);
	}*/

/*	@Test
	void dynamoTest() {
		List<DynamoDto> dynamoDtoList = dynamoService.scanDynamo();
		log.info("dynamoDtoList: {}", dynamoDtoList);
	}*/

}
