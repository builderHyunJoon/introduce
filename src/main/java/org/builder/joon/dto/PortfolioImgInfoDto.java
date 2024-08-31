package org.builder.joon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioImgInfoDto {
    private Long portfolioImgIdx;
    private String portfolioName;
    private String portfolioImgUrl;
    private String portfolioImgAlt;
}
