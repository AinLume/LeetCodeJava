package leetcode_study;

import java.util.*;

public class Eighteen {
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < len - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < len - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1, r = len - 1;
                while (l < r) {

                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    long s = (long)nums[i] + (long)nums[j] + (long)nums[l] + (long)nums[r];
                    if (s > 2147483647) return ans;

                    if (sum > target) --r;
                    else if (sum < target) ++l;
                    else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        ++l; --r;

                        while (l < r && nums[l] == nums[l - 1]) ++l;
                        while (l < r && nums[r] == nums[r + 1]) --r;
                    }

                }
            }
        }

        return ans;
    }
}
