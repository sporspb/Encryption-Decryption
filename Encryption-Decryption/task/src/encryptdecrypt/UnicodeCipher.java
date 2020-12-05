package encryptdecrypt;

public class UnicodeCipher implements Decipherable {
    private static final int START = 32;
    private static final int END = 126;

    @Override
    public String doEncrypt(char[] message, int key) {

        for (int i = 0; i < message.length; i++) {
            char letter = message[i];
            if (letter >= START && letter <= END) {
                int pos = (letter + key - START) % (END - START + 1);
                message[i] = (char) (START + pos);
            }
        }
        return new String(message);
    }

    @Override
    public String doDecrypt(char[] message, int key) {
        for (int i = 0; i < message.length; i++) {
            char letter = message[i];
            if (letter - key < START) {
                int pos = END - (letter - START - key);
                message[i] = (char) (START + pos);
            } else {
                int pos = (letter - key);
                message[i] = (char) pos;
            }
        }
        return new String(message);
    }
}
