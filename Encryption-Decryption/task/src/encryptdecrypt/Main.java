package encryptdecrypt;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String mode = getMode(args);
        char[] text = getData(args).toCharArray();
        int key = getKey(args);
        int startPos = 32;
        int endPos = 126;

        if (mode.equals("enc")) {
            System.out.println(doEncrypt(text, key, startPos, endPos));
        } else if (mode.equals("dec")) {
            System.out.println(doDecrypt(text, key, startPos, endPos));
        } else {
            System.out.println("wrong mode");
        }
    }

    static String doEncrypt(char[] message, int key, int startPos, int endPos) {
        for (int i = 0; i < message.length; i++) {
            char letter = message[i];
            if (letter >= startPos && letter <= endPos) {
                int pos = (letter + key - startPos) % (endPos - startPos + 1);
                message[i] = (char) (startPos + pos);
            }
        }
        return new String(message);
    }

    static String doDecrypt(char[] message, int key, int startPos, int endPos) {
        for (int i = 0; i < message.length; i++) {
            char letter = message[i];
            if (letter - key < startPos) {
                int pos = endPos - (letter - startPos - key);
                message[i] = (char) (startPos + pos);
            } else {
                int pos = (letter - key);
                message[i] = (char) pos;
            }
        }
        return new String(message);
    }

    static int getPos(String[] array, String s) {
        return Arrays.asList(array).indexOf(s);
    }

    static String getMode(String[] array) {
        int pos = getPos(array, "-mode");
        if (pos >= 0) {
            return array[pos + 1];
        } else return "enc";
    }

    static String getData(String[] array) {
        int pos = getPos(array, "-data");
        if (pos >= 0) {
            return array[pos + 1];
        } else return "";
    }

    static int getKey(String[] array) {
        int pos = getPos(array, "-key");
        if (pos >= 0) {
            return Integer.parseInt(array[pos + 1]);
        } else return 0;
    }
}
