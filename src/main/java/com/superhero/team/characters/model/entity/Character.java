package com.superhero.team.characters.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <b>Class</b>: Character <br/>.
 *
 * @author Carlos <br/>
 */
@Data
@Document(collection = "characters")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Character {

  @Id
  private String id;
  private Long teamId;
  private Integer superheroId;
  private String name;
  private Image image;
  private PowerStats powerStats;
  private Biography biography;
  private Appearance appearance;
  private Work work;
}
