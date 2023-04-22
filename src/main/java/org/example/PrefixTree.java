package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class PrefixTree {

    private final Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void add(String key, String[] value) {
        var current = root;
        key = key.replaceAll("\"", "")
                .toLowerCase();

        for (var c : key.toCharArray()) {
            current = current.getChildren().computeIfAbsent(c, ch -> new Node());
        }
        current.setEndOfWord(true);
        current.addValue(value);
    }

    public List<String[]> search(String prefix) {
        var results = new ArrayList<String[]>();
        var current = root;
        for (var c : prefix.toLowerCase().toCharArray()) {
            current = current.getChildren().get(c);
            if (current == null) {
                return results;
            }
        }
        searchRecursively(current, results);
        return results;
    }

    private void searchRecursively(Node node, List<String[]> results) {
        if (node.isEndOfWord()) {
            for (var value : node.getValues()) {
                results.add(value);
            }
        }
        for (Node child : node.getChildren().values()) {
            searchRecursively(child, results);
        }
    }

    private static class Node {
        private boolean endOfWord;
        private final List<String[]> values;
        private final Map<Character, Node> children;

        public Node() {
            endOfWord = false;
            values = new ArrayList<>();
            children = new HashMap<>();
        }

        public boolean isEndOfWord() {
            return endOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }

        public List<String[]> getValues() {
            return values;
        }

        public void addValue(String[] value) {
            values.add(value);
        }

        public Map<Character, Node> getChildren() {
            return children;
        }
    }
}
