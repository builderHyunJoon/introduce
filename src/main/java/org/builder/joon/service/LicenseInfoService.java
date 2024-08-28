package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.entity.LicenseInfoEntity;
import org.builder.joon.repository.LicenseInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LicenseInfoService {

    private final LicenseInfoRepository licenseInfoRepository;

    public List<LicenseInfoEntity> getAllLicenses() {
        return licenseInfoRepository.findAll();
    }

}
