public class EncryptDecrypt {

   //String variable key will hold the string containing the key
    private String key;

    //No-parameter constructor sets the key as null string (will not be used in the EspionageRunner code)
    public EncryptDecrypt() {
        key = "";
    }

    /*This constructor sets the key to its string parameter.
      This is how the key will be set in the EspionageRunner code. */
    public EncryptDecrypt(String s) {
        key = s;
    }

    //This method sets the key to its parameter (will not be used in the EspionageRunner code).
    public void setKey(String a) {
        key = a;
    }

    //This is the decryption method, which will decrypt the encrypted String 'b'
    public String decrypt(String b) {

        //Variables that will be used in the loop are initialized here.
        int count = -1;
        char keyCharacter = ' ';
        String output = " ";
        int shiftValue = 0;
        int outputValue = 0;

        for(int i = 0; i < b.length(); i++) {
            //the loop reads each character and sets it to the char variable 'letter'
            char letter = b.charAt(i);

            //if the character is a letter, it's decrypted. if not, it's just put back into the decrypted string.
            if ((letter > 64 && letter < 91) || (letter > 96 && letter < 123)) {

                /* count increments when 'letter' is a letter. Using 'count', each letter is then
                mapped to its corresponding letter in the key. */
                count++;
                keyCharacter = key.charAt(count);

                //shiftValue represents the alphabetical position of keyCharacter (a number between 1 and 26)
                if (keyCharacter > 64 && keyCharacter < 91) {
                    shiftValue = keyCharacter - 64;
                }
                else if (keyCharacter > 96 && keyCharacter < 123) {
                    shiftValue = keyCharacter - 96;
                }

                /* The variable 'outputValue' is set to the ASCII value of the newly decrypted character.
                   For uppercase letters: if the value of outputValue is below the ASCII
                   value of 'A', it will "wrap around" to a value between 'A' and 'Z'.
                   For lowercase letters: if the value of outputValue is below the ASCII
                   value of 'a', it will "wrap around" to a value between 'a' and 'z'. */
                if ((letter > 64 && letter < 91)) {
                    outputValue = letter - shiftValue;
                    if (outputValue < 65)
                        outputValue += 26;
                }
                else if ((letter > 96 && letter < 123)) {
                    outputValue = letter - shiftValue;
                    if (outputValue < 97)
                        outputValue += 26;
                }

                //the character with the ASCII value of 'outputValue' is concatenated to the output string
                output += (char)(outputValue);
            }
            else {
                output += b.substring(i,i+1);
            }
        }
        return output;
    }

    /* This is the encryption method, which will encrypt the String 'c'.
       Structurally, very similar to the decryption method. */
    public String encrypt(String c) {

        //Variables that will be used in the loop are initialized here.
        int count = -1;
        char keyCharacter = ' ';
        String output = " ";
        int shiftValue = 0;
        int outputValue = 0;

        for (int i = 0; i < c.length(); i++) {
            //the loop reads each letter and sets it to the char variable 'letter'
            char letter = c.charAt(i);

            //if the character is a letter, it's encrypted. if not, it's just put back into the encrypted string
            if ((letter > 64 && letter < 91) || (letter > 96 && letter < 123)){

                /* count increments when 'letter' is a letter. Using 'count', each letter is then
                mapped to its corresponding letter in the key. */
                count++;
                keyCharacter = key.charAt(count);

                //shiftValue represents the alphabetical position of keyCharacter (a number between 1 and 26)
                if (keyCharacter > 64 && keyCharacter < 91) {
                    shiftValue = keyCharacter - 64;
                }
                else if (keyCharacter > 96 && keyCharacter < 123) {
                    shiftValue = keyCharacter - 96;
                }

                /* The variable 'outputValue' is set to the ASCII value of the newly encrypted character.
                   For uppercase letters: if the value of outputValue is above the ASCII
                   value of 'Z', it will "wrap around" to a value between 'A' and 'Z'.
                   For lowercase letters: if the value of outputValue is above the ASCII
                   value of 'z', it will "wrap around" to a value between 'a' and 'z'. */
                if ((letter > 64 && letter < 91)) {
                    outputValue = letter + shiftValue;
                    if (outputValue > 90)
                        outputValue -= 26;
                }
                else if ((letter > 96 && letter < 123)) {
                    outputValue = letter + shiftValue;
                    if (outputValue > 122)
                        outputValue -= 26;
                }

                //the character with the ASCII value of 'outputValue' is concatenated to the output string
                output += (char)(outputValue);
            }
            else {
                output += c.substring(i,i+1);
            }
        }
        return output;
    }
}
