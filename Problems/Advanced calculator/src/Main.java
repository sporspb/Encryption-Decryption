import java.util.Arrays;

/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        String[] copy = Arrays.copyOfRange(args, 1, args.length);
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        switch (operator) {
            case "MAX":
                for (String value : copy) {
                    max = Math.max(Integer.parseInt(value), max);
                }
                System.out.println(max);
                break;
            case "MIN":
                for (String value : copy) {
                    min = Math.min(Integer.parseInt(value), min);
                }
                System.out.println(min);
                break;
            case "SUM":
                for (String s : copy) {
                    sum += Integer.parseInt(s);
                }
                System.out.println(sum);
                break;
            default:
                System.out.println("Wrong command");
                break;
        }
    }
}