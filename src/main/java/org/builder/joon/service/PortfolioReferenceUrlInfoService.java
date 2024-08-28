package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.entity.PortfolioReferenceUrlInfoEntity;
import org.builder.joon.repository.PortfolioReferenceUrlInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioReferenceUrlInfoService {

    private final PortfolioReferenceUrlInfoRepository portfolioReferenceUrlInfoRepository;

    public List<PortfolioReferenceUrlInfoEntity> getAllPortfolioReferenceUrls() {
        return portfolioReferenceUrlInfoRepository.findAll();
    }
}
