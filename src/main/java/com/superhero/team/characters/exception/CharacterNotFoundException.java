package com.superhero.team.characters.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <b>Class</b>: CharacterNotFoundException <br/>.
 *
 * @author Carlos <br/>
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CharacterNotFoundException extends RuntimeException {
  public CharacterNotFoundException(String id) {
    super("Could not find character ".concat(id));
  }
}
