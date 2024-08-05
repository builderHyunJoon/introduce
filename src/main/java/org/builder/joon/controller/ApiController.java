package org.builder.joon.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api")
public class ApiController {

    @GetMapping("/healthcheck")
    public int healthcheck() {
        return HttpStatus.OK.value();
    }
}
