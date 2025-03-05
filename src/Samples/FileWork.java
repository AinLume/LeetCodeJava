package Samples;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    public static void main(String[] args) throws IOException {
        // Записать в файл from program
        String outputFileName = "file.txt";
        String[] array = { "one", "two", "three", "four" };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String value : array) {
                writer.write(value + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Записать в файл from console
        String outputFileName1 = "file.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName1))) {
                String line;
                while (!(line = reader.readLine()).equals("exit")) { // Прерывание цикла при написании строки exit
                    writter.write(line);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        // Прочитать из файла
        String inputFileName = "file.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // Read from console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        System.out.println("Мы считали с клавиатуры эту строку:");
        System.out.println(s);

        // Считывание массива int сразу из консоли
        int[] A = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Write to console
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(s, 0, s.length());
        out.flush();// ww w.  j av  a  2s . c om
        reader.close();
        out.close();
    }
}
