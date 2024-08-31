package org.builder.joon.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "experience_info")
public class ExperienceInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long experienceIdx;

    private String experiencePeriod;
    private String experienceName;

}
