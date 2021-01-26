package Design;

import java.util.*;

public class LRU {
    int cap;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    public LRU(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        // move to tail
        Node t = map.get(key);
        removeNode(t);
        offerNode(t);
        return t.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node t = map.get(key);
            t.value = value;

            // move to tail
            removeNode(t);
            offerNode(t);
        } else {
            if (map.size() >= cap) {
                // delete head
                map.remove(head.key);
                removeNode(head);
            }

            // add to tail
            Node node = new Node();
            node.key = key;
            node.value = value;
            offerNode(node);
            map.put(key, node);
        }

    }

    private void removeNode(Node n) {
        if (n.prev != null) { // 1-->2-->3 (2)
            n.prev.next = n.next; // 1-->3
        } else { // that means it is head 2-->3
            head = n.next; // head = 3
        }

        if (n.next != null) {
            n.next.prev = n.prev; // 1<--3
        } else { // that means tail
            tail = n.prev; // tail = 3
        }
    }

    private void offerNode(Node n) {
        if (tail != null) {
            tail.next = n;
        }

        n.prev = tail;
        n.next = null;
        tail = n;

        if (head == null) {
            head = tail;
        }
    }
}