import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean result = false;
        char[][] twoDimArray = new char[4][4];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < 4; j++) {
                twoDimArray[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                result = twoDimArray[i][j] == twoDimArray[i + 1][j] &&
                        twoDimArray[i][j] == twoDimArray[i][j + 1] &&
                        twoDimArray[i][j] == twoDimArray[i + 1][j + 1];
                if (result) {
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        System.out.println(result ? "NO" : "YES");
    }
}