import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        double first = scanner.nextDouble();
        double second = scanner.nextDouble();
        System.out.println(second - first);
    }
}