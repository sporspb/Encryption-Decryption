import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int size = name.length();

        boolean result = (size >= 4) && (name.subSequence(size - 4, size).equals("burg"));
        System.out.println(result);
    }
}