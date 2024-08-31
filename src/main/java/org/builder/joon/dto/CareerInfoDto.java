package org.builder.joon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CareerInfoDto {
    private Long careerIdx;
    private String careerPeriod;
    private String careerOrganization;
    private String careerTitle;
    private String careerExplain;
}
