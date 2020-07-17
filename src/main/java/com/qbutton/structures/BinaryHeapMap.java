package com.qbutton.structures;

import java.util.*;

/**
 * No duplicates supported.
 * @param <T> type
 */
public class BinaryHeapMap<T, V extends Comparable<V>> {

    private final Map<T, Integer> distances = new HashMap<>();
    private final Map<Integer, T> backward = new HashMap<>();

    private final List<V> heap = new ArrayList<>();


    public void put(T key, V value) {
        heap.add(value);
        int index = heap.size() - 1;
        distances.put(key, index);
        backward.put(index, key);
        heapify(index);
    }

    public void decreaseKey(T key, V newValue) {
        int currIndex = distances.get(key);
        heap.set(currIndex, newValue);
        heapify(currIndex);
    }

    public boolean isEmpty() {
        return distances.isEmpty();
    }

    private void heapify(int index) {
        while (index >= 1) {
            int parentIdx = getParent(index);
            if (heap.get(parentIdx).compareTo(heap.get(index)) <= 0) break;
            //swap index and getParent
            swap(index, parentIdx);

            index = parentIdx;
        }
        //check upwards array
    }

    private void swap(int index, int parentIdx) {
        T firstKey = backward.get(index);
        T secondKey = backward.get(parentIdx);
        Collections.swap(heap, index, parentIdx);
        distances.put(firstKey, parentIdx);
        distances.put(secondKey, index);
        backward.put(index, secondKey);
        backward.put(parentIdx, firstKey);
    }

    private void increaseKey(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        int min = index;
        if (left < heap.size() && heap.get(left).compareTo(heap.get(index)) < 0) {
            min = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(min)) < 0) {
            min = right;
        }

        if (min != index) {

            swap(min, index);

            increaseKey(min);
        }
    }

    private int getParent(int index) {
        return (index - 1) / 2;
        //0 - 1,2
        //1 - 3,4
        //2 - 5,6
    }

    public Pair<T, V> extractMin() {
        T key = backward.get(0);
        V value = heap.get(0);

        int lastIdx = heap.size() - 1;

        heap.set(0, heap.get(lastIdx));
        heap.remove(lastIdx);
        T lastKey = backward.remove(lastIdx);
        backward.put(0, lastKey);
        distances.put(lastKey, 0);
        distances.remove(key);

        increaseKey(0);

        return new Pair<>(key, value);
    }

    public boolean containsKey(T key) {
        return distances.containsKey(key);
    }

    public V getDistance(T key) {
        return heap.get(distances.get(key));
    }

    public static class Pair<T, V> {
        private final T key;
        private final V value;

        public Pair(T key, V value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
