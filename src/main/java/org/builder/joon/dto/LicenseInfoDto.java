package org.builder.joon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LicenseInfoDto {
    private Long licenseIdx;
    private String licenseName;
    private String licenseAcquireDate;
    private String licenseNumber;
    private String licenseExplain;
}
