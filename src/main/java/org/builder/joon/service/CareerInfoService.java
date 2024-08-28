package org.builder.joon.service;

import lombok.RequiredArgsConstructor;
import org.builder.joon.entity.CareerInfoEntity;
import org.builder.joon.repository.CareerInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CareerInfoService {
    private final CareerInfoRepository careerInfoRepository;

    public List<CareerInfoEntity> getAllCareers() {
        return careerInfoRepository.findAll();

    }
}
