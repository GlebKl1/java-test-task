package org.task.service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.task.entity.Tariff;
import org.task.exception.TariffNameAlreadyExistsException;
import org.task.exception.TariffNotFoundException;
import org.task.repository.PackageServiceRepository;
import org.task.repository.TariffRepository;

@Service
@RequiredArgsConstructor
@Transactional
@ApplicationScoped
public class TariffServiceImpl implements TariffService {

  private final TariffRepository tariffRepository;

  @Override
  public Tariff findById(UUID id) {
    return tariffRepository.findById(id)
        .orElseThrow(() -> new TariffNotFoundException(
            String.format("Tariff with id %s not found", id)));
  }

  @Override
  public Tariff save(Tariff tariff) {
    Optional<Tariff> byName = tariffRepository.findByName(tariff.getName());
    if (byName.isPresent()) {
      throw new TariffNameAlreadyExistsException(
          String.format("Tariff with name %s already exists", tariff.getName()));
    }
    tariff.getPackageServices().forEach(ps -> ps.setTariff(tariff));
    return tariffRepository.save(tariff);
  }

  @Override
  public Set<Tariff> findAllByNameContaining(String name) {
    return tariffRepository.findAllByNameContainingIgnoreCase(name);
  }

  @Override
  public Set<Tariff> findAllByUnlimitedInternetIncluded() {
    return tariffRepository.findAllByPackageServiceWithUnlimitedInternet();
  }

  @Override
  public Set<Tariff> findAllByUnlimitedCallsIncluded() {
    return tariffRepository.findAllByPackageServiceWithUnlimitedCalls();
  }

  @Override
  public Set<Tariff> findAllArchived(boolean isArchived) {
    return tariffRepository.findAllByIsArchived(isArchived);
  }
}
