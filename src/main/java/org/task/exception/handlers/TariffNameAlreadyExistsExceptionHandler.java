package org.task.exception.handlers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.task.exception.TariffNameAlreadyExistsException;

@Provider
public class TariffNameAlreadyExistsExceptionHandler implements ExceptionMapper<TariffNameAlreadyExistsException> {

  @Override
  public Response toResponse(TariffNameAlreadyExistsException e) {
    return Response.status(e.getStatus())
        .entity(e.getMessage())
        .build();
  }
}
