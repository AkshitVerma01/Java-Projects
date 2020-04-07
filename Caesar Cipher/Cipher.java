import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {
        Scanner amazing = new Scanner(System.in);
        int choose = 0;
        int maybe = 0;
        System.out.println("Pick 1 to decrypt with key" + "\n" + "Pick 2 to decrypt without key" + "\n");

        // Catches anything entered other than an integer and outputs
        // Enter 1 or 2 only please and thank you!
        try {
            choose = amazing.nextInt();
            amazing.nextLine();
        } catch (Exception e) {
            System.out.println("Enter 1 or 2 only please and thank you!");
        }

        // Case statement for the user to decide decrypt or hack
        switch (choose) {
            case 1:

                // Calls method for user inputed decrypting
                callingAllCaesars();
                break;

            case 2:
                // Calls method for hacking
                System.out.println("Pick the language you want to check from");
                System.out.println("Enter 1 for english" + "\n" + "Enter 2 for french");
                try {
                    maybe = amazing.nextInt();
                    amazing.nextLine();
                } catch (Exception e) {
                    System.out.println("Enter 1 for english" + "\n" + "Enter 2 for french");
                }
                callingAllHackers(maybe);
                break;
            default:
                break;
        }
        amazing.close();
    }

    // Public variable for alphabet
    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 
     * @param alphabet This is a String representation of an alphabet that is used
     *                 to become the outer length of the message.
     * @param keyAn    integer representation that is given by the user to shift the
     *                 alphabet
     * 
     * @return String; A representation of the alphabet that has been shifted
     *         relative to the key
     */
    private static String shift(String alphabet, int key) {
        key = key % 26;
        String encrAlpha = "";

        // Array same size as the length of the alphabet
        char[] alpha = new char[alphabet.length()];
        alpha = alphabet.toCharArray();

        // When key less than 0
        if (key < 0) {
            key = key + 26;
            for (int index = 0; index < alpha.length; index++) {
                if (index + key < alpha.length) {
                    encrAlpha += alpha[index + key];
                } else {
                    encrAlpha += alpha[index - (26 - key)];
                }
            }
        } else {
            // Shifts every element in the array by the key.
            for (int index = 0; index < alpha.length; index++) {
                if (index + key < alpha.length) {
                    encrAlpha += alpha[index + key];
                } else {

                    // Once it hits 21 elements (26th letter), it loops around
                    // to the beginning to complete the cycle.
                    encrAlpha += alpha[index - (26 - key)];
                }
            }
        }
        return encrAlpha;
    }

    /**
     * 
     * @param message This is a String representation of a message that is to be
     *                encrypted, randomly spaced and in all caps.
     * @param key     An integer representation that is given by the user to shift
     *                the position of characters.
     * @return String; A representation of a message that has been encrypted and in
     *         upper case
     */
    public static String encrypt(String message, int key) {
        key = key % 26;

        String encryptText = "";
        message = message.toUpperCase();

        // Random initialization.
        Random rand = new Random();
        if (key < 0) {
            key = key + 26;

            for (int index = 0; index < message.length(); index++) {
                int charPosition = alphabet.indexOf(message.charAt(index));
                int keyVal = (key + charPosition) % 26;

                char replaceVal = alphabet.charAt(keyVal);
                encryptText += replaceVal;

                if (rand.nextInt(100) < 27) {
                    encryptText += " ";
                }
            }

        } else
            // Locates the matching index position of the message and alphabet
            for (int index = 0; index < message.length(); index++) {
                int charPosition = alphabet.indexOf(message.charAt(index));

                int keyVal = (key + charPosition) % 26;

                // Take the new encryption and its relative element position in
                // the alphabet
                char replaceVal = alphabet.charAt(keyVal);

                // Encrypted text shows the matching shifted text
                encryptText += replaceVal;

                // Randomly adds spaces anywhere, has a 27% chance in every spot
                // Adds a space as its encrypting rather than at the end.
                if (rand.nextInt(100) < 27) {
                    encryptText += " ";
                }
            }
        return encryptText;
    }

    /**
     * 
     * @param encryptText A representation of an encrypted text that is to be
     *                    decrypted, removed of all spaces and in lower case.
     * @param key         An integer representation that is given by the user to
     *                    shift the position of characters in the opposite
     *                    direction.
     * @return String; A representation of a message that has been decrypted and in
     *         lower case with no spaces.
     */
    public static String decrypt(String encryptText, int key) {
        String decryptText = "";
        // Loop which finds the character position relative to the alphabet with
        // the encrypted message
        for (int index = 0; index < encryptText.length(); index++) {
            int charPosition = alphabet.indexOf(encryptText.charAt(index));
            int keyVal = (charPosition - key) % 26;

            // A negative keyVal is the same as one thats been added to 26
            // -1 = 25, -2 = 24 ...
            if (keyVal < 0) {
                keyVal = alphabet.length() + keyVal;
            }

            // Takes the reverse shifted encrypted message, compares it to the
            // same value as
            // the alphabet and then gets added to the string.
            char replaceNumber = alphabet.charAt(keyVal);
            decryptText += replaceNumber;
            decryptText = decryptText.toLowerCase();
        }
        return decryptText;
    }

    /**
     * 
     * @param encryptText A representation of an encrypted text that is to be
     *                    hacked, removed of all spaces and in lower case
     * @return String; A representation of a hacked text that is removed of all
     *         spaces and in lower case
     */
    public static String hackerBoi(String encryptText, int language) {
        // An error: If a word has the same sequence as another set of letters
        // It will print out the sequence that comes first
        // 10:20am, 11/2/19 : Saruggan, Karanvir, hi do not work.

        String decryptText = "";
        int king = 0;
        encryptText = encryptText.toUpperCase();

        // Goes through every possibility of a key, going through the nested
        // loop
        // Until the words match
        for (int theKey = 0; theKey < 26; theKey++) {
            String englishLang = "";
            String frenchLang = "";
            int point = 0;

            switch (language) {
                case 1:
                    String langEnglish = ".\\Words.txt";
                    englishLang = langEnglish;
                    break;
                case 2:
                    String langFrench = ".\\french.txt";
                    frenchLang = langFrench;
                    break;
                default:
                    break;
            }

            if (language == 1) {
                try (BufferedReader storyTime = new BufferedReader(new FileReader(englishLang))) {

                    String word = "";

                    // Reads the input from the user and matches it with the file
                    // Uses the .contains sequence to compare
                    while ((word = storyTime.readLine()) != null) {
                        if (decrypt(encryptText, theKey).contains(word)) {
                            point++;
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Replace the highest point word if another word has a higher one.
                if (point > king) {
                    king = point;
                    decryptText = decrypt(encryptText, theKey);
                }
            } else {

                // Catches any error that arises with detais related to the file.
                try (BufferedReader storyTime = new BufferedReader(new FileReader(frenchLang))) {

                    String word = "";

                    // Reads the input from the user and matches it with the file
                    // Uses the .contains sequence to compare
                    while ((word = storyTime.readLine()) != null) {
                        if (decrypt(encryptText, theKey).contains(word)) {
                            point++;
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Replace the highest point word if another word has a higher one.
                if (point > king) {
                    king = point;
                    decryptText = decrypt(encryptText, theKey);
                }

            }

        }
        return decryptText;
    }

    public static void callingAllHackers(int maybe) {
        Scanner amazing = new Scanner(System.in);

        // gets user inputed message
        System.out.println("\n" + "What is the message?");
        String decryptedMsg = amazing.nextLine();
        amazing.close();

        System.out.println("Currently hacking, please wait until finished...");

        // Represents the point of time in nanosecond precision.
        // Holds two long fields , the first holds seconds and the second the
        // nanoseconds.
        Instant starts = Instant.now();

        // Print hacked message
        System.out.println("\n" + "The hacked message is: " + hackerBoi(
                decryptedMsg.replace(" ", "").replaceAll("[1234567—890!@#$%^&*()_+|\\-=~`{}\\[\\]:;\"<>,.?/]", ""),
                maybe));

        // Stops the timer and converts to seconds.
        Instant ends = Instant.now();

        // Used when dealing with machine based time calculations
        Duration elapsed = Duration.between(starts, ends);

        // Converts to seconds as instant is in nanoseconds.
        long elapsedSeconds = elapsed.getSeconds();
        System.out.println("It took " + elapsedSeconds + "s to complete!");
    }

    public static void callingAllCaesars() {
        Scanner amazing = new Scanner(System.in);

        // Iniitalise the message inputs
        System.out.println("What is the message?");
        String message;
        message = amazing.nextLine();

        // Iniitalise the key input
        System.out.println("What is the key you want to shift");
        int key;
        key = amazing.nextInt();
        key = key % 26;

        // Final statements Display the base shifted alphabet
        System.out.println("Cipher: " + shift(alphabet, key));

        // Display message
        System.out.println("Initial: " + message);

        // Display encrypted message
        String encryptedMsg = encrypt(
                message.replace(" ", "").replaceAll("[1234567—890!@#$%^&*()_+|\\-=~`{}\\[\\]:;\"<>,.?/]", ""), key);
        System.out.println("Encrypted message: " + encryptedMsg);

        // Display decrypted message
        String decryptedMsg = decrypt(
                encryptedMsg.replace(" ", "").replaceAll("[1234567—890!@#$%^&*()_+|\\-=~`{}\\[\\]:;\"<>,.?/]", ""),
                key);
        System.out.println("Decrypted message: " + decryptedMsg);
        amazing.close();
    }
}