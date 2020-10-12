import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        while (!s.equals("0")) {
            try {
                System.out.println(10 * Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + s);
            }
            s = scanner.nextLine();
        }
    }
}