package edu.eci.arsw.covidsearch.exception;

/**
 * The type Covid exception.
 */
public class CovidException extends Exception{
    /**
     * Instantiates a new Covid exception.
     *
     * @param message the message
     */
    public CovidException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Covid exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public CovidException(String message, Throwable cause){
        super(message,cause);
    }
}