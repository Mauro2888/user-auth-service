package mauro.service.userauthservice.mapper;

import mauro.service.userauthservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperClass {

  User toUserEntity(UserDTO userDTO);
  UserDTO toUserDto(User user);

}
