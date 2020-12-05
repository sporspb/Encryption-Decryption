package encryptdecrypt;

public class CesarCipher implements Decipherable {

    @Override
    public String doEncrypt(char[] message, int key) {

        for (int i = 0; i < message.length; i++) {
            char letter = message[i];
            if (Character.isLetter(letter)) {
                char startPos = (letter >= 'a') ? 'a' : 'A';
                int pos = (letter - startPos + key) % 26;
                message[i] = (char) (startPos + pos);
            }
        }
        return new String(message);
    }

    @Override
    public String doDecrypt(char[] message, int key) {
        return doEncrypt(message, 26 - (key % 26));
    }
}
