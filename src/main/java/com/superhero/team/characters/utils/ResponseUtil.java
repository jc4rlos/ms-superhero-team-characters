package com.superhero.team.characters.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: ResponseUtil <br/>.
 *
 * @author Carlos <br/>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResponseUtil {

  public static final Mono<ServerResponse> notFound = ServerResponse.notFound().build();

  /**
   * ok .
   *
   * @param result .
   * @return ServerResponse
   */
  public static <T> Mono<ServerResponse> ok(T result) {
    return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(result));
  }
}
