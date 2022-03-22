package util;

/**
 *  this class contains the message output and constructor for ArithmeticReverseException
 */
public class ArithmeticReverseException extends Exception {
    private String ariRString;
    private int oIndex;
    @Override
    public String getMessage() {
        return ariRString + " is a singleton string that is found at index" + oIndex + "!";
    }
    public ArithmeticReverseException(String ariRString, int oIndex) {
        this.ariRString = ariRString;
        this.oIndex = oIndex;
    }
}
