package org.builder.joon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioInfoDto {
    private String portfolioName;
    private Long portfolioIdx;
    private String portfolioSubject;
    private String portfolioTitle;
    private String portfolioSubtitle;
    private String portfolioExplain;

    List<PortfolioImgInfoDto> portfolioImgInfoDtoList;
    List<PortfolioToolInfoDto> portfolioToolInfoDtoList;
    List<PortfolioReferenceUrlInfoDto> portfolioReferenceUrlInfoDtoList;

}
