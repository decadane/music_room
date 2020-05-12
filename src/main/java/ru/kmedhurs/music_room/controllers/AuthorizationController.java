package ru.kmedhurs.music_room.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.kmedhurs.music_room.exceptions.UserNotExist;
import ru.kmedhurs.music_room.model.RegistrationDto;
import ru.kmedhurs.music_room.services.AuthorizationService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @PostMapping("/registration")
    public void registration(@RequestBody RegistrationDto dto) {
        authorizationService.registerUser(dto);
    }

    @PostMapping("/verification/{userUuid}")
    public void verifyEmail(@PathVariable UUID userUuid) throws UserNotExist {
        authorizationService.verifyUser(userUuid);
    }
}
