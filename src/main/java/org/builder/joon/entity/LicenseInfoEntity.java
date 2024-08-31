package org.builder.joon.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
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
