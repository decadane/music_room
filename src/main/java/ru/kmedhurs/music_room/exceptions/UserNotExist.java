package ru.kmedhurs.music_room.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotExist extends Exception {

    public UserNotExist(String message) {
        super(message);
    }
}
