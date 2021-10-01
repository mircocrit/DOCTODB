package com.javatechie.jpa.repository;

import com.javatechie.jpa.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    void deleteServiceById(Long id);
    Optional<Service> findServiceById(Long id);
}
