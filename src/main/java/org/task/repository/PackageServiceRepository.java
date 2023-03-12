package org.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.task.entity.PackageService;

import java.util.UUID;

public interface PackageServiceRepository extends JpaRepository<PackageService, UUID> {
}
