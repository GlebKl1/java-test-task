package org.task.exception.handlers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.task.exception.TariffNotFoundException;

@Provider
public class TariffNotFoundExceptionHandler implements ExceptionMapper<TariffNotFoundException> {

  @Override
  public Response toResponse(TariffNotFoundException e) {
    return Response.status(e.getStatus())
        .entity(e.getMessage())
        .build();
  }
}
