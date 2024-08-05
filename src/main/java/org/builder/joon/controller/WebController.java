package org.builder.joon.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("introduce")
public class WebController {

    @GetMapping("/main")
    public String mainWeb(Model model) {
        return "main";
    }
}
