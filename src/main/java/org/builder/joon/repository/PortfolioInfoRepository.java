package org.builder.joon.repository;

import org.builder.joon.entity.PortfolioInfoEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PortfolioInfoRepository extends JpaRepository<PortfolioInfoEntity, Long> {
    @EntityGraph(value = "PortfolioInfoEntity.all", type = EntityGraph.EntityGraphType.LOAD)
    List<PortfolioInfoEntity> findAll();
}
