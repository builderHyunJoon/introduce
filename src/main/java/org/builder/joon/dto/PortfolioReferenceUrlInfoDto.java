package org.builder.joon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioReferenceUrlInfoDto {
    private Long portfolioReferenceUrlIdx;
    private String portfolioName;
    private String portfolioReferenceTitle;
    private String portfolioReferenceUrl;
}