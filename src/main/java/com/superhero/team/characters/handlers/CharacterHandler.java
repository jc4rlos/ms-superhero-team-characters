package com.superhero.team.characters.handlers;

import com.superhero.team.characters.exception.CharacterNotFoundException;
import com.superhero.team.characters.mappers.CharacterMapper;
import com.superhero.team.characters.model.dto.CharacterDto;
import com.superhero.team.characters.repository.CharacterRepository;
import com.superhero.team.characters.utils.ResponseUtil;

import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: CharacterHandler <br/>.
 *
 * @author Carlos <br/>
 */
@Component
@RequiredArgsConstructor
public class CharacterHandler {

  private final CharacterRepository characterRepository;
  private final CharacterMapper characterMapper;

  /**
   * saveCharacter.
   *
   * @param request .
   * @return ServerResponse
   */
  public Mono<ServerResponse> saveCharacter(final ServerRequest request) {
    return request.bodyToMono(CharacterDto.class)
            .map(characterMapper::characterDtoToCharacter)
            .flatMap(characterRepository::save)
            .map(characterMapper::characterToCharacterDto)
            .flatMap(ResponseUtil::ok);
  }

  /**
   * findCharacterById.
   *
   * @param request .
   * @return ServerResponse
   */
  public Mono<ServerResponse> findCharacterById(final ServerRequest request) {
    final var characterId = request.pathVariable("id");
    return characterRepository.findById(characterId)
            .map(characterMapper::characterToCharacterDto)
            .flatMap(ResponseUtil::ok)
            .switchIfEmpty(Mono.error(new CharacterNotFoundException(characterId)));
  }

  /**
   * findCharactersByTeamId.
   *
   * @param request .
   * @return ServerResponse
   */
  public Mono<ServerResponse> findCharactersByTeamId(final ServerRequest request) {
    final var teamId = request.pathVariable("teamId");
    return characterRepository.findByTeamId(Long.parseLong(teamId)).collectList()
            .map(characters -> characters.stream()
                    .map(characterMapper::characterToCharacterDto)
                    .collect(Collectors.toList()))
            .flatMap(ResponseUtil::ok)
            .switchIfEmpty(Mono.error(new CharacterNotFoundException(teamId)));

  }

  /**
   * deleteCharacterById .
   *
   * @param request .
   * @return ServerResponse
   */
  public Mono<ServerResponse> deleteCharacterById(final ServerRequest request) {
    final var characterId = request.pathVariable("id");
    return characterRepository.findById(characterId)
            .flatMap(character -> characterRepository.delete(character).then(Mono.just(character)))
            .map(characterMapper::characterToCharacterDto)
            .flatMap(ResponseUtil::ok)
            .switchIfEmpty(Mono.error(new CharacterNotFoundException(characterId)));
  }

  /**
   * deleteCharactersByTeamId.
   *
   * @param request .
   * @return ServerResponse
   */
  public Mono<ServerResponse> deleteCharactersByTeamId(final ServerRequest request) {
    final var teamId = request.pathVariable("teamId");
    return characterRepository.findByTeamId(Long.parseLong(teamId)).collectList()
            .flatMap(characters -> characterRepository.deleteAll(characters).then(Mono.just(teamId)))
            .flatMap(ResponseUtil::ok)
            .switchIfEmpty(Mono.error(new CharacterNotFoundException(teamId)));
  }


}
