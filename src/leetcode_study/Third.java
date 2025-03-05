package leetcode_study;

import java.util.HashSet;
import java.util.Set;

public class Third {
    public static int lengthOfLongestSubstring(String s) {

//      My solution - 32:52 min O(n^2) difficult 286ms

//        if (s.length() == 0) {return 0;}
//
//        String temp = "" + s.charAt(0);
//        int cur_len = 1, max_len = 1;
//
//        for (int i = 1; i < s.length(); ++i) {
//            char buffer = s.charAt(i);
//            if (temp.indexOf(buffer) == -1) {
//                temp += buffer;
//                ++cur_len;
//            }
//            else {
//                max_len = Math.max(cur_len, max_len);
//                temp = "";
//                i -= cur_len;
//                cur_len = 0;
//            }
//        }
//
//        return Math.max(cur_len, max_len);

        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }
}
