package com.superhero.team.characters.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Class</b>: PowerStats <br/>.
 *
 * @author Carlos <br/>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PowerStats {
  private Integer intelligence;
  private Integer strength;
  private Integer speed;
  private Integer durability;
  private Integer power;
  private Integer combat;
}
