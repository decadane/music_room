package ru.kmedhurs.music_room.services;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendVerifyNotification(String token) {
        // TODO: 2020-05-14 replace it
        log.error("Mail sending disabled!");
    }
}
