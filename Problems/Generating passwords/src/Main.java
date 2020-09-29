import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        int sum = a + b + c;
        int i = 0;
        int countA = 65;
        int countB = 97;
        int countC = 48;
        int countN = 33;

        char[] text = new char[n];

        while (i < text.length) {
            if (a > 0) {
                if (countA > 90) {
                    countA = 65;
                }
                text[i] = (char) countA;
                i++;
                countA++;
                a--;
            }
            if (b > 0) {
                if (countB > 122) {
                    countB = 97;
                }
                text[i] = (char) countB;
                i++;
                countB++;
                b--;
            }

            if (c > 0) {
                if (countC > 57) {
                    countC = 48;
                }
                text[i] = (char) countC;
                i++;
                countC++;
                c--;
            }

            if (i >= sum && n >= i + 1) {
                if (countN > 122) {
                    countN = 33;
                }
                text[i] = (char) countN;
                i++;
                countN++;
            }
        }
        System.out.println(new String(text));
    }
}