package org.example;

import java.util.List;

public class Printer {

    public static void printSearchResult(List<String> results, long delta) {
        for (var row : results) {
            System.out.print(row.split(",")[1].replaceAll("\"", ""));
            System.out.println("[" + row + "]");
        }

        System.out.print("Количество найденных строк: " + results.size());
        System.out.println(" Время, затраченное на поиск: " + delta + " нс или " + delta / 1000000 + " мс");
        System.out.println();
    }

    public static void logMemoryStatistics() {
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
