package org.builder.joon.repository;

import org.builder.joon.entity.PortfolioImgInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioImgInfoRepository extends JpaRepository<PortfolioImgInfoEntity, Long> {
    List<PortfolioImgInfoEntity> findByPortfolioNameOrderByPortfolioImgIdxAsc(String portfolioName);
}
