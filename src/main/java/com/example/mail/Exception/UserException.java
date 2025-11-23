package com.example.mail.Exception;

import java.time.LocalDateTime;

public record UserException(LocalDateTime localDateTime,
                            String message,
                            String details,
                            String errorCode) {
}
