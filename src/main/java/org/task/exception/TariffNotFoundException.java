package org.task.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TariffNotFoundException extends RuntimeException{
  private int status = 404;

  public TariffNotFoundException(String message) {
    super(message);
  }
}
