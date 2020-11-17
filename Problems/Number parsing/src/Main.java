import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "[-+]?(0|[1-9]{1}[0-9]*|0[\\.\\,][0-9]*[1-9]{1}|[1-9]{1}[0-9]*[\\.\\,][0-9]*[1-9]{1}|0[\\.\\,]0|[1-9]+[\\.\\,]0)";

        String number = scanner.nextLine();
        System.out.println(number.matches(regex) ? "YES" : "NO");
    }
}