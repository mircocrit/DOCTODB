package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Assistant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AssistantRepository extends JpaRepository<Assistant, Integer> {
    void deleteAssistantById(Long id);
    Optional<Assistant> findAssistantById(Long id);
}
