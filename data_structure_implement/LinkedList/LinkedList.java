/*
 * Copyright (c) 2024 Hodynguyen (Nguyen Thanh Dat).
 * All rights reserved.
 *
 * This code is the proprietary information of Hodynguyen (Nguyen Thanh Dat).
 * Redistribution or modification of this code is strictly prohibited without 
 * prior written permission from the author.
 */

 package data_structure_implement.LinkedList;

 /**
  * LinkedList class represents a basic implementation of a singly linked list.
  * It supports add, remove, get, isEmpty, and size operations.
  * 
  * @author Hodynguyen
  * @version 1.0
  * @since 2024
  */
class LinkedList<T> {
    private Node<T> head; // Head of the linked list
    private int size;     // Current size of the linked list

    /**
     * Node class represents each element in the linked list.
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Constructor initializes an empty linked list.
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Adds an element to the end of the list.
     * 
     * @param data The element to be added
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Removes the element at the specified position.
     * 
     * @param index Position of the element to remove
     * @return The removed element
     * @throws IndexOutOfBoundsException If index is out of range
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        T removedData;
        if (index == 0) {
            removedData = head.data;
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedData = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return removedData;
    }

    /**
     * Returns the element at the specified position.
     * 
     * @param index Position of the element
     * @return The element at the specified position
     * @throws IndexOutOfBoundsException If index is out of range
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Checks if the linked list is empty.
     * 
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the current size of the linked list.
     * 
     * @return The number of elements in the list
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

/**
 * Test class for LinkedList implementation.
 * 
 * @author Hodynguyen
 * @version 1.0
 * @since 2024
 */
class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Add elements
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("List after add operations: " + list);

        // Get element at index 1
        System.out.println("Element at index 1: " + list.get(1)); // Output: 20

        // Remove element at index 1
        System.out.println("Removed element: " + list.remove(1)); // Output: 20
        System.out.println("List after remove operation: " + list);

        // Check if list is empty
        System.out.println("Is list empty? " + list.isEmpty()); // Output: false

        // Get size of the list
        System.out.println("List size: " + list.size()); // Output: 2
    }
}
