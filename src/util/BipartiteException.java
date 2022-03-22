package util;

/**
 * this class contains the message output and constructor for BipartiteException
 */
public class BipartiteException extends Exception {
    private String bipString;
    private int oIndex;
    @Override
    public String getMessage() {
        return bipString + " is a singleton string that is found at index" + oIndex + "!";
    }
    public BipartiteException(String bipString, int oIndex) {
        this.bipString = bipString;
        this.oIndex = oIndex;
    }
}
