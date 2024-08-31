package org.builder.joon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IntroductionInfoDto {
    private Long introductionIdx;
    private String introductionTitle;
    private String introductionExplain;
}
