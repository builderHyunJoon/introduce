package org.builder.joon.repository;

import org.builder.joon.entity.ExperienceInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceInfoRepository extends JpaRepository<ExperienceInfoEntity, Long> {
    List<ExperienceInfoEntity> findAllByOrderByExperienceIdxAsc();
}
