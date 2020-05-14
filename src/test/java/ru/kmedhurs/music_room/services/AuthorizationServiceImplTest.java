package ru.kmedhurs.music_room.services;

import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.kmedhurs.music_room.exceptions.UserNotExist;
import ru.kmedhurs.music_room.mappers.AuthorizationMapper;
import ru.kmedhurs.music_room.model.RegistrationDto;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class AuthorizationServiceImplTest {

    @Mock private AuthorizationMapper authorizationMapper;
    @Mock private NotificationService notificationService;
    @Mock private PasswordEncoder passwordEncoder;
    @InjectMocks private AuthorizationServiceImpl authorizationService;

    @BeforeAll
    static void init() {
    }

    @Test
    void registerUser_thenRegisterAndSendVerifyEmail() {
        val pass = "testPass";
        val encodedPass = "encodedTestPass";
        val uuid = "testUUID";
        val registrationDto = new RegistrationDto("testName", pass, "testMail@yandex.ru");
        when(authorizationMapper.registerUser(registrationDto, encodedPass)).thenReturn(uuid);
        when(passwordEncoder.encode(pass)).thenReturn(encodedPass);

        authorizationService.registerUser(registrationDto);

        verify(authorizationMapper, times(1)).registerUser(registrationDto, encodedPass);
        verify(notificationService, times(1)).sendVerifyNotification(uuid);
    }

    @Test
    void verifyUser_whenTokenExist_thenOkAndEnableUser() throws Exception {
        val uuid = UUID.fromString("111111-1111-1111-1111-111111");
        val username = "testUsername";
        when(authorizationMapper.enableUser(uuid.toString())).thenReturn(username);

        authorizationService.verifyUser(uuid);

        verify(authorizationMapper, times(1)).enableUser(uuid.toString());
    }

    @Test
    void verifyUser_whenTokenExist_thenThrowUserNotExist() throws Exception {
        val uuid = UUID.fromString("111111-1111-1111-1111-111111");
        val username = "testUsername";
        when(authorizationMapper.enableUser(uuid.toString())).thenReturn(null);

        Throwable thrown = assertThrows(UserNotExist.class, () -> authorizationService.verifyUser(uuid));

        verify(authorizationMapper, times(1)).enableUser(uuid.toString());
        assertNotNull(thrown);
    }
}