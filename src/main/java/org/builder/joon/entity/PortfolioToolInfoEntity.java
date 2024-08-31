package org.builder.joon.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "portfolio_tool_info")
public class PortfolioToolInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioToolIdx;

    private String portfolioName;
    private String portfolioToolCategory;
    private String portfolioToolName;

}
