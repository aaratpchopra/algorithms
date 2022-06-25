package xyz.aaratprasadchopra.linked_list;

import java.util.List;

public class SinglyLinkedList<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    private int size = 0;

    public void fillWithList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            var node = new ListNode<>(list.get(i));
            if (head == null) {
                head = tail = node;
                size++;
                continue;
            }
            tail.next = node;
            tail = node;
            size++;
        }
        System.out.println("Filled With List!");
    }

    public T findMiddle() {
        var current = head;
        var mid = this.size / 2;

        for (int i = 0; i < mid; i++) {
            current = current.next;
        }
        return current.data;
    }
}
