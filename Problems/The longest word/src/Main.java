import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int max = 0;
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            if (length > max) {
                num = i;
                max = length;
            }
        }
        System.out.println(words[num]);
    }
}