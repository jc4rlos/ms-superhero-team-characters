package com.superhero.team.characters.repository;

import com.superhero.team.characters.model.entity.Character;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * <b>Class</b>: CharacterRepository <br/>.
 *
 * @author Carlos <br/>
 */
@Repository
public interface CharacterRepository extends ReactiveMongoRepository<Character, String> {

  Flux<Character> findByTeamId(Long teamId);
}
