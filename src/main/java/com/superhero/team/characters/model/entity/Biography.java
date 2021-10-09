package com.superhero.team.characters.model.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Class</b>: Biography <br/>.
 *
 * @author Carlos <br/>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Biography {
  private String fullName;
  private String publisher;
  private String alignment;
  private List<String> aliases;
}
