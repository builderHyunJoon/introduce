package org.builder.joon.entity;

import jakarta.persistence.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua_parser.Client;
import ua_parser.Parser;

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
    private String browser;
    private String os;
    private String device;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public static VisitorInfoEntity from(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        Parser parser = new Parser();
        Client client = parser.parse(userAgent);

        return VisitorInfoEntity.builder()
                .ipAddress(request.getRemoteAddr())
                .requestUrl(request.getRequestURL().toString())
                .referer(request.getHeader("Referer"))
                .browser(client.userAgent.family + " " + client.userAgent.major + "." + client.userAgent.minor)
                .os(client.os.family + " " + client.os.major + "." + client.os.minor)
                .device(client.device.family)
                .build();
    }
}


