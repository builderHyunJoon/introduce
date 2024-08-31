package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.dto.LicenseInfoDto;
import org.builder.joon.entity.LicenseInfoEntity;
import org.builder.joon.repository.LicenseInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LicenseInfoService {

    private final LicenseInfoRepository licenseInfoRepository;

    public List<LicenseInfoDto> getAllLicenses() {
        List<LicenseInfoEntity> licenseInfoEntityList = licenseInfoRepository.findAllByOrderByLicenseIdxAsc();

        return licenseInfoEntityList.stream()
                .map(entity -> LicenseInfoDto.builder()
                        .licenseIdx(entity.getLicenseIdx())
                        .licenseName(entity.getLicenseName())
                        .licenseAcquireDate(entity.getLicenseAcquireDate())
                        .licenseNumber(entity.getLicenseNumber())
                        .licenseExplain(entity.getLicenseExplain())
                        .build())
                .collect(Collectors.toList());
    }

}
