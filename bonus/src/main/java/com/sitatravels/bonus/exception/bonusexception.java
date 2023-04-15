package com.sitatravels.bonus.exception;

public class bonusexception extends RuntimeException {

    private String message;

    public bonusexception() {}

    public bonusexception(String msg)
    {
        super(msg);
        this.message = msg;
    }
}