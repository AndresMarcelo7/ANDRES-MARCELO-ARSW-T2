package edu.eci.arsw.covidsearch.exception;

public class CovidException extends Exception{
    public CovidException(String message) {
        super(message);
    }

    public CovidException(String message, Throwable cause){
        super(message,cause);
    }
}