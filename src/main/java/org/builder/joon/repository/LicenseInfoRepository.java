package org.builder.joon.repository;

import org.builder.joon.entity.LicenseInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LicenseInfoRepository  extends JpaRepository<LicenseInfoEntity, Long> {
    List<LicenseInfoEntity> findAllByOrderByLicenseIdxAsc();
}
