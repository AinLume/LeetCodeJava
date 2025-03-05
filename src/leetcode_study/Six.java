package leetcode_study;

public class Six {
    public static String makeAngle(String s, int rs) {

        int len = s.length(), spaces = rs / 2;
        StringBuilder res = new StringBuilder(s.charAt(0) + " ".repeat(spaces) + "\n");

        for (int i = 1; i <= len / 2; ++i) {
            spaces /= 2;
            char first = s.charAt(i), last = s.charAt(len - i);

            if (i != len / 2) {
                res.append(first).append(" ".repeat(spaces)).append(last).append("\n");
            }
            else {
                res.append(first);
            }
        }

        return res.toString();
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        int char_angel = numRows * 2 - 2;
        String str = s + "#".repeat(char_angel - s.length() % char_angel);
        int count_angel = str.length() / char_angel;
        String[] angels = new String[count_angel];

        for (int i = 0; i < count_angel; ++i) {
            angels[i] = makeAngle(str.substring(i * char_angel, (i + 1) * char_angel), numRows);
        }

        StringBuilder res = new StringBuilder();

        for (int k = 0; k < numRows; ++k) {
            for (int j = 0; j < count_angel; ++j) {
                String[] line = angels[j].split("\n");
                if (line.length > k) {
                    String currentRow = line[k].replaceAll("\\s+", "");  // Удаляем пробелы
                    res.append(currentRow);  // Добавляем строку к результату
                }
            }
        }

        return res.toString().replaceAll("#", "");
    }
}
