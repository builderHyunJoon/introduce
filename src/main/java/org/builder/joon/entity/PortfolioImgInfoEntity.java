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
@Table(name = "portfolio_img_info")
public class PortfolioImgInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioImgIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_name", referencedColumnName = "portfolio_name")
    private PortfolioInfoEntity portfolioName;

    private String portfolioImgUrl;
    private String portfolioImgAlt;

}
