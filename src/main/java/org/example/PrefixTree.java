package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PrefixTree {

    private final Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void add(String key, long value) {
        var current = root;
        key = key.replaceAll("\"", "")
                .toLowerCase();

        for (var c : key.toCharArray()) {
            current = current.getChildren().computeIfAbsent(c, ch -> new Node());
        }
        current.setEndOfWord(true);
        current.addOffset(value);
    }

    public ArrayList<Long> search(String prefix) {
        var results = new ArrayList<Long>();
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

    private void searchRecursively(Node node, ArrayList<Long> results) {
        if (node.isEndOfWord()) {
            results.add(node.getOffset());
        }
        for (Node child : node.getChildren().values()) {
            searchRecursively(child, results);
        }
    }

    private static class Node {
        private boolean endOfWord;
        long offset = 0;
        private final Map<Character, Node> children;

        public Node() {
            endOfWord = false;
            children = new HashMap<>();
        }

        public boolean isEndOfWord() {
            return endOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }

        public long getOffset() {
            return offset;
        }

        public void addOffset(long value) {
            offset = value;
        }

        public Map<Character, Node> getChildren() {
            return children;
        }
    }
}