package org.builder.joon.repository;

import org.builder.joon.entity.UsedToolInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsedToolInfoRepository extends JpaRepository<UsedToolInfoEntity, Long> {
    List<UsedToolInfoEntity> findAllByOrderByUsedToolIdxAsc();
}
