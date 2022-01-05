package com.superhero.team.characters.mappers;

import com.superhero.team.characters.model.dto.CharacterDto;
import com.superhero.team.characters.model.entity.Character;
import org.mapstruct.Mapper;

/**
 * <b>Class</b>: CharacterMapper <br/>.
 *
 * @author Carlos <br/>
 */
@Mapper(componentModel = "spring")
public interface CharacterMapper {
  Character characterDtoToCharacter(CharacterDto characterDto);

  CharacterDto characterToCharacterDto(Character character);

}
