package xyz.aaratprasadchopra.ab.queue;

import java.util.ArrayList;

public class AQueue<T> {
    private ArrayList<T> queue;
    private int size;

    public T enqueue(T value) {
        this.queue.add(value);
        this.size++;
        return value;
    }

    public T dequeue() {
        this.size--;
        return this.queue.remove(0);
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
