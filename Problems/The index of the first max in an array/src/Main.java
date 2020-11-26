import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        int indexMax = 0;

        for (int i = 0; i < size; i++) {
            int num = scanner.nextInt();
            numbers[i] = num;
            if (num > numbers[indexMax]) {
                indexMax = i;
            }
        }
        System.out.println(indexMax);
    }
}