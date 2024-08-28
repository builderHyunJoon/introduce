package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.entity.ExperienceInfoEntity;
import org.builder.joon.repository.ExperienceInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceInfoService {

    private  final ExperienceInfoRepository experienceInfoRepository;

    public List<ExperienceInfoEntity> getAllExperiences() {
        return experienceInfoRepository.findAll();
    }

}
