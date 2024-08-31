package org.builder.joon.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "used_tool_info")
public class UsedToolInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usedToolIdx;

    private String usedToolCategory;
    private String usedToolName;

}
