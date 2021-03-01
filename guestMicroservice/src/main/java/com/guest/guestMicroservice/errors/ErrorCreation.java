package com.guest.guestMicroservice.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;
import java.util.Date;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author Rose
 */
@Getter
@AllArgsConstructor
public enum ErrorCreation {


    INVALID_INPUT(BAD_REQUEST, "Invalid input. "),
    GUEST_IS_NOT_IN_HOTEL(BAD_REQUEST, "Guest is not in hotel"),
    INVALID_ID(BAD_REQUEST, "Guest with this Id not found.");



    private HttpStatus status;
    private String message;


    public ErrorMessage ErrorCreation(final Object... params) {
        return ErrorMessage.builder()
                .timestamp(new Date())
                .statusCode(status.value())
                .message(MessageFormat.format(message, params))
                .build();

    }

}
