package com.superhero.team.characters.model.dto;

import com.superhero.team.characters.model.entity.Appearance;
import com.superhero.team.characters.model.entity.Biography;
import com.superhero.team.characters.model.entity.Image;
import com.superhero.team.characters.model.entity.PowerStats;
import com.superhero.team.characters.model.entity.Work;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Class</b>: CharacterDto <br/>.
 *
 * @author Carlos <br/>
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDto {
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
