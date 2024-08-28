package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.entity.PortfolioImgInfoEntity;
import org.builder.joon.repository.PortfolioImgInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioImgInfoService {

    private final PortfolioImgInfoRepository portfolioImgInfoRepository;

    public List<PortfolioImgInfoEntity> getAllPortfolioImgs() {
        return portfolioImgInfoRepository.findAll();
    }
}
