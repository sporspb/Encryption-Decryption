package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String s = scanner.nextLine();
        char[] text = s.toCharArray();
        int key = scanner.nextInt();
        int startPos = 32;
        int endPos = 126;

        if (command.equals("enc")) {
            System.out.println(doEncrypt(text, key, startPos, endPos));
        } else if (command.equals("dec")) {
            System.out.println(doDecrypt(text, key, startPos, endPos));
        } else {
            System.out.println("wrong command");
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
}
