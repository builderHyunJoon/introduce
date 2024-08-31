package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.dto.PortfolioImgInfoDto;
import org.builder.joon.dto.PortfolioInfoDto;
import org.builder.joon.dto.PortfolioReferenceUrlInfoDto;
import org.builder.joon.dto.PortfolioToolInfoDto;
import org.builder.joon.entity.PortfolioInfoEntity;
import org.builder.joon.repository.PortfolioImgInfoRepository;
import org.builder.joon.repository.PortfolioInfoRepository;
import org.builder.joon.repository.PortfolioReferenceUrlInfoRepository;
import org.builder.joon.repository.PortfolioToolInfoRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortfolioInfoService {

    private final PortfolioInfoRepository portfolioInfoRepository;
    private final PortfolioImgInfoRepository portfolioImgInfoRepository;
    private final PortfolioToolInfoRepository portfolioToolInfoRepository;
    private final PortfolioReferenceUrlInfoRepository portfolioReferenceUrlInfoRepository;

    public List<PortfolioInfoDto> getAllPortfoliosWithAllData() {
        List<PortfolioInfoEntity> portfolioInfoEntityList = portfolioInfoRepository.findAllByOrderByPortfolioIdxAsc();

        return portfolioInfoEntityList.stream().map(portfolioInfoEntity -> {
            List<PortfolioImgInfoDto> portfolioImgInfoDtoList =
                    portfolioImgInfoRepository.findByPortfolioNameOrderByPortfolioImgIdxAsc(portfolioInfoEntity.getPortfolioName())
                    .stream()
                    .map(imgEntity -> PortfolioImgInfoDto.builder()
                            .portfolioImgIdx(imgEntity.getPortfolioImgIdx())
                            .portfolioName(imgEntity.getPortfolioName())
                            .portfolioImgUrl(imgEntity.getPortfolioImgUrl())
                            .portfolioImgAlt(imgEntity.getPortfolioImgAlt())
                            .build())
                    .collect(Collectors.toList());

            List<PortfolioToolInfoDto> portfolioToolInfoDtoList =
                    portfolioToolInfoRepository.findByPortfolioNameOrderByPortfolioToolIdxAsc(portfolioInfoEntity.getPortfolioName())
                    .stream()
                    .map(toolEntity -> PortfolioToolInfoDto.builder()
                            .portfolioToolIdx(toolEntity.getPortfolioToolIdx())
                            .portfolioName(toolEntity.getPortfolioName())
                            .portfolioToolCategory(toolEntity.getPortfolioToolCategory())
                            .portfolioToolName(toolEntity.getPortfolioToolName())
                            .build())
                    .collect(Collectors.toList());

            List<PortfolioReferenceUrlInfoDto> portfolioReferenceUrlInfoDtoList =
                    portfolioReferenceUrlInfoRepository.findByPortfolioNameOrderByPortfolioReferenceUrlIdxAsc(portfolioInfoEntity.getPortfolioName())
                    .stream()
                    .map(urlEntity -> PortfolioReferenceUrlInfoDto.builder()
                            .portfolioReferenceUrlIdx(urlEntity.getPortfolioReferenceUrlIdx())
                            .portfolioName(urlEntity.getPortfolioName())
                            .portfolioReferenceTitle(urlEntity.getPortfolioReferenceTitle())
                            .portfolioReferenceUrl(urlEntity.getPortfolioReferenceUrl())
                            .build())
                    .collect(Collectors.toList());

            return PortfolioInfoDto.builder()
                    .portfolioName(portfolioInfoEntity.getPortfolioName())
                    .portfolioIdx(portfolioInfoEntity.getPortfolioIdx())
                    .portfolioSubject(portfolioInfoEntity.getPortfolioSubject())
                    .portfolioTitle(portfolioInfoEntity.getPortfolioTitle())
                    .portfolioSubtitle(portfolioInfoEntity.getPortfolioSubtitle())
                    .portfolioExplain(portfolioInfoEntity.getPortfolioExplain())
                    .portfolioImgInfoDtoList(portfolioImgInfoDtoList)
                    .portfolioToolInfoDtoList(portfolioToolInfoDtoList)
                    .portfolioReferenceUrlInfoDtoList(portfolioReferenceUrlInfoDtoList)
                    .build();
        }).collect(Collectors.toList());
    }

}
