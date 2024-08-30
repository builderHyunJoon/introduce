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
@Table(name = "portfolio_tool_info")
public class PortfolioToolInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioToolIdx;

    private String portfolioToolCategory;
    private String portfolioToolName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_name", referencedColumnName = "portfolio_name")
    private PortfolioInfoEntity portfolioInfoEntity;

}
