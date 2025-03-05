package leetcode_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwentyTwo {

    public static void genPermutations(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            genPermutations(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            genPermutations(result, current + ")", open, close + 1, max);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> permutations = new ArrayList<>();
        genPermutations(permutations, "", 0, 0, n);
        return permutations;
    }

}
