package org.task.service;

import java.util.Set;
import java.util.UUID;
import org.task.entity.Tariff;

public interface TariffService {

  Tariff findById(UUID id);

  Tariff save(Tariff tariff);

  Set<Tariff> findAllByNameContaining(String name);

  Set<Tariff> findAllByUnlimitedInternetIncluded();

  Set<Tariff> findAllByUnlimitedCallsIncluded();

  Set<Tariff> findAllArchived(boolean isArchived);
}
