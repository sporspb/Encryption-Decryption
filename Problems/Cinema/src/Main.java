import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int places = scanner.nextInt();

        int availableRow = findAvailableRow(matrix, places);

        System.out.println(availableRow);
    }

    private static int findAvailableRow(int[][] matrix, int places) {
        for (int i = 0; i < matrix.length; i++) {
            int counter = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                counter = matrix[i][j] == 0 ? counter + 1 : 0;
                if (counter == places) {
                    return i + 1;
                }
            }
        }
        return 0;
    }
}