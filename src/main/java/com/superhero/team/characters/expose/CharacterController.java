package com.superhero.team.characters.expose;

import com.superhero.team.characters.business.impl.CharacterServiceImpl;
import com.superhero.team.characters.model.dto.CharacterDto;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: CharacterController <br/>.
 *
 * @author Carlos <br/>
 */
@RestController
@RequestMapping("/v1/characters")
@RequiredArgsConstructor
public class CharacterController {

  private final CharacterServiceImpl characterService;

  @PostMapping
  public Mono<ResponseEntity<CharacterDto>> saveCharacter(@RequestBody final Mono<CharacterDto> characterDtoMono) {
    return characterService.saveCharacter(characterDtoMono).map(ResponseEntity::ok);
  }

}
