package org.task.controller;

import java.util.Set;
import java.util.UUID;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.task.entity.Tariff;
import org.task.service.TariffService;

@Path("/tariffs")
@Produces(MediaType.APPLICATION_JSON)
public class TariffController {

  @Inject
  protected TariffService tariffService;

  @GET
  @Path("/{id}")
  public Tariff findById(@PathParam(value = "id") UUID id) {
    return tariffService.findById(id);
  }

  @GET
  public Set<Tariff> findAll(
      @DefaultValue("false") @QueryParam(value = "isArchived") boolean isArchived) {
    return tariffService.findAllArchived(isArchived);
  }

  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public Tariff save(@Valid Tariff tariff) {
    return tariffService.save(tariff);
  }

  @GET
  @Path("/internet")
  public Set<Tariff> findAllWithUnlimitedInternetIncluded() {
    return tariffService.findAllByUnlimitedInternetIncluded();
  }

  @GET
  @Path("/calls")
  public Set<Tariff> findAllWithUnlimitedCallsIncluded() {
    return tariffService.findAllByUnlimitedCallsIncluded();
  }

}
