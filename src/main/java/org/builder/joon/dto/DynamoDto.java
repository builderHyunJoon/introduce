package org.builder.joon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DynamoDto {
    private String dynamo_partition_key;
    private String titleName;
    private List<String> menuName;
    private Map<String, String> intro;
    private Map<String, String> profile;
    private Map<String, String> license;
    private Map<String, String> career;
    private Map<String, String> portfolio;
    private Map<String, String> contact;
}
