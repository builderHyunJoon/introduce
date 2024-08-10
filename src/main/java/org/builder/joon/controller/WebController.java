package org.builder.joon.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.builder.joon.entity.VisitorInfoEntity;
import org.builder.joon.service.VisitorInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class WebController {

    private final VisitorInfoService visitorInfoService;

    @GetMapping("/")
    public String redirectToMain(HttpServletRequest request) {
        VisitorInfoEntity visitorInfoEntity = VisitorInfoEntity.from(request);
        log.info("VISITOR_INFO_ENTITY: {}", visitorInfoEntity);
        visitorInfoService.saveVisitorInfo(visitorInfoEntity);
        return "redirect:/introduce";
    }


    @GetMapping("/introduce")
    public String mainWeb() {
        return "introduce";
    }
}
