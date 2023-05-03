package org.filter;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr4.LogFilterLexer;
import org.antlr4.LogFilterParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringsFilter {
    private Integer maxIndex = 14;
    private Integer minIndex = 1;

    public StringsFilter() {
    }

    public StringsFilter(Integer maxIndex, Integer minIndex) {
        this.maxIndex = maxIndex;
        this.minIndex = minIndex;
    }

    public String[] filter(String[] lines, String filter) {
        var errorListener = new ErrorListener();

        var lexer = new LogFilterLexer(CharStreams.fromString(filter));
        lexer.removeErrorListeners();

        var tokens = new CommonTokenStream(lexer);

        var parser = new LogFilterParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        var tree = parser.filter();

        if (parser.getNumberOfSyntaxErrors() != 0) {
            System.out.println("Invalid filter string");
            return new String[0];
        }

        try {
            new ErrorCheckerVisitor(minIndex, maxIndex).visit(tree);
        } catch (Exception e) {
            System.out.println(e);
            return new String[0];
        }

        var visitor = new FilterVisitor();
        var predicate = visitor.visit(tree);


        var result = new ArrayList<String>();
        for (int i = 0; i < lines.length; i++) {
            if (predicate.test(lines[i].split(","))) {
                result.add(lines[i]);
            }
        }

        return result.toArray(new String[0]);
    }
}
