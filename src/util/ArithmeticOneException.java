package util;

/**
 *  this class contains the message output and constructor for ArithmeticOneException
 */
public class ArithmeticOneException extends Exception {
    private String ariString;
    private int oIndex;
    @Override
    public String getMessage() {
        return ariString + " is a singleton string that is found at index" + oIndex + "!";
    }
    public ArithmeticOneException(String ariString, int oIndex) {
        this.ariString = ariString;
        this.oIndex = oIndex;
    }
}

