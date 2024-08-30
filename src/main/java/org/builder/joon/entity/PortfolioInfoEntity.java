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
@NamedEntityGraph(name = "PortfolioInfoEntity.all",
        attributeNodes = {
                @NamedAttributeNode("portfolioToolInfoList"),
                @NamedAttributeNode("portfolioImgInfoList"),
                @NamedAttributeNode("portfolioReferenceUrlInfoList")
        })
public class PortfolioInfoEntity {

    @Id
    @Column(name = "portfolio_name")
    private String portfolioName;

    private Long portfolioIdx;
    private String portfolioSubject;
    private String portfolioTitle;
    private String portfolioSubtitle;
    private String portfolioExplain;

    @OneToMany(mappedBy = "portfolioInfoEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioToolInfoEntity> portfolioToolInfoList;

    @OneToMany(mappedBy = "portfolioInfoEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioImgInfoEntity> portfolioImgInfoList;

    @OneToMany(mappedBy = "portfolioInfoEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioReferenceUrlInfoEntity> portfolioReferenceUrlInfoList;
}
