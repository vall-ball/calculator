package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    public String prepare(String str) {
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(str);
        String a = matcher.replaceAll("");
        pattern = Pattern.compile("(-{2})+");
        matcher = pattern.matcher(a);
        String b = matcher.replaceAll("+");
        pattern = Pattern.compile("\\++");
        matcher = pattern.matcher(b);
        String c = matcher.replaceAll("+");
        pattern = Pattern.compile("\\+\\-|\\-\\+");
        matcher = pattern.matcher(c);
        String d = matcher.replaceAll("-");
        return d;
    }

    public List<String> parseToList(String str) {
        String prepareString = prepare(str);
        List<String> list = new ArrayList<>();
        int end = 0;
        int begin = 0;
        while (end != prepareString.length()) {
            if (isSeparator(prepareString.charAt(end)) && end != 0) {
                if (isSeparator(prepareString.charAt(end - 1))) {
                    list.add(prepareString.substring(end, end + 1));
                    end++;
                    begin = end;
                } else {
                    list.add(prepareString.substring(begin, end));
                    list.add(prepareString.substring(end, end + 1));
                    end++;
                    begin = end;
                }
            } else {
                end++;
            }
            if (end == prepareString.length() && begin != end) {
                list.add(prepareString.substring(begin, end));
            }
        }
        return list;
    }

    public boolean isSeparator(char c) {
        return c == '+' || c == '-' || c == '(' || c == ')' || c == '/' || c == '*';
    }

}
