package org.example;

import java.util.*;

public class PrefixTree {

    private static final int ALPHABET_SIZE = 26;
    public long nodeCount = 0;

    private static class Node {
        boolean endOfWord;
        long offset;
        Node[] children;

        Node() {
            endOfWord = false;
            offset = 0;
            children = new Node[ALPHABET_SIZE];
        }
    }

    private final Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void add(String key, long value) {
        key = key.toLowerCase().replaceAll("[^a-z]+", "");
        char[] chars = key.toCharArray();
        Node current = root;

        for (char c : chars) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new Node();
                nodeCount++;
            }
            current = current.children[index];
        }
        current.endOfWord = true;
        current.offset = value;
    }

    public long[] search(String prefix) {
        char[] chars = prefix.toCharArray();
        Node current = root;

        for (char c : chars) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return new long[0];
            }
            current = current.children[index];
        }

        Stack<Node> stack = new Stack<>();
        stack.push(current);

        List<Long> results = new ArrayList<>();
        if (current.endOfWord) {
            results.add(current.offset);
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            for (Node child : node.children) {
                if (child != null) {
                    if (child.endOfWord) {
                        results.add(child.offset);
                    }
                    stack.push(child);
                }
            }
        }

        return results.stream().mapToLong(Long::longValue).toArray();
    }
}