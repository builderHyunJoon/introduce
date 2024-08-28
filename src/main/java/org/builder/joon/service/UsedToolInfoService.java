package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.entity.UsedToolInfoEntity;
import org.builder.joon.repository.UsedToolInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsedToolInfoService {
    private final UsedToolInfoRepository usedToolInfoRepository;

    public List<UsedToolInfoEntity> getAllUsedTools() {
        return usedToolInfoRepository.findAll();
    }

}
