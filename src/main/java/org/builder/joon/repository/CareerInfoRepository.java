package org.builder.joon.repository;

import org.builder.joon.entity.CareerInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CareerInfoRepository extends JpaRepository<CareerInfoEntity, Long> {
    List<CareerInfoEntity> findAllByOrderByCareerIdxAsc();
}
