package org.builder.joon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsedToolInfoDto {
    private Long usedToolIdx;
    private String usedToolCategory;
    private String usedToolName;
}
