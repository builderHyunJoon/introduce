package org.builder.joon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "license_info")
public class LicenseInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long licenseIdx;

    private String licenseName;
    private String licenseAcquireDate;
    private String licenseNumber;
    private String licenseExplain;

}
