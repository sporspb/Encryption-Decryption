import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int size = n;
        int count = 1;
        int point = (int) Math.ceil(n / 2.0);

        for (int i = 0; i < point; i++, size -= 2) {
            for (int j = 0; j < size; j++) {
                matrix[i][j + i] = count++;
            }
            for (int j = 1; j < size; j++) {
                matrix[i + j][n - 1 - i] = count++;
            }
            for (int j = size - 2; j > -1; j--) {
                matrix[n - 1 - i][j + i] = count++;
            }
            for (int j = size - 2; j > 0; j--) {
                matrix[i + j][i] = count++;
            }

        }
        for (int[] ints : matrix) {
            IntStream.range(0, matrix.length).forEach(j -> System.out.print("\t" + ints[j]));
            System.out.println();
        }
    }
}