package org.builder.joon.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "career_info")
public class CareerInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long careerIdx;

    private String careerPeriod;
    private String careerOrganization;
    private String careerTitle;
    private String careerExplain;

}
