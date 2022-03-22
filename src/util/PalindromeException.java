package util;

/**
 *  this class contains the message output and constructor for PalindromeException
 */
public class PalindromeException extends Exception {
    private String paliString;
    private int oIndex;
    @Override
    public String getMessage() {
        return paliString + " is a singleton string that is found at index" + oIndex + "!";
    }
    public PalindromeException(String paliString, int oIndex) {
        this.paliString = paliString;
        this.oIndex = oIndex;
    }
}

