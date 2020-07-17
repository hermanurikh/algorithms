package com.qbutton.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    Trie[] children = new Trie[26];
    String word = null;

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Trie();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.word != null;
    }

    private Map<Integer, List<Integer>> getElsToIndices(int[] arr) {
        Map<Integer, List<Integer>> answ = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            if (curr != 0) {
                List<Integer> currList = answ.getOrDefault(curr, new ArrayList<>());
                currList.add(i);
                answ.put(curr, currList);
            }
        }
        return answ;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}
