package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.entity.VisitorInfoEntity;
import org.builder.joon.repository.VisitorInfoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitorInfoService {

    private final VisitorInfoRepository visitorInfoRepository;

    public void saveVisitorInfo(VisitorInfoEntity visitorInfoEntity) {
        visitorInfoRepository.save(visitorInfoEntity);
    }

}
