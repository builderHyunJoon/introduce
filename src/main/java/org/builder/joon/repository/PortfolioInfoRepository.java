package org.builder.joon.repository;

import org.builder.joon.entity.PortfolioInfoEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PortfolioInfoRepository extends JpaRepository<PortfolioInfoEntity, String> {
    List<PortfolioInfoEntity> findAllByOrderByPortfolioIdxAsc();
}
