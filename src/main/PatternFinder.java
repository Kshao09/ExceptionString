/**
 * Kenny Shao
 * Professor Kianoosh Boroojeni
 * This program tracks the input string of a user input and outputs various exceptions along with their functions/messages.
 */

package main;

import util.*;
import java.util.*;

/**
 * This class finds the various patterns in the input string and outputs the exceptions that are in the string by priority
 */
public class PatternFinder {
    private static String randomStringGenerator(int length) {
        Random random = new Random(System.nanoTime());
        char[] array = new char[length];
        for (int i = 0; i < length; i++)
            array[i] = (char) ('a' + random.nextInt(26));
        return new String(array);
    }

    /**
     * finds the single letters in a string and outputs it to the user
     */
    private static void singletonMiner(String mine, int length) throws SingletonException {
        for (int start = 0; start < mine.length() - length; start++) {
            int i;
            for (i = start + 1; i < start + length; i++)
                if (mine.charAt(i) != mine.charAt(i - 1))
                    break;
            if (i == start + length)
                throw new SingletonException(mine.substring(start, start + length), start);
        }
    }

    /**
     * finds the letter pattern of the string and outputs it to the user
     */
    private static void arithmeticMiner(String mine, int length) throws ArithmeticOneException {
        for(int i = 0; i < mine.length() - length; i++) {
            int h;
            for(h = i+1; h < i +length; h++) {
                if (mine.charAt(h) != mine.charAt(h+1)) {
                    break;
                }
                if (h == i + length) {
                    throw new ArithmeticOneException(mine.substring(i,i+length), i);
                }
            }
        }
    }

    /**
     * searches for any reverse alphabetic patterns in the string and outputs it to the user
     */
    private static void arithmeticReverseMiner(String mine, int length) throws ArithmeticReverseException {
        for(int i = 0; i < mine.length() - length; i++) {
            int h;
            for(h = i+1; h < i +length; h++) {
                if (mine.charAt(h) != mine.charAt(h+1)-1) {
                    break;
                }
                if (h == i + length) {
                    throw new ArithmeticReverseException(mine.substring(i, i+length), i);
                }
            }
        }
    }

    /**
     * finds and searches for palindromes and outputs it to the user
     */
    private static void palindromeMiner(String mine, int length) throws PalindromeException {
        for (int i = 0; i <= mine.length() - length; i++) {
            String ori = mine.substring(i, i + length);
            String oriReverse = "";
            for (int j = ori.length()-1; j >= 0; j--) {
                oriReverse += ori.charAt(j);
            }
            for (int k = i + 1; k < i +length; k++) {
                if (!ori.equals(oriReverse)) {
                    break;
                }
                if (k == i + length) {
                    throw new PalindromeException(ori, i);
                }
            }
        }
    }

    /**
     * find three repeated parts of a string and outputs it to the user
     */
    private static void tripartiteMiner(String mine, int length) throws TripartiteException {
        for (int i = 0; i <= mine.length()-(length*3); i++) {
            int k = length+i;
            String firstStr = mine.substring(i, k);
            String secStr = mine.substring(k, k+length);
            String thirdStr = mine.substring(k+length, k+length+length);
            if (firstStr.equals(secStr) && secStr.equals(thirdStr)) {
                throw new TripartiteException(mine.substring(i,i+length+length+length), i);
            }
        }
    }

    /**
     * find two repeated parts of a string and outputs it to the user
     */
    private static void bipartiteMiner(String mine, int length) throws BipartiteException {
        for (int i = 0; i <= mine.length() - length; i++) {
            int k = length+i;
            for (int j = k; j < k+length; j++) {
                if (mine.charAt(i) != mine.charAt(j)) {
                    break;
                }
                i++;
            }
            if (i == k) {
                throw new BipartiteException(mine.substring(i, i+length), i);
            }
        }
    }

    /**
     * allows the user ot input a string and catches any exceptions in the input
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the length of random string: ");
        int patternMaxLength = 10;
        int randomStringLength = keyboard.nextInt();
        while (true) {
            try {
                if (randomStringLength < 100000 || randomStringLength > 1000000000)
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Try again!");
                randomStringLength = keyboard.nextInt();
                continue;
            }
            break;
        }
        String randomString = randomStringGenerator(randomStringLength);
        try {
            for (int length = patternMaxLength; length > 0; length--) {
                singletonMiner(randomString, length);
                bipartiteMiner(randomString, length);
                tripartiteMiner(randomString, length);
                arithmeticMiner(randomString, length);
                arithmeticReverseMiner(randomString, length);
                palindromeMiner(randomString, length);
            }
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }
}

