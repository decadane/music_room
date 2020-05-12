package ru.kmedhurs.music_room.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kmedhurs.music_room.exceptions.UserNotExist;
import ru.kmedhurs.music_room.mappers.AuthorizationMapper;
import ru.kmedhurs.music_room.model.RegistrationDto;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {

    private final AuthorizationMapper authorizationMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(RegistrationDto dto) {
        authorizationMapper.registerUser(dto, passwordEncoder.encode(dto.getPassword()));
    }

    @Override
    public void verifyUser(UUID token) throws UserNotExist {
        String username = authorizationMapper.enableUser(token.toString());
        if (username == null)
            throw new UserNotExist("This registration link doesn't exist");
    }
}
