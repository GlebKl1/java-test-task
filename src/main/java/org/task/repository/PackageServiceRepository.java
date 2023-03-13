package org.task.repository;

import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.task.entity.PackageService;

import java.util.UUID;
import org.task.enums.Category;

public interface PackageServiceRepository extends JpaRepository<PackageService, UUID> {
  Set<PackageService> findAllByCategoryEqualsAndValueEquals(Category category, Integer value);
}
