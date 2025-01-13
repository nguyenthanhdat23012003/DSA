/*
 * Copyright (c) 2024 Hodynguyen (Nguyen Thanh Dat).
 * All rights reserved.
 *
 * This code is the proprietary information of Hodynguyen (Nguyen Thanh Dat).
 * Redistribution or modification of this code is strictly prohibited without 
 * prior written permission from the author.
 */

 package data_structure_implement.BinaryTree;

 import java.util.LinkedList;
 import java.util.Queue;
 
 /**
  * TreeNode class represents a node in the BinaryTree.
  * It contains a value and references to left and right child nodes.
  */
 class TreeNode<T> {
     T value;
     TreeNode<T> left, right;
 
     TreeNode(T value) {
         this.value = value;
         left = right = null;
     }
 }
 
 /**
  * BinaryTree class represents a basic implementation of a binary tree.
  * It supports add, search, traversal, height calculation, and node counting.
  *
  * @param <T> The type of the elements in the binary tree.
  *
  * @author Hodynguyen
  * @version 1.0
  * @since 2024
  */
 public class BinaryTree<T> {
     private TreeNode<T> root;
 
     /**
      * Adds an element to the binary tree in level-order.
      *
      * @param value The element to be added.
      */
     public void add(T value) {
         if (root == null) {
             root = new TreeNode<>(value);
             return;
         }
 
         Queue<TreeNode<T>> queue = new LinkedList<>();
         queue.add(root);
 
         while (!queue.isEmpty()) {
             TreeNode<T> curr = queue.poll();
 
             if (curr.left == null) {
                 curr.left = new TreeNode<>(value);
                 break;
             } else {
                 queue.add(curr.left);
             }
 
             if (curr.right == null) {
                 curr.right = new TreeNode<>(value);
                 break;
             } else {
                 queue.add(curr.right);
             }
         }
     }
 
     /**
      * Searches for an element in the binary tree.
      *
      * @param value The element to search for.
      * @return True if the element is found, false otherwise.
      */
     public boolean search(T value) {
         if (root == null) return false;
 
         Queue<TreeNode<T>> queue = new LinkedList<>();
         queue.add(root);
 
         while (!queue.isEmpty()) {
             TreeNode<T> curr = queue.poll();
 
             if (curr.value.equals(value)) return true;
 
             if (curr.left != null) queue.add(curr.left);
             if (curr.right != null) queue.add(curr.right);
         }
 
         return false;
     }
 
     /**
      * Performs a level-order traversal of the binary tree.
      */
     public void levelOrderTraversal() {
         if (root == null) return;
 
         Queue<TreeNode<T>> queue = new LinkedList<>();
         queue.add(root);
 
         while (!queue.isEmpty()) {
             TreeNode<T> curr = queue.poll();
             System.out.print(curr.value + " ");
 
             if (curr.left != null) queue.add(curr.left);
             if (curr.right != null) queue.add(curr.right);
         }
 
         System.out.println();
     }
 
     /**
      * Performs a pre-order traversal of the binary tree.
      */
     public void preOrderTraversal() {
         preOrderHelper(root);
         System.out.println();
     }
 
     private void preOrderHelper(TreeNode<T> node) {
         if (node == null) return;
         System.out.print(node.value + " ");
         preOrderHelper(node.left);
         preOrderHelper(node.right);
     }
 
     /**
      * Performs an in-order traversal of the binary tree.
      */
     public void inOrderTraversal() {
         inOrderHelper(root);
         System.out.println();
     }
 
     private void inOrderHelper(TreeNode<T> node) {
         if (node == null) return;
         inOrderHelper(node.left);
         System.out.print(node.value + " ");
         inOrderHelper(node.right);
     }
 
     /**
      * Performs a post-order traversal of the binary tree.
      */
     public void postOrderTraversal() {
         postOrderHelper(root);
         System.out.println();
     }
 
     private void postOrderHelper(TreeNode<T> node) {
         if (node == null) return;
         postOrderHelper(node.left);
         postOrderHelper(node.right);
         System.out.print(node.value + " ");
     }
 
     /**
      * Calculates the height of the binary tree.
      *
      * @return The height of the tree.
      */
     public int height() {
         return heightHelper(root);
     }
 
     private int heightHelper(TreeNode<T> node) {
         if (node == null) return 0;
         return 1 + Math.max(heightHelper(node.left), heightHelper(node.right));
     }
 
     /**
      * Counts the number of nodes in the binary tree.
      *
      * @return The number of nodes in the tree.
      */
     public int countNodes() {
         return countNodesHelper(root);
     }
 
     private int countNodesHelper(TreeNode<T> node) {
         if (node == null) return 0;
         return 1 + countNodesHelper(node.left) + countNodesHelper(node.right);
     }
 
     /**
      * Clears the binary tree by setting the root to null.
      */
     public void clear() {
         root = null;
     }
 }
 
 /**
  * Test class for BinaryTree implementation.
  *
  * This class demonstrates the usage of BinaryTree with basic operations such as
  * adding elements, searching for elements, traversing the tree, calculating height,
  * and counting nodes.
  *
  * @author Hodynguyen
  * @version 1.0
  * @since 2024
  */
 class TestBinaryTree {
     public static void main(String[] args) {
         BinaryTree<Integer> tree = new BinaryTree<>();
 
         // Add elements
         tree.add(10);
         tree.add(20);
         tree.add(30);
         tree.add(40);
         tree.add(50);
 
         System.out.println("Binary Tree after adding elements:");
         tree.levelOrderTraversal(); // Output: 10 20 30 40 50
 
         // Search elements
         System.out.println("Is 30 in the tree? " + tree.search(30)); // Output: true
         System.out.println("Is 100 in the tree? " + tree.search(100)); // Output: false
 
         // Traversals
         System.out.println("Pre-order traversal:");
         tree.preOrderTraversal(); // Output: 10 20 40 50 30
 
         System.out.println("In-order traversal:");
         tree.inOrderTraversal(); // Output: 40 20 50 10 30
 
         System.out.println("Post-order traversal:");
         tree.postOrderTraversal(); // Output: 40 50 20 30 10
 
         // Tree height
         System.out.println("Height of the tree: " + tree.height()); // Output: 3
 
         // Node count
         System.out.println("Number of nodes in the tree: " + tree.countNodes()); // Output: 5
 
         // Clear the tree
         tree.clear();
         System.out.println("Binary Tree after clearing:");
         tree.levelOrderTraversal(); // Output: (no output, tree is empty)
 
         System.out.println("Is tree empty? " + (tree.countNodes() == 0)); // Output: true
     }
 }
 