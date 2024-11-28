
# Thuật toán Rùa và Thỏ (Floyd's Cycle Detection Algorithm)

Thuật toán **Rùa và Thỏ**, hay còn gọi là **Floyd's Cycle Detection Algorithm**, là một phương pháp hiệu quả để phát hiện vòng lặp trong các chuỗi hoặc cấu trúc dữ liệu như danh sách liên kết. Thuật toán này sử dụng hai con trỏ di chuyển với tốc độ khác nhau để xác định liệu có vòng lặp tồn tại hay không.

## Ý tưởng thuật toán

1. **Hai con trỏ**:
   - **Con rùa (slow)**: Di chuyển từng bước một.
   - **Con thỏ (fast)**: Di chuyển hai bước một.

2. **Phát hiện vòng lặp**:
   - Nếu có vòng lặp trong cấu trúc dữ liệu, hai con trỏ sẽ gặp nhau tại một điểm nào đó bên trong vòng lặp.
   - Nếu không có vòng lặp, con thỏ sẽ đi đến cuối cấu trúc dữ liệu.

---

## Ứng dụng

### 1. Phát hiện vòng lặp trong danh sách liên kết
- **Bài toán**: Kiểm tra xem một danh sách liên kết có chứa vòng lặp hay không.
- **Thuật toán**: Sử dụng hai con trỏ để duyệt qua danh sách. Nếu hai con trỏ gặp nhau, danh sách có vòng lặp.

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}

```

---

### 2. Tìm điểm bắt đầu của vòng lặp trong danh sách liên kết
- **Bài toán**: Nếu danh sách liên kết có vòng lặp, xác định nút bắt đầu của vòng lặp.
- **Thuật toán**: Sau khi phát hiện vòng lặp, đặt một con trỏ tại đầu danh sách và một con trỏ tại vị trí gặp nhau. Di chuyển cả hai con trỏ từng bước một cho đến khi chúng gặp nhau lần nữa.

```java
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null;
    }
}

```

---

### 3. Phát hiện vòng lặp trong chuỗi số (Happy Number)
- **Bài toán**: Kiểm tra xem một số có phải là "Happy Number" hay không.
- **Thuật toán**: Sử dụng hai con trỏ để theo dõi quá trình lặp của tổng bình phương các chữ số. Phát hiện vòng lặp để xác định các số không hạnh phúc.

```java
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getSumOfSquares(n);

        while (fast != 1 && slow != fast) {
            slow = getSumOfSquares(slow);
            fast = getSumOfSquares(getSumOfSquares(fast));
        }

        return fast == 1;
    }

    private int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}

```
---

## Lợi ích của thuật toán

1. **Hiệu quả về bộ nhớ**:
   - Chỉ cần sử dụng bộ nhớ `O(1)` cho hai con trỏ.

2. **Thời gian chạy hiệu quả**:
   - Thời gian chạy trung bình là `O(n)`.

3. **Đơn giản và dễ hiểu**:
   - Dễ dàng triển khai và áp dụng cho nhiều bài toán khác nhau.

---

## Tóm tắt

Thuật toán **Rùa và Thỏ** là một công cụ mạnh mẽ và hiệu quả để phát hiện vòng lặp trong chuỗi hoặc cấu trúc dữ liệu. Nhờ tính tối ưu về bộ nhớ và thời gian, nó được sử dụng rộng rãi trong các bài toán như danh sách liên kết, số hạnh phúc, hoặc phân tích các dãy số ngẫu nhiên.