package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.dto.DynamoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DynamoService {

    @Value("${dynamodb.table.name}")
    private String dynamoTableName;

    private final DynamoDbClient dynamoDbClient;

    public List<DynamoDto> scanDynamo() {
        ScanRequest scanRequest = ScanRequest.builder()
                .tableName(dynamoTableName)
                .build();

        ScanResponse scanResponse = dynamoDbClient.scan(scanRequest);

        return scanResponse.items().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private DynamoDto mapToDto(Map<String, AttributeValue> item) {
        return DynamoDto.builder()
                .dynamo_partition_key(item.get("dynamo_partition_key").s())
                .titleName(item.get("titleName").s())
                .menuName(item.get("menuName").l().stream()
                        .map(AttributeValue::s)
                        .collect(Collectors.toList()))
                .intro(convertMap(item.get("intro").m()))
                .profile(convertMap(item.get("profile").m()))
                .license(convertMap(item.get("license").m()))
                .career(convertMap(item.get("career").m()))
                .portfolio(convertMap(item.get("portfolio").m()))
                .contact(convertMap(item.get("contact").m()))
                .build();
    }

    private Map<String, String> convertMap(Map<String, AttributeValue> attributeValueMap) {
        return attributeValueMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().s() != null ? entry.getValue().s() : entry.getValue().toString()
                ));
    }
}
