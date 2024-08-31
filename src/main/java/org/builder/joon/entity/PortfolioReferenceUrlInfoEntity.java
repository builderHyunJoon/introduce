package org.builder.joon.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "portfolio_reference_url_info")
public class PortfolioReferenceUrlInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioReferenceUrlIdx;

    private String portfolioName;
    private String portfolioReferenceTitle;
    private String portfolioReferenceUrl;

}
