package problem.easy.Longest_Common_Prefix;

// import java.util.HashMap;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // // Solution 1: Trie
        // Trie list = new Trie();
        // String empty = "";
        // for(String str : strs) {
        //     if(str.equals(empty)) return empty;
        //     list.insert(str);
        // }
        // return list.commonPrefix();

        // Solution 2: Traverse Array
        String longest = strs[0];
        for(String str : strs){
            while(str.indexOf(longest) != 0){
                longest = longest.substring(0, longest.length() - 1);
            }
        }

        return longest;
    }
}

// class TrieNode {
//     private HashMap<Character, TrieNode> childrenList;
//     private boolean isEndOfWord;

//     public TrieNode() {
//         childrenList = new HashMap<>();
//         isEndOfWord = false;
//     }

//     public HashMap<Character, TrieNode> getChildrenList(){
//         return this.childrenList;
//     }

//     public boolean getIsEndOfWord(){
//         return this.isEndOfWord;
//     }

//     public void setIsEndOfWord(boolean isEndOfWord){
//         this.isEndOfWord = isEndOfWord;
//     }
// }

// class Trie {
//     private TrieNode root;

//     public Trie() {
//         root = new TrieNode();
//     }

//     public void insert(String word) {
//         TrieNode current = root;

//         for(char c : word.toCharArray()) {
//             if(!current.getChildrenList().containsKey(c)) {
//                 current.getChildrenList().put(c, new TrieNode());
//             }
//             current = current.getChildrenList().get(c);
//         }

//         current.setIsEndOfWord(true);
//     }

//     public String commonPrefix() {
//         TrieNode current = root;
//         String longest = "";
//         while(current.getChildrenList().size() == 1) {
//             for(char c : current.getChildrenList().keySet()) {
//                 longest+=c;
//                 current = current.getChildrenList().get(c);
//                 if(current.getIsEndOfWord()) break;
//             }
//             if(current.getIsEndOfWord()) break;
//         }

//         return longest;
//     }
// }

