# Trie Tree

## Giới thiệu
Trie, còn được gọi là cây tiền tố, là một cấu trúc dữ liệu cây được sử dụng để lưu trữ một tập hợp các chuỗi. Trie cho phép tìm kiếm, chèn và xóa chuỗi một cách hiệu quả. Nó đặc biệt hữu ích trong các bài toán yêu cầu tìm kiếm tiền tố và lưu trữ từ điển.

## Cấu trúc
Mỗi nút trong Trie đại diện cho một ký tự trong từ. Một nút có thể có nhiều con, tương ứng với các ký tự khác nhau có thể tiếp theo trong từ. Nút gốc không chứa ký tự nào và các nút con lưu trữ các ký tự của từ.

### Đặc điểm của Trie
- **Tìm kiếm nhanh:** Thời gian tìm kiếm cho mỗi từ là O(m), trong đó m là độ dài của từ.
- **Tiết kiệm không gian:** Trie có thể tiết kiệm không gian khi nhiều từ chia sẻ các tiền tố giống nhau.
- **Tìm kiếm tiền tố:** Trie rất hiệu quả cho việc tìm kiếm tiền tố.

## Các phương thức chính
Dưới đây là các phương thức chính thường được triển khai trong Trie:

1. **Chèn (Insert):**
   - Thêm một từ vào Trie.
   - Bắt đầu từ nút gốc và duyệt từng ký tự của từ, tạo nút mới nếu nút cho ký tự đó không tồn tại.
   - Đánh dấu nút cuối cùng của từ là một từ hoàn chỉnh.

2. **Tìm kiếm (Search):**
   - Kiểm tra xem một từ có tồn tại trong Trie hay không.
   - Duyệt qua từng ký tự của từ, nếu không tìm thấy ký tự tại bất kỳ nút nào thì trả về `false`. Nếu tìm thấy và nút cuối cùng được đánh dấu là một từ hoàn chỉnh, trả về `true`.

3. **Kiểm tra tiền tố (Starts With):**
   - Kiểm tra xem có bất kỳ từ nào trong Trie bắt đầu bằng một tiền tố nhất định.
   - Tương tự như tìm kiếm, nhưng không cần phải kiểm tra dấu kết thúc.

4. **Xóa (Delete):**
   - Xóa một từ khỏi Trie.
   - Duyệt theo từng ký tự và xóa các nút nếu không còn từ nào khác chia sẻ cùng tiền tố.

## Cách hoạt động
Trie hoạt động bằng cách phân tách các từ thành các ký tự và tổ chức chúng theo cách mà các ký tự giống nhau được lưu trữ cùng nhau. Điều này cho phép nhanh chóng tìm kiếm một từ hoặc kiểm tra sự tồn tại của các tiền tố.

### Ví dụ
Giả sử bạn muốn lưu trữ các từ sau trong Trie: `["apple", "app", "bat", "ball"]`.

- **Chèn từ:**
    - Từ "apple":
        - Chèn ký tự 'a', 'p', 'p', 'l', 'e' vào Trie.
    - Từ "app":
        - Duyệt qua 'a', 'p', 'p' đã tồn tại, chỉ cần đánh dấu nút 'p' cuối cùng là một từ hoàn chỉnh.
    - Từ "bat":
        - Tạo mới các nút cho 'b', 'a', 't'.
    - Từ "ball":
        - Tạo mới cho 'b', 'a', 'l', 'l' nhưng sử dụng nút 'b' và 'a' đã có.

- **Tìm kiếm:**
    - Tìm kiếm "app" sẽ trả về `true`.
    - Tìm kiếm "bat" sẽ trả về `true`.
    - Tìm kiếm "bad" sẽ trả về `false`.

## Ứng dụng của Trie
- Tìm kiếm nhanh trong từ điển.
- Tìm kiếm và tự động hoàn thành trong các ứng dụng nhập liệu.
- Phân tích chuỗi và tìm kiếm tiền tố.


## Triển khai


Dưới đây là một triển khai đầy đủ của cây Trie trong Java, bao gồm các phương thức để chèn, tìm kiếm và xóa từ. Mỗi từ được lưu trữ theo cách cho phép tìm kiếm nhanh và hiệu quả theo từng ký tự.

**Dưới đây chỉ là code sample, có thể khó hiểu và khó tiếp cận. Chi tiết hơn xem tại data_structure_implement/TrieTree**

```java
import java.util.HashMap;

class TrieNode {
    // Mỗi nút có thể chứa nhiều ký tự
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord; // Đánh dấu điểm kết thúc của từ

    // Constructor
    public TrieNode() {
        children = new HashMap<>(); // Khởi tạo danh sách con
        isEndOfWord = false; // Mặc định là không phải là điểm kết thúc của từ
    }
}

class Trie {
    private TrieNode root; // Nút gốc của Trie

    // Constructor
    public Trie() {
        root = new TrieNode(); // Khởi tạo nút gốc
    }

    // Phương thức để chèn một từ vào Trie
    public void insert(String word) {
        TrieNode current = root; // Bắt đầu từ nút gốc

        for (char c : word.toCharArray()) { // Duyệt qua từng ký tự
            current = current.children.computeIfAbsent(c, k -> new TrieNode()); // Tạo nút mới nếu không tồn tại
        }
        current.isEndOfWord = true; // Đánh dấu điểm kết thúc của từ
    }

    // Phương thức để tìm kiếm một từ trong Trie
    public boolean search(String word) {
        TrieNode current = root; // Bắt đầu từ nút gốc

        for (char c : word.toCharArray()) { // Duyệt qua từng ký tự
            if (!current.children.containsKey(c)) { // Nếu ký tự không tồn tại
                return false; // Từ không tồn tại
            }
            current = current.children.get(c); // Di chuyển đến nút con
        }
        return current.isEndOfWord; // Trả về true nếu là điểm kết thúc của từ
    }

    // Phương thức để kiểm tra xem có từ nào bắt đầu bằng một tiền tố nhất định không
    public boolean startsWith(String prefix) {
        TrieNode current = root; // Bắt đầu từ nút gốc

        for (char c : prefix.toCharArray()) { // Duyệt qua từng ký tự của tiền tố
            if (!current.children.containsKey(c)) { // Nếu ký tự không tồn tại
                return false; // Tiền tố không tồn tại
            }
            current = current.children.get(c); // Di chuyển đến nút con
        }
        return true; // Tiền tố tồn tại
    }

    // Phương thức để xóa một từ trong Trie
    public boolean delete(String word) {
        return delete(root, word, 0); // Gọi hàm xóa từ gốc
    }

    // Phương thức đệ quy để xóa từ
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false; // Từ không tồn tại
            }
            current.isEndOfWord = false; // Đánh dấu không còn là điểm kết thúc
            return current.children.isEmpty(); // Trả về true nếu nút hiện tại không có con
        }

        char ch = word.charAt(index); // Lấy ký tự hiện tại
        TrieNode node = current.children.get(ch); // Lấy nút con tương ứng

        if (node == null) {
            return false; // Từ không tồn tại
        }

        boolean shouldDeleteCurrentNode = delete(node, word, index + 1); // Đệ quy xóa ký tự tiếp theo

        if (shouldDeleteCurrentNode) {
            current.children.remove(ch); // Xóa nút con
            return current.children.isEmpty() && !current.isEndOfWord; // Trả về true nếu nút hiện tại không còn con
        }

        return false; // Không cần xóa
    }

    // Xóa phần tử không dùng đệ quy
    public boolean delete(String word) {
        if(!search(word)) return false;
        TrieNode current = root;
        Stack<TrieNode> nodes = new Stack<>();
        Stack<Character> chars = new Stack<>();
        for(char c : word.toCharArray()) {
            nodes.push(current);
            chars.push(c);
            current = current.children.get(c);
        }

        current.isEndOfWord = false;

        while (!nodes.isEmpty()) {
            current = nodes.pop();
            char ch = chars.pop();

            if(current.children.get(ch).children.isEmpty() 
            && !current.children.get(ch).isEndOfWord) {
                current.children.remove(ch);
            } else {
                break;
            }
        }

        return true;
    }

    // In ra trie tree
    public String printTrie() {
        ArrayList<String> stringList = new ArrayList<>();
        Stack<TrieNode> stackNode = new Stack<>();
        Stack<String> stackWord = new Stack<>();
    
        stackNode.push(root);
        stackWord.push("");
    
        while (!stackNode.isEmpty()) {
            TrieNode currentNode = stackNode.pop();
            String currentWord = stackWord.pop();
    
            if (currentNode.isEndOfWord) {
                stringList.add(currentWord);
            }
    
            for (char c : currentNode.children.keySet()) {
                stackNode.push(currentNode.children.get(c));
                stackWord.push(currentWord + c);
            }
        }
    
        return stringList.toString();
    }
}

// Ví dụ sử dụng
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("helium");
        trie.insert("hey");

        System.out.println(trie.search("hello")); // true
        System.out.println(trie.search("hell")); // false
        System.out.println(trie.startsWith("he")); // true
        System.out.println(trie.startsWith("hi")); // false

        trie.delete("hello");
        System.out.println(trie.search("hello")); // false
    }
}

```

### Giải thích mã

#### Lớp TrieNode
- Chứa một `HashMap` để lưu trữ các ký tự con.
- Có một biến `boolean` để đánh dấu nếu nút là điểm kết thúc của một từ.

#### Lớp Trie
- Chứa nút gốc và các phương thức để:
  - Chèn (insert)
  - Tìm kiếm (search)
  - Kiểm tra tiền tố (startsWith)
  - Xóa từ (delete)

#### Phương thức insert
- Thêm một từ mới vào Trie.
- Tạo các nút con nếu cần thiết để biểu diễn các ký tự của từ.

#### Phương thức search
- Kiểm tra xem một từ có tồn tại trong Trie hay không.
- Nếu từ tìm kiếm được tìm thấy và đánh dấu tại nút cuối cùng, trả về `true`; ngược lại, trả về `false`.

#### Phương thức startsWith
- Kiểm tra xem có bất kỳ từ nào trong Trie bắt đầu bằng một tiền tố nhất định.
- Duyệt qua các ký tự của tiền tố và trả về `true` nếu tất cả ký tự tồn tại; ngược lại, trả về `false`.

#### Phương thức delete
- Xóa một từ khỏi Trie.
- Kiểm tra nếu không còn nút con nào sau khi xóa từ thì xóa nút cha.

#### Phương thức Print
- In ra TrieTree

## Kết luận
Trie là một cấu trúc dữ liệu mạnh mẽ để quản lý và tìm kiếm chuỗi. Với các thao tác tìm kiếm, chèn và xóa nhanh chóng, Trie rất hữu ích trong nhiều ứng dụng liên quan đến xử lý chuỗi.