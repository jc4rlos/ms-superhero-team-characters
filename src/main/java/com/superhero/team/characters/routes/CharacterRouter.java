package com.superhero.team.characters.routes;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import com.superhero.team.characters.handlers.CharacterHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * <b>Class</b>: CharacterRouter <br/>.
 *
 * @author Carlos <br/>
 */
@Configuration
public class CharacterRouter {

  private static final RequestPredicate ROUTE_ACCEPT = accept(MediaType.APPLICATION_JSON);

  /**
   * charactersRoutes.
   *
   * @param characterHandler .
   * @return ServerResponse
   */
  @Bean
  public RouterFunction<ServerResponse> charactersRoutes(final CharacterHandler characterHandler) {
    return RouterFunctions.route()
            .path("/team-characters", builder -> builder
                    .POST("", ROUTE_ACCEPT, characterHandler::saveCharacter)
                    .GET("team/{teamId}", ROUTE_ACCEPT, characterHandler::findCharactersByTeamId)
                    .GET("{id}", ROUTE_ACCEPT, characterHandler::findCharacterById)
                    .DELETE("/{id}", ROUTE_ACCEPT, characterHandler::deleteCharacterById)
                    .DELETE("/team/{teamId}", ROUTE_ACCEPT, characterHandler::deleteCharactersByTeamId)
            ).build();
  }

}
