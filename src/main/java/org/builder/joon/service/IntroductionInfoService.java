package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.entity.IntroductionInfoEntity;
import org.builder.joon.repository.IntroductionInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IntroductionInfoService {

    private final IntroductionInfoRepository introductionInfoRepository;

    public List<IntroductionInfoEntity> getAllIntroductions() {
        return introductionInfoRepository.findAll();
    }

}
