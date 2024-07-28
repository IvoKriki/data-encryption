package com.backend.data.encryption.repository;

import com.backend.data.encryption.entity.SensitiveData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensitiveDataRepository extends JpaRepository<SensitiveData, Long> {
}
