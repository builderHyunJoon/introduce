package org.builder.joon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.builder.joon.dto.MailMessageDto;

@Entity
@Builder
@Table(name = "email_info")
@NoArgsConstructor
@AllArgsConstructor
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_idx")
    private Long emailIdx;

    private String emailFrom;
    private String emailName;
    private String emailSubject;
    private String emailText;

    public static EmailEntity toEntity(MailMessageDto dto) {
        return EmailEntity.builder()
                .emailFrom(dto.getFrom())
                .emailName(dto.getName())
                .emailSubject(dto.getSubject())
                .emailText(dto.getText())
                .build();
    }
}
