import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String r = "([0-9]|1[0-9]{2}|[1-9][0-9]|2[0-4][0-9]|25[0-5])";
        String regex = r + "\\." + r + "\\." + r + "\\." + r;

        if (input.matches(regex)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}