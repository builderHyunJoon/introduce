package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.entity.PortfolioToolInfoEntity;
import org.builder.joon.repository.PortfolioToolInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioToolInfoService {

    private final PortfolioToolInfoRepository portfolioToolInfoRepository;

    public List<PortfolioToolInfoEntity> getAllPortfolioTools(String portfolioName) {
        return portfolioToolInfoRepository.findByPortfolioNameOrderByPortfolioToolIdxAsc(portfolioName);
    }
}
