package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.dto.CareerInfoDto;
import org.builder.joon.entity.CareerInfoEntity;
import org.builder.joon.repository.CareerInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CareerInfoService {
    private final CareerInfoRepository careerInfoRepository;

    public List<CareerInfoDto> getAllCareers() {
        List<CareerInfoEntity> careerInfoEntityList = careerInfoRepository.findAllByOrderByCareerIdxAsc();

        return careerInfoEntityList.stream()
                .map(entity -> CareerInfoDto.builder()
                        .careerIdx(entity.getCareerIdx())
                        .careerPeriod(entity.getCareerPeriod())
                        .careerOrganization(entity.getCareerOrganization())
                        .careerTitle(entity.getCareerTitle())
                        .careerExplain(entity.getCareerExplain())
                        .build())
                .collect(Collectors.toList());
    }
}
