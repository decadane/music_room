package ru.kmedhurs.music_room.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import ru.kmedhurs.music_room.model.RegistrationDto;

@Component
@Mapper
public interface AuthorizationMapper {

    String registerUser(RegistrationDto dto, String passwordHash);

    String enableUser(String token);
}
