package leetcode_study;

public class Eleven {

    public static int maxArea(int[] height) {

        int max_v = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int a = height[left], b = height[right];
            max_v = Math.max(max_v, (right - left) * Math.min(a, b));

            if (a < b) ++left;
            else --right;
        }

        return max_v;
    }

}
