package com.superhero.team.characters.business;

import com.superhero.team.characters.model.dto.CharacterDto;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: CharacterService <br/>.
 *
 * @author Carlos <br/>
 */
public interface CharacterService {
  Mono<CharacterDto> saveCharacter(Mono<CharacterDto> characterDtoMono);
}
