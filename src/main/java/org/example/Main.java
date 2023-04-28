package org.example;

import org.filter.StringsFilter;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        final String filename = "data.csv";

        var data = Reader.readAllLines(filename);

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
            var results = Reader.getLinesByOffsets(offsets, filename);
            var delta = (System.nanoTime() - m);

            if(!filterString.equals("")){
                results = new StringsFilter().filter(results, filterString);
            }

            Printer.printSearchResult(results, delta);
        }

        Printer.logMemoryStatistics();
    }
}