package com.farvic.rpg.errors;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus()
public class CharacterNotFoundException extends RuntimeException {
    private String error;
    private HttpStatus status;

    public CharacterNotFoundException(String error) {
        this.error = error;
        this.status = HttpStatus.BAD_REQUEST;
    }

    public CharacterNotFoundException(String error, HttpStatus status) {
        this.error = error;
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
