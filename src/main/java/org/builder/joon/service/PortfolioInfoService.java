package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.entity.PortfolioInfoEntity;
import org.builder.joon.repository.PortfolioInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioInfoService {

    private final PortfolioInfoRepository portfolioInfoRepository;

    public List<PortfolioInfoEntity> getAllPortfoliosWithAllData() {
        return portfolioInfoRepository.findAll();
    }

}
