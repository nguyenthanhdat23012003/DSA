/*
 * Copyright (c) 2024 Hodynguyen (Nguyen Thanh Dat).
 * All rights reserved.
 *
 * This code is the proprietary information of Hodynguyen (Nguyen Thanh Dat).
 * Redistribution or modification of this code is strictly prohibited without 
 * prior written permission from the author.
 */

package data_structure_implement.TrieTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * TrieNode class represents a node in the Trie structure.
 * Each node has a HashMap of children nodes representing the next characters
 * and a boolean to indicate if the node is the end of a valid word.
 * 
 * @author Hodynguyen
 * @version 1.0
 * @since 2024
 */
class TrieNode {
    /**
     * The children list of the current node, where each child corresponds to a character in the Trie.
     * The key is a character, and the value is a TrieNode representing the next level in the Trie.
     */
    private HashMap<Character, TrieNode> childrenList;

    /**
     * A flag indicating whether this node represents the end of a valid word in the Trie.
     */
    private boolean isEndOfWord;

    /**
     * Constructor initializes an empty children list HashMap
     * and sets isEndOfWord to false.
     */
    public TrieNode() {
        childrenList = new HashMap<>();
        isEndOfWord = false;
    }

    /**
     * Gets the children list of the current TrieNode.
     *
     * @return A HashMap containing the child nodes, where the key is a character.
     */
    public HashMap<Character, TrieNode> getChildrenList(){
        return this.childrenList;
    }

    /**
     * Checks if this TrieNode represents the end of a word.
     *
     * @return true if this node is the end of a word, false otherwise.
     */
    public boolean getIsEndOfWord(){
        return this.isEndOfWord;
    }

    /**
     * Sets the isEndOfWord flag for this TrieNode.
     *
     * @param isEndOfWord true if this node represents the end of a word.
     */
    public void setIsEndOfWord(boolean isEndOfWord){
        this.isEndOfWord = isEndOfWord;
    }
}

/**
 * Trie class represents a Trie data structure.
 * It supports insertion, searching, prefix matching, deletion of words and print Trie.
 * @author Hodynguyen
 * @version 1.0
 * @since 2024
 */
class Trie {
    /**
     * The root node of the Trie, representing the starting point for all words in the Trie.
     */
    private TrieNode root;
    
    /**
     * Constructor initializes the Trie with an empty root node.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the Trie.
     * If the word already exists, it marks the last node as the end of the word.
     *
     * @param word The word to be inserted into the Trie.
     */
    public void insert(String word) {
        // Idea: Traverse through word, check each character to see if it is in the Trie or not. 
        // If not, create a new TrieNode, mark the last character with isEndOfWord.
        TrieNode current = root;

        for(char c : word.toCharArray()) {
            if(!current.getChildrenList().containsKey(c)) {
                current.getChildrenList().put(c, new TrieNode());
            }
            current = current.getChildrenList().get(c);
        }

        current.setIsEndOfWord(true);
    }

    /**
     * Searches for a word in the Trie.
     *
     * @param word The word to search for.
     * @return true if the word exists in the Trie and is marked as a complete word, false otherwise.
     */
    public boolean search(String word) {
        // Idea: Traverse through word, check each character to see if it is in the Trie or not
        // If not, return false, if it is, check isEndOfWord of the last character.
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            if(!current.getChildrenList().containsKey(c)) {
                return false;
            }

            current = current.getChildrenList().get(c);
        }

        return current.getIsEndOfWord();
    }

    /**
     * Checks if there is any word in the Trie that starts with the given prefix.
     *
     * @param prefix The prefix to check.
     * @return true if there is a word that starts with the prefix, false otherwise.
     */
    public boolean startWith(String prefix) {
        // Idea: Traverse through prefix, check each character to see if it is in the Trie or not
        // If not, return false, if it is, return true.
        TrieNode current = root;
        for(char c : prefix.toCharArray()) {
            if(!current.getChildrenList().containsKey(c)) {
                return false;
            }

            current = current.getChildrenList().get(c);
        }

        return true;
    }

    /**
     * Delete a word from the Trie. It removes nodes that are no longer needed after the word is deleted.
     *
     * @param word The word to delete from the Trie.
     * @return true if the word was successfully deleted, false if the word was not found.
     */
    public boolean delete(String word) {
        // Idea:
        // 1. First, check if the word exists in the Trie using the search method.
        //    If the word doesn't exist, return false.
        if(!search(word)) return false;

        // 2. If the word exists, traverse the Trie while storing the nodes and characters in stacks.
        Stack<TrieNode> nodes = new Stack<>();
        Stack<Character> chars = new Stack<>();
        TrieNode current = root;
        for(char c : word.toCharArray()){
            nodes.push(current);
            chars.push(c);
            current = current.getChildrenList().get(c);
        }
        
        // 3. Once you reach the end of the word, mark the node's isEndOfWord to false to "unmark" the end of the word.
        current.setIsEndOfWord(false);

        // 4. Then, traverse back using the stacks, removing the child nodes if they:
        //    a) have no children of their own (i.e., an empty children list),
        //    b) are not marked as the end of any other word.
        // 5. Continue this process until you either remove all unnecessary nodes or encounter a node
        //    that is part of another word or a prefix of another word, where the process should stop.
        while(!nodes.isEmpty()) {
            current = nodes.pop();
            char ch = chars.pop();

            if(current.getChildrenList().get(ch).getChildrenList().isEmpty()
            && !current.getChildrenList().get(ch).getIsEndOfWord()) {
                current.getChildrenList().remove(ch);
            } else {
                break;
            }
        }

        return true;
    }

    /**
     * Converts the Trie to a String representation by traversing all the words in the Trie.
     * This method performs a depth-first traversal of the Trie and collects all valid words.
     *
     * @return A String containing all words in the Trie.
     *         Each word is stored in an ArrayList and returned as a single string representation.
     */
    public String toString() {
        // Idea: DFS (Depth-First Search Algorithm)
        // 1. Initialize an ArrayList `trieList` to store all valid words in the Trie.        
        ArrayList<String> trieList = new ArrayList<>();

        // 2. Use two stacks: 
        //    a) `stackNode` to store the TrieNode instances.
        //    b) `stackWord` to store the corresponding words built so far at each TrieNode.
        Stack<TrieNode> stackNode = new Stack<>();
        Stack<String> stackWord = new Stack<>();

        // 3. Begin the depth-first traversal from the root node by pushing the root and an empty string to the stacks.
        stackNode.push(root);
        stackWord.push("");
        
        // Perform depth-first traversal
        while (!stackNode.isEmpty()) {
            // 4. In each iteration, pop a TrieNode from `stackNode` and the corresponding word from `stackWord`.
            TrieNode currentNode = stackNode.pop();
            String currentWord = stackWord.pop();

            // 5. If the current node marks the end of a word (isEndOfWord), add the word to the `trieList`.
            if (currentNode.getIsEndOfWord()) {
                trieList.add(currentWord);
            }

            // 6. For each character-child pair in the current node, push the child node to `stackNode` 
            //    and append the character to the word, pushing this new word to `stackWord`.
            for (char c : currentNode.getChildrenList().keySet()) {
                stackNode.push(currentNode.getChildrenList().get(c));
                stackWord.push(currentWord + c);
            }

            // 7. Repeat until all nodes have been processed and return the string representation of `trieList`.
        }

        // Return the list of words as a string
        return trieList.toString();
    }
}

/**
 * Test Class for Trie
 * 
 * @author Hodynguyen
 * @version 1.0
 * @since 2024
 */
class TestTrieTree {
    public static void main(String[] args) {
        Trie vocabularyTrie = new Trie();
        // Test Trie: { "cat", "car", "cart", "dog", "dove", "deer", "do", "apple" }
        // See ./Trie_example.png or go to https://www.cs.usfca.edu/~galles/visualization/Trie.html to visualize by yourself
        vocabularyTrie.insert("cat");
        vocabularyTrie.insert("car");
        vocabularyTrie.insert("cart");
        vocabularyTrie.insert("dog");
        vocabularyTrie.insert("dove");
        vocabularyTrie.insert("deer");
        vocabularyTrie.insert("do");
        vocabularyTrie.insert("apple");
        System.out.println(vocabularyTrie.toString());
        System.out.println(vocabularyTrie.search("apple"));
        System.out.println(vocabularyTrie.search("app"));
        System.out.println(vocabularyTrie.startWith("ap"));
        System.out.println(vocabularyTrie.startWith("application"));
        System.out.println(vocabularyTrie.toString());
        vocabularyTrie.delete("do");
        System.out.println(vocabularyTrie.toString());
    }
}
