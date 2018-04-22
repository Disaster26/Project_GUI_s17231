package com.company;

public class NeverRentException extends Throwable {
    public NeverRentException(String message) {
        super(message);
    }
}
