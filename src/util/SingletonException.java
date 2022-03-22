package util;

/**
 *  this class contains the message output and constructor for SingletonException
 */
public class SingletonException extends Exception{
    private String singletonString;
    private int occurrenceIndex;
    @Override
    public String getMessage() {
        return singletonString + " is a singleton string that is found at index " + occurrenceIndex + "!";
    }
    public SingletonException(String singletonString, int index) {
        this.singletonString = singletonString;
        occurrenceIndex = index;
    }
}
