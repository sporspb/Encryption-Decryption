package encryptdecrypt;

public class Cipher {
    private Decipherable mode;

    public void setCipher(Decipherable cipher) {
        this.mode = cipher;
    }

    String doEnc(char[] message, int key) {
        return mode.doEncrypt(message, key);
    }

    String doDec(char[] message, int key) {
        return mode.doDecrypt(message, key);
    }
}
