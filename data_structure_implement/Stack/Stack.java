/*
 * Copyright (c) 2024 Hodynguyen (Nguyen Thanh Dat).
 * All rights reserved.
 *
 * This code is the proprietary information of Hodynguyen (Nguyen Thanh Dat).
 * Redistribution or modification of this code is strictly prohibited without 
 * prior written permission from the author.
 */

package data_structure_implement.Stack;

import java.util.EmptyStackException;

/**
 * Stack class represents a basic implementation of a Stack data structure.
 * It supports push, pop, peek, isEmpty, and size operations.
 * 
 * @author Hodynguyen
 * @version 1.0
 * @since 2024
 */
class Stack<T> {
    private T[] elements; // Array to store stack elements
    private int size;     // Current size of the stack
    private int capacity; // Maximum capacity of the stack

    /**
     * Constructor with default capacity.
     */
    public Stack() {
        this(10); // Default capacity
    }

    /**
     * Constructor with custom capacity.
     * 
     * @param capacity Initial capacity of the stack
     */
    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        this.capacity = capacity;
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * Pushes an element onto the stack.
     * 
     * @param element The element to be added
     */
    public void push(T element) {
        if (size == capacity) {
            resize(); // Automatically resize if the stack is full
        }
        elements[size++] = element;
    }

    /**
     * Removes the top element from the stack and returns it.
     * 
     * @return The top element
     * @throws EmptyStackException If the stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T topElement = elements[--size];
        elements[size] = null; // Prevent memory leak
        return topElement;
    }

    /**
     * Returns the top element without removing it.
     * 
     * @return The top element
     * @throws EmptyStackException If the stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[size - 1];
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the current size of the stack.
     * 
     * @return The number of elements in the stack
     */
    public int size() {
        return size;
    }

    /**
     * Resizes the stack to accommodate more elements.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2; // Double the capacity
        T[] newElements = (T[]) new Object[capacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

/**
 * Test class for Stack implementation.
 * 
 * @author Hodynguyen
 * @version 1.0
 * @since 2024
 */
class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after push operations: " + stack);

        // Peek the top element
        System.out.println("Top element: " + stack.peek()); // Output: 30

        // Pop elements
        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Stack after pop operation: " + stack);

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false

        // Push more elements
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70); // Should resize the stack
        System.out.println("Stack after resizing: " + stack);

        // Get size of the stack
        System.out.println("Stack size: " + stack.size()); // Output: 6
    }
}


