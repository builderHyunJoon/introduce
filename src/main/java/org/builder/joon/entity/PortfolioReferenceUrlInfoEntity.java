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
@Table(name = "portfolio_reference_url_info")
public class PortfolioReferenceUrlInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioReferenceUrlIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_name", referencedColumnName = "portfolio_name")
    private PortfolioInfoEntity portfolioName;

    private String portfolioReferenceTitle;
    private String portfolioReferenceUrl;

}
