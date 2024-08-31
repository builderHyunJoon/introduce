package org.builder.joon.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "introduction_info")
public class IntroductionInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long introductionIdx;

    private String introductionTitle;
    private String introductionExplain;

}
