package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final String filename = "data.csv";

        var data = readCsvFile(filename);

        var tree = new PrefixTree();
        for (var row : data) {
            tree.add(row[1], row);
        }

        var scanner = new Scanner(System.in);

        System.out.println("Введите начало имени аэропорта:");
        var input = scanner.nextLine();

        do {
            var m = System.nanoTime();
            var results = tree.search(input);
            var delta = (System.nanoTime() - m);

            printSearchResult(results, delta);

            System.out.println("Введите начало имени аэропорта:");
            input = scanner.nextLine();
        } while (!input.equals("!quit"));

        logMemoryStatistics();
    }

    private static List<String[]> readCsvFile(String filename) {
        var rows = new ArrayList<String[]>();
        var bytes = 0;
        try (var br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                var row = line.split(",");
                rows.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rows;
    }

    private static void printSearchResult(List<String[]> results, long delta) {
        for (var row : results) {
            System.out.print(row[1]);
            System.out.println(Arrays.toString(row));
        }

        System.out.print("Количество найденных строк: " + results.size());
        System.out.println(" Время, затраченное на поиск: " + delta + " нс или " + delta / 1000000 + " мс");
        System.out.println();
    }

    private static void logMemoryStatistics() {
        var runtime = Runtime.getRuntime();
        var totalMemory = runtime.totalMemory();
        var freeMemory = runtime.freeMemory();
        var usedMemory = totalMemory - freeMemory;

        System.out.println();
        System.out.println("Total memory: " + totalMemory / 1024 / 1024 + " mbytes");
        System.out.println("Free memory: " + freeMemory / 1024 / 1024 + " mbytes");
        System.out.println("Used memory: " + usedMemory / 1024 / 1024 + " mbytes");
    }


}