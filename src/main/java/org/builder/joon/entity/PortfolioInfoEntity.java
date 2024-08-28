package org.builder.joon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "portfolio_info")
public class PortfolioInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioIdx;

    private String portfolioName;
    private String portfolioSubject;
    private String portfolioTitle;
    private String portfolioSubtitle;
    private String portfolioExplain;

    @OneToMany(mappedBy = "portfolioName", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioToolInfoEntity> portfolioToolInfoList;

    @OneToMany(mappedBy = "portfolioName", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioImgInfoEntity> portfolioImgInfoList;

    @OneToMany(mappedBy = "portfolioName", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioReferenceUrlInfoEntity> portfolioReferenceUrlInfoList;
}
