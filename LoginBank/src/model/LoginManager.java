/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static common.Validation.checkInputAccount;
import static common.Validation.checkInputCaptcha;
import static common.Validation.checkInputIntLimit;
import static common.Validation.checkInputPassword;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class LoginManager {
    
    private static final Scanner in = new Scanner(System.in);

    private static final String ACCOUNT_NUMBER_VALID = "^\\d{10}$";
    private static final char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
        'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
        'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
        'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
        '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
        'Y', 'y', 'Z', 'z', '9'};

    public static boolean isValidPassword(String password, Locale language) {
        int lengthPassword = password.length();
        if (lengthPassword < 8 || lengthPassword > 31) {
            getWordLanguage(language, "errCheckLengthPassword");
            System.out.println();
            return false;
        } else {
            int countDigit = 0;
            int countLetter = 0;
            for (int i = 0; i < lengthPassword - 1; i++) {
                if (Character.isDigit(password.charAt(i))) {
                    countDigit++;
                } else if (Character.isLetter(password.charAt(i))) {
                    countLetter++;
                }
            }
            if (countDigit < 1 || countLetter < 1) {
                getWordLanguage(language, "errCheckAlphanumericPassword");
                System.out.println();
                return false;
            }
        }
        return true;
    }

    public static String generateCaptchaText() {
        String randomStrValue = "";
        final int LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < LENGTH; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
    }

    public static void getWordLanguage(Locale curLocate, String key) {
        ResourceBundle words
                = ResourceBundle.getBundle("Language/" + curLocate, curLocate);
        String value = words.getString(key);
        System.out.printf(value);
    }

    public static void login(Locale language) {
        getWordLanguage(language, "enterAccountNumber");
        int accountNumber = checkInputAccount(language);
        getWordLanguage(language, "enterPassword");
        String passString = checkInputPassword(language);
        String captchaGenerated = generateCaptchaText();
        while (true) {
            if (checkInputCaptcha(captchaGenerated, language)) {
                getWordLanguage(language, "loginSuccess");
                System.out.println();
                return;
            } else {
                getWordLanguage(language, "errCaptchaIncorrect");
                System.out.println();
            }
        }
    }
    
//    public static void display() {
//        Locale vietnamese = new Locale("vi");
//        Locale english = Locale.ENGLISH;
//        System.out.println("1. Vietnamese");
//        System.out.println("2. English");
//        System.out.println("3. Exit");
//        System.out.print("Please choice one option: ");
//        int choice = checkInputIntLimit(1, 3, english);
//        switch (choice) {
//            case 1:
//                login(vietnamese);
//                break;
//            case 2:
//                login(english);
//                break;
//            case 3:
//                return;
//        }
//    }
//
//    public static void main(String[] args) {
//        display();
//    }
}
