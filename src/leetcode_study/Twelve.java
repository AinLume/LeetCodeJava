package leetcode_study;

import java.util.ArrayList;
import java.util.Arrays;

// 43 min
public class Twelve {

    public static int findIndex(int arr[], int t)
    {
        ArrayList<Integer> clist = new ArrayList<>();

        for (int i : arr)
            clist.add(i);

        return clist.indexOf(t);
    }

    public static String intToRoman(int num) {

        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] translate = {"I", "IV" ,"V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder res = new StringBuilder();
        int dec = 1, index = 0;

        while (num > 0) {
            int temp = num % 10;

            if (temp == 1 || temp == 5 || temp == 4 || temp == 9) {
                index = findIndex(nums, temp * dec);
                res.insert(0, translate[index]);
            }
            else {
                String buffer = "";
                if (dec == 1) {
                    buffer = temp < 5 ? translate[0].repeat(temp) : translate[2] + translate[0].repeat(temp - 5);
                }
                else if (dec == 10) {
                    buffer = temp < 5 ? translate[4].repeat(temp) : translate[6] + translate[4].repeat(temp - 5);
                }
                else if (dec == 100) {
                    buffer = temp < 5 ? translate[8].repeat(temp) : translate[10] + translate[8].repeat(temp - 5);
                }
                else {
                    buffer = translate[12].repeat(temp);
                }
                res.insert(0, buffer);
            }

            num /= 10;
            dec *= 10;
        }

        return res.toString();
    }

}
