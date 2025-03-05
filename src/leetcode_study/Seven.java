package leetcode_study;

public class Seven {
    public static int reverse(int x) {
        final String MAXP_INT = "2147483647";
        final String MAXN_INT = "2147483648";

        if (x == 0) return 0;
        if (x > 0) {
            String temp = Integer.toString(x);

            if (temp.length() == 10) {
                for (int i = MAXP_INT.length() - 1; i >= 0; --i) {
                    char a = temp.charAt(i);
                    char b =  MAXP_INT.charAt(MAXP_INT.length() - 1 - i);
                    if (a > b) {
                        return 0;
                    }
                    else if (a < b) {
                        break;
                    }
                }
            }

            StringBuilder res = new StringBuilder(temp).reverse();
            return Integer.parseInt(res.toString());
        }
        else {
            String temp = Integer.toString(-1 * x);
            if (temp.equals("-" + MAXN_INT)) return 0;

            if (temp.length() == 10) {
                for (int i = MAXN_INT.length() - 1; i >= 0; --i) {
                    char a = temp.charAt(i);
                    char b =  MAXN_INT.charAt(MAXN_INT.length() - 1 - i);
                    if (a > b) {
                        return 0;
                    }
                    else if (a < b) {
                        break;
                    }
                }
            }

            StringBuilder res = new StringBuilder(temp + "-").reverse();
            return Integer.parseInt(res.toString());
        }
    }
}
