package encryptdecrypt;

public interface Decipherable {
    String doEncrypt(char[] message, int key);

    String doDecrypt(char[] message, int key);
}
