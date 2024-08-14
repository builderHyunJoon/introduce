package org.builder.joon.entity;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visitor_info")
public class VisitorInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ipAddress;
    private String requestUrl;
    private String referer;
    private String userAgent;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public static VisitorInfoEntity from(HttpServletRequest request) {
        return VisitorInfoEntity.builder()
                .ipAddress(StringUtils.isNotBlank(request.getHeader("X-Forwarded-For")) ?
                        "user: "+ request.getHeader("X-Forwarded-For") : "loadbalancer: " + request.getRemoteAddr())
                .requestUrl(request.getRequestURL().toString())
                .referer(request.getHeader("Referer"))
                .userAgent(request.getHeader("User-Agent"))
                .build();
    }
}


