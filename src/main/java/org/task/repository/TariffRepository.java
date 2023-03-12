package org.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.task.entity.Tariff;

import java.util.UUID;

public interface TariffRepository extends JpaRepository<Tariff, UUID> {
}
