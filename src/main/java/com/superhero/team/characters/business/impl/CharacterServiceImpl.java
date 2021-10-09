package com.superhero.team.characters.business.impl;

import com.superhero.team.characters.business.CharacterService;
import com.superhero.team.characters.mappers.CharacterMapper;
import com.superhero.team.characters.model.dto.CharacterDto;
import com.superhero.team.characters.repository.CharacterRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: CharacterServiceImpl <br/>.
 *
 * @author Carlos <br/>
 */
@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

  private final CharacterRepository characterRepository;
  private final CharacterMapper characterMapper;

  @Override
  public Mono<CharacterDto> saveCharacter(final Mono<CharacterDto> characterDtoMono) {
    return characterDtoMono.map(characterMapper::characterDtoToCharacter)
            .flatMap(characterRepository::insert)
            .map(characterMapper::characterToCharacterDto);
  }

}
