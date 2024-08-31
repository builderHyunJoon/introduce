package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.dto.ExperienceInfoDto;
import org.builder.joon.entity.ExperienceInfoEntity;
import org.builder.joon.repository.ExperienceInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExperienceInfoService {

    private final ExperienceInfoRepository experienceInfoRepository;

    public List<ExperienceInfoDto> getAllExperiences() {
        List<ExperienceInfoEntity> experienceInfoEntityList = experienceInfoRepository.findAllByOrderByExperienceIdxAsc();

        return experienceInfoEntityList.stream()
                .map(entity -> ExperienceInfoDto.builder()
                        .experienceIdx(entity.getExperienceIdx())
                        .experiencePeriod(entity.getExperiencePeriod())
                        .experienceName(entity.getExperienceName())
                        .build())
                .collect(Collectors.toList());
    }

}
