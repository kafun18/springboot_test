package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.PoliticsStatusMapper;
import org.javaboy.vhr.model.PoliticsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticsStatusService {
    @Autowired
    PoliticsStatusMapper politicsStatusMapper;

    public List<PoliticsStatus> getAllPoliticsStatus() {
        return politicsStatusMapper.getAllPoliticsStatus();
    }
}
