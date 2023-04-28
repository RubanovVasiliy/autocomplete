package org.example;

import org.filter.StringsFilter;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        final String filename = "data.csv";

        var data = readAllLines(filename);

        var tree = new PrefixTree();

        for (var row : data) {
            tree.add(row.getL().split(",")[1], row.getR());
        }

        var scanner = new Scanner(System.in);

        String input = "1";

        while (!input.equals("!quit")) {
            System.out.println("Введите фильтр");
            var filterString = scanner.nextLine();

            System.out.println("Введите начало имени аэропорта:");
            input = scanner.nextLine();


            var m = System.nanoTime();
            var offsets = tree.search(input);
            var results = getLinesByOffsets(offsets, filename);
            var delta = (System.nanoTime() - m);

            if(!filterString.equals("")){
                results = new StringsFilter().filter(results, filterString);
            }

            printSearchResult(results, delta);
        }

        logMemoryStatistics();
    }

    private static void printSearchResult(List<String> results, long delta) {
        for (var row : results) {
            System.out.print(row.split(",")[1].replaceAll("\"", ""));
            System.out.println("[" + row + "]");
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

    public static ArrayList<Pair<String, Long>> readAllLines(String filename) {
        var pairList = new ArrayList<Pair<String, Long>>();
        try {
            var file = new RandomAccessFile(filename, "r");
            long byteOffset = 0;
            file.seek(byteOffset);

            String line = null;
            while ((line = file.readLine()) != null) {
                pairList.add(new Pair<>(line, byteOffset));
                byteOffset += line.length() + 1;
                file.seek(byteOffset);
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pairList;
    }

    public static List<String> getLinesByOffsets(ArrayList<Long> offsets, String filename) {
        var results = new ArrayList<String>();
        try {
            var file = new RandomAccessFile(filename, "r");

            String line = null;
            for (var offset : offsets) {
                file.seek(offset);
                line = file.readLine();
                results.add(line);
            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
}