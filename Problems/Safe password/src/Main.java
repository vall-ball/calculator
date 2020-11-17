import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String regex1 = "^.*[a-z]+.*";
        String regex2 = "^.*[A-Z]+.*";
        String regex3 = "^.*[0-9]+.*";
        String regex4 = ".{12,}";
/*
        System.out.println(input.matches(regex1));
        System.out.println(input.matches(regex2));
        System.out.println(input.matches(regex3));
        System.out.println(input.matches(regex4));
*/
        if (input.matches(regex1) && input.matches(regex2) && input.matches(regex3) && input.matches(regex4)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}