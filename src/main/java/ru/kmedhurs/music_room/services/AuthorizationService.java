package ru.kmedhurs.music_room.services;

import ru.kmedhurs.music_room.exceptions.UserNotExist;
import ru.kmedhurs.music_room.model.RegistrationDto;

import java.util.UUID;

public interface AuthorizationService {

    void registerUser(RegistrationDto dto);

    void verifyUser(UUID userUuid) throws UserNotExist;
}
