package leetcode_study;

// написать функцию деления без умножения, деления и получения остатка(mod), отрезать дробну часть (2,34 = 2; 2,77 = 2)
// делитель не может равным быть 0 по условию

public class TwentyNine {

    public static void main(String[] args) {

        for (int i = -15; i <= 0; ++i) {
            for (int j = 15; j > 0; --j) {
                int result = divide(i, j);
                System.out.println(i + " divide on " + j + " = " + result);
            }
        }

    }

    public static int divide(int dividend, int divisor) {

        int count = 0;

        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            int dend = Math.abs(dividend);
            int div = Math.abs(divisor);

            while (dend >= div) {
                dend -= div;
                --count;
            }
        }
        else if (dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0) {
            int dend = Math.abs(dividend);
            int div = Math.abs(divisor);

            while (dend >= div) {
                dend -= div;
                ++count;
            }
        }

        return count;
    }
}
