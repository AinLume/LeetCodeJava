package leetcode_study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Seventeen {

    private static final Map<Character, String> phoneMap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) {
            return combinations;
        }
        backtrack(0, new StringBuilder(), digits, combinations);
        return combinations;
    }

    private static void backtrack(int index, StringBuilder path, String digits, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(path.toString());
            return;
        }

        char digit = digits.charAt(index);
        String possibleLetters = phoneMap.get(digit);

        for (char letter : possibleLetters.toCharArray()) {
            path.append(letter);
            backtrack(index + 1, path, digits, combinations);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
