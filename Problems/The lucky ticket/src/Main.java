import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] nums = input.toCharArray();
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i < 3) {
                sum1 += Character.getNumericValue(nums[i]);
            } else {
                sum2 += Character.getNumericValue(nums[i]);
            }
        }
        System.out.println(sum1 == sum2 ? "Lucky" : "Regular");
    }
}