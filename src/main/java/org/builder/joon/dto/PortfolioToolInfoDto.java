package org.builder.joon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioToolInfoDto {
    private Long portfolioToolIdx;
    private String portfolioToolCategory;
    private String portfolioToolName;
}
