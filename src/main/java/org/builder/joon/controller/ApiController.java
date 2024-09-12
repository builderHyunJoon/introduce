package org.builder.joon.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.builder.joon.dto.MailMessageDto;
import org.builder.joon.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ApiController {

    private final EmailService emailService;

    @GetMapping("/healthcheck")
    public int healthcheck() {
        return HttpStatus.OK.value();
    }

    @PostMapping("/sendmail")
    public ResponseEntity<?> sendMail(@RequestBody MailMessageDto mailMessageDto) {
        log.error("Send mail with mailMessageDto: {}", mailMessageDto);
        try {
            emailService.sendEmailWithGoogleSMTP(mailMessageDto);
            log.info("Email sent successfully");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error sending mail", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
