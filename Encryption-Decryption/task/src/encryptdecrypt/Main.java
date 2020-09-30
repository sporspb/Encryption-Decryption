package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] message = s.toCharArray();
        int key = scanner.nextInt();
        int startPos = 96;

        for (int i = 0; i < message.length; i++) {
            char letter = message[i];
            if (letter >= 97 && letter <= 122) {
                int pos = (letter + key - startPos) % 26;
                message[i] = (char) (startPos + pos);
            }
        }
        System.out.println(new String(message));
    }
}
