package util;

/**
 *  this class contains the message output and constructor for TripartiteException
 */
public class TripartiteException extends Exception {
    private String triString;
    private int oIndex;
    @Override
    public String getMessage() {
        return triString + " is a singleton string that is found at index" + oIndex + "!";
    }
    public TripartiteException(String triString, int oIndex) {
        this.triString = triString;
        this.oIndex = oIndex;
    }
}

