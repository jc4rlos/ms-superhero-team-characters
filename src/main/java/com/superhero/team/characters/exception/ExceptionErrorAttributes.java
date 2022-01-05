package com.superhero.team.characters.exception;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;

import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

/**
 * <b>Class</b>: ExceptionErrorAttributes <br/>.
 *
 * @author Carlos <br/>
 */
@Component
public class ExceptionErrorAttributes extends DefaultErrorAttributes {

  @Override
  public Map<String, Object> getErrorAttributes(final ServerRequest request, final ErrorAttributeOptions options) {
    final var errorMap = super.getErrorAttributes(request, options);
    final var exception = getError(request);
    if (exception instanceof CharacterNotFoundException) {
      errorMap.put("message", exception.getMessage());
      return errorMap;
    }
    errorMap.put("exception", "SystemException");
    errorMap.put("message", exception.getMessage());
    errorMap.put("status", "500");
    errorMap.put("error", " System Error ");
    return errorMap;
  }
}
