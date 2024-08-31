package org.builder.joon.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "portfolio_img_info")
public class PortfolioImgInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioImgIdx;

    private String portfolioName;
    private String portfolioImgUrl;
    private String portfolioImgAlt;


}
