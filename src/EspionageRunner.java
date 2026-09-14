import java.io.*;
import java.util.Scanner;

public class EspionageRunner {
    public static void main (String[] args) throws FileNotFoundException {
        //gets name of key file and puts it into keyScanner
        System.out.print("Enter name of key file: ");
        Scanner input = new Scanner(System.in);
        String keyName = input.nextLine();
        Scanner keyScanner = new Scanner(new File(keyName));

        //this segment puts the file into the string variable 'key'
        String key = "";
        while (keyScanner.hasNextLine()) {
            key += keyScanner.nextLine();
        }

        //this segment removes all spaces and special characters from 'key'
        for (int i = 0; i < key.length(); i++) {
            char letter = key.charAt(i);
            if((letter < 65) || (letter > 90 && letter < 97) || (letter > 122)) {
                key = key.substring(0,i) + key.substring(i+1);
                i--;
            }
        }

        //creates an object of type EncryptDecrypt with the key as its parameter
        EncryptDecrypt object = new EncryptDecrypt(key);

        //prompts the user to either encrypt or decrypt
        System.out.print("Encrypt or Decrypt: ");
        String response = input.nextLine();

        //encryption runner code
        if (response.equals("Encrypt") || response.equals("encrypt")){
            //runs the same routine of converting the file to a string as it did for the key
            System.out.print("Enter the name of the file to be encrypted: ");
            String encryptionFileName = input.nextLine();
            Scanner encryptionFile = new Scanner(new File(encryptionFileName));
            String encryptionString = "";
            while (encryptionFile.hasNextLine()) {
                encryptionString += encryptionFile.nextLine() + "\n";
            }
            //runs the encrypt method and prints the result
            System.out.println(object.encrypt(encryptionString));
        }
        //decryption runner code
        else if (response.equals("Decrypt") || response.equals("decrypt")) {
            //runs the same routine of converting the file to a string as it did for the key
            System.out.print("Enter the name of the file to be decrypted: ");
            String decryptionFileName = input.nextLine();
            Scanner decryptionFile = new Scanner(new File(decryptionFileName));
            String decryptionString = "";
            while (decryptionFile.hasNextLine()) {
                decryptionString += decryptionFile.nextLine() + "\n";
            }
            //runs the decrypt method and prints the result
            System.out.println(object.decrypt(decryptionString));
        }


    }
}
