import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int range = scanner.nextInt();
        int time = scanner.nextInt();
        double speed = (double) range / time;
        System.out.println(speed);
    }
}