package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.dto.UsedToolInfoDto;
import org.builder.joon.entity.UsedToolInfoEntity;
import org.builder.joon.repository.UsedToolInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsedToolInfoService {
    private final UsedToolInfoRepository usedToolInfoRepository;

    public List<UsedToolInfoDto> getAllUsedTools() {
        List<UsedToolInfoEntity> usedToolInfoEntityList = usedToolInfoRepository.findAllByOrderByUsedToolIdxAsc();

        return usedToolInfoEntityList.stream()
                .map(entity -> UsedToolInfoDto.builder()
                        .usedToolIdx(entity.getUsedToolIdx())
                        .usedToolCategory(entity.getUsedToolCategory())
                        .usedToolName(entity.getUsedToolName())
                        .build())
                .collect(Collectors.toList());
    }
}
