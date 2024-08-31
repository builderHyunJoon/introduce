package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.dto.IntroductionInfoDto;
import org.builder.joon.entity.IntroductionInfoEntity;
import org.builder.joon.repository.IntroductionInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IntroductionInfoService {

    private final IntroductionInfoRepository introductionInfoRepository;

    public List<IntroductionInfoDto> getAllIntroductions() {
        List<IntroductionInfoEntity> introductionInfoEntityList = introductionInfoRepository.findAllByOrderByIntroductionIdxAsc();

        return introductionInfoEntityList.stream()
                .map(entity -> IntroductionInfoDto.builder()
                        .introductionIdx(entity.getIntroductionIdx())
                        .introductionTitle(entity.getIntroductionTitle())
                        .introductionExplain(entity.getIntroductionExplain())
                        .build())
                .collect(Collectors.toList());
    }

}
