package org.task.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TariffNameAlreadyExistsException extends RuntimeException{
  private int status = 400;

  public TariffNameAlreadyExistsException(String message) {
    super(message);
  }
}
