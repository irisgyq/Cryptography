package cryptography;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //create a ColumnCipher instance
        ColumnCipher cipher0 = new ColumnCipher();
        //create a SubstitutionCipher instance
        SubstitutionCipher cipher1 = new SubstitutionCipher();

        Scanner scan0 = new Scanner(System.in);
        //Input encryption type
        System.out.println("Please input the encryption type...");
        String encryptionType = scan0.nextLine();

        //Input plain text
        System.out.println("Please input the plain text...");
        String plainText = scan0.nextLine();

        //Input key
        System.out.println("Please input the key...");
        String key = scan0.nextLine();

        //Encrypt the plaintext according to the encryptionType.
        switch (encryptionType) {
            case "Column Cipher":
                //Encrypt the plaintext using Column encryption
                System.out.println("After using Column encryption, the Column Cipher is...");
                System.out.println(cipher1.SubstitutionEncrypt(cipher0.ColumnEncrypt(plainText, key), "10"));
                break;
            case "Substitution Cipher":
                //Encrypt the plaintext using Substitution encryption
                System.out.println("After using Substitution encryption, the Substitution Cipher is...");
                System.out.println(cipher1.SubstitutionEncrypt(plainText, key));
                break;
            case "Column Cipher+Substitution Cipher":
                //Encrypt the plaintext using Column encryption first then substitution encryption
                System.out.println("After using Column cipher and Substitution encryption, the Cipher is...");
                System.out.println("Please input the second key...");
                Scanner scan1 = new Scanner(System.in);
                //input the second key
                String key2 = scan1.nextLine();
                System.out.println(cipher1.SubstitutionEncrypt(cipher0.ColumnEncrypt(plainText, key), key2));
                break;
            default:
                System.out.println("Your encryption type is wrong, the plaintext is not encrypted...");
                System.out.println(plainText);
        }
    }
}
