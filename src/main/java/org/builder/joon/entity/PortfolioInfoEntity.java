package org.builder.joon.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "portfolio_info")
public class PortfolioInfoEntity {

    @Id
    @Column(name = "portfolio_name")
    private String portfolioName;

    private Long portfolioIdx;
    private String portfolioSubject;
    private String portfolioTitle;
    private String portfolioSubtitle;
    private String portfolioExplain;

}