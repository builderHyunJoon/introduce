package org.builder.joon.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.builder.joon.dto.*;
import org.builder.joon.entity.VisitorInfoEntity;
import org.builder.joon.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class WebController {

    private final VisitorInfoService visitorInfoService;
    private final CareerInfoService careerInfoService;
    private final ExperienceInfoService experienceInfoService;
    private final IntroductionInfoService introductionInfoService;
    private final LicenseInfoService licenseInfoService;
    private final UsedToolInfoService usedToolInfoService;
    private final PortfolioInfoService portfolioInfoService;

    @GetMapping("/")
    public String redirectToMain(HttpServletRequest request) {
        VisitorInfoEntity visitorInfoEntity = VisitorInfoEntity.from(request);
        log.info("Accessed root path... Visitor info: {}", visitorInfoEntity);
        visitorInfoService.saveVisitorInfo(visitorInfoEntity);
        return "redirect:/resume";
    }

    @GetMapping("/resume")
    public String mainWeb(Model model) throws Exception {

        model.addAttribute("careerList", careerInfoService.getAllCareers());
        model.addAttribute("experienceList", experienceInfoService.getAllExperiences());
        model.addAttribute("introductionList", introductionInfoService.getAllIntroductions());
        model.addAttribute("licenseList", licenseInfoService.getAllLicenses());
        model.addAttribute("usedToolList", usedToolInfoService.getAllUsedTools());
        model.addAttribute("portfolioList", portfolioInfoService.getAllPortfoliosWithAllData());

        return "resume";
    }
}
