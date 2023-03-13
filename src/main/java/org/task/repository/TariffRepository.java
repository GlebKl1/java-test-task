package org.task.repository;

import java.util.Optional;
import java.util.Set;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.task.entity.Tariff;

import java.util.UUID;

public interface TariffRepository extends JpaRepository<Tariff, UUID> {
  Set<Tariff> findAllByNameContainingIgnoreCase(String name);
  Set<Tariff> findAllByIsArchived(boolean isArchived);
  Optional<Tariff> findByName(String name);
  @Query(value = "select t from Tariff t left join fetch t.packageServices tps where tps.tariff.id = t.id and tps.category = 'INTERNET' and tps.value = -1")
  Set<Tariff> findAllByPackageServiceWithUnlimitedInternet();
  @Query(value = "select t from Tariff t left join fetch t.packageServices tps where t.id = tps.tariff.id and tps.category = 'CALLS' and tps.value = -1")
  Set<Tariff> findAllByPackageServiceWithUnlimitedCalls();
}
