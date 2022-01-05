package com.superhero.team.characters.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Class</b>: Appearance <br/>.
 *
 * @author Carlos <br/>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appearance {
  private String gender;
  private String race;
  private String height;
  private String weight;
}
