package org.builder.joon.repository;

import org.builder.joon.entity.IntroductionInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IntroductionInfoRepository extends JpaRepository<IntroductionInfoEntity, Long> {
    List<IntroductionInfoEntity> findAllByOrderByIntroductionIdxAsc();
}
