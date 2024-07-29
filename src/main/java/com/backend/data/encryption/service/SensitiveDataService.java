package com.backend.data.encryption.service;

import com.backend.data.encryption.entity.SensitiveData;
import com.backend.data.encryption.repository.SensitiveDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensitiveDataService {

    @Autowired
    private SensitiveDataRepository sensitiveDataRepository;

    public List<SensitiveData> findAll(){
        return sensitiveDataRepository.findAll();
    }

    public SensitiveData save(SensitiveData data){
        return sensitiveDataRepository.save(data);
    }

    public void deleteById(Long id){
        sensitiveDataRepository.deleteById(id);
    }
}
