package org.builder.joon.repository;

import org.builder.joon.entity.PortfolioReferenceUrlInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioReferenceUrlInfoRepository extends JpaRepository<PortfolioReferenceUrlInfoEntity, Long> {
    List<PortfolioReferenceUrlInfoEntity> findByPortfolioNameOrderByPortfolioReferenceUrlIdxAsc(String portfolioName);
}
