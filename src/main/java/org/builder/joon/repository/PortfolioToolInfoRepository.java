package org.builder.joon.repository;

import org.builder.joon.entity.PortfolioToolInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioToolInfoRepository extends JpaRepository<PortfolioToolInfoEntity, Long> {
    List<PortfolioToolInfoEntity> findByPortfolioNameOrderByPortfolioToolIdxAsc(String portfolioName);
}
