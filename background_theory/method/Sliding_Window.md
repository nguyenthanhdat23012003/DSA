# Phương Pháp Sliding Window

Phương pháp **Sliding Window** là một kỹ thuật phổ biến để xử lý các dãy con liên tiếp trong chuỗi hoặc mảng. Phương pháp này giúp tối ưu hóa hiệu năng bằng cách tránh tính toán lại toàn bộ các phần tử khi di chuyển cửa sổ.

## Ý tưởng Chính
Sliding Window sử dụng một "cửa sổ" di chuyển dọc theo mảng hoặc chuỗi và chỉ chứa một số phần tử nhất định. Khi cửa sổ di chuyển, các phần tử mới sẽ được thêm vào và các phần tử cũ sẽ bị loại ra, giúp tối ưu hóa quá trình tính toán.

## Các Loại Sliding Window

### 1. Fixed-size Window (Cửa sổ cố định)
Phù hợp khi cần xử lý các dãy con liên tiếp có độ dài cố định. Ví dụ: Tìm tổng lớn nhất của một dãy con liên tiếp gồm `k` phần tử trong một mảng.

#### Ví dụ
Giả sử bạn có mảng `arr = [2, 1, 5, 1, 3, 2]` và `k = 3`. Bài toán yêu cầu tìm **tổng lớn nhất** của một dãy con liên tiếp gồm `k` phần tử.

#### Code Java cho Fixed-size Window

```java
public class SlidingWindow {

    // Phương thức tìm tổng lớn nhất của dãy con có độ dài k
    public static int maxSumFixedWindow(int[] arr, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int currentSum = maxSum;
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max sum of fixed window: " + maxSumFixedWindow(arr, k));  // Output: 9
    }
}
```
### 2. Dynamic-size Window (Cửa sổ động)
Cửa sổ có kích thước thay đổi, dùng khi cần tìm dãy con thỏa mãn điều kiện nào đó. Ví dụ: Tìm chuỗi con dài nhất chứa tối đa 2 ký tự khác nhau trong chuỗi `s = "abcba"`.

#### Cách Giải Quyết
1. Dùng hai con trỏ `start` và `end` để xác định phạm vi của cửa sổ.
2. Di chuyển con trỏ `end` sang phải, thêm ký tự vào cửa sổ mỗi lần mở rộng cửa sổ.
3. Kiểm tra điều kiện: Nếu cửa sổ có hơn 2 ký tự khác nhau, di chuyển con trỏ `start` sang phải để thu hẹp cửa sổ.
4. Cập nhật độ dài chuỗi con dài nhất mỗi khi cửa sổ thoả mãn điều kiện.

#### Code Java cho Dynamic-size Window
```java
import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    public static int longestSubstrWithTwoDistinctChars(String s) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> charCount = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            charCount.put(endChar, charCount.getOrDefault(endChar, 0) + 1);

            // Kiểm tra nếu có nhiều hơn 2 ký tự khác nhau
            while (charCount.size() > 2) {
                char startChar = s.charAt(start);
                charCount.put(startChar, charCount.get(startChar) - 1);
                if (charCount.get(startChar) == 0) {
                    charCount.remove(startChar);
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcba";
        System.out.println("Longest substring with two distinct chars: " + longestSubstrWithTwoDistinctChars(s));  // Output: 3 ("bcb")
    }
}
```
## Tóm tắt
| Loại cửa sổ         | Ứng dụng                               | Khi nào nên sử dụng                  |
|---------------------|----------------------------------------|--------------------------------------|
| Fixed-size Window   | Tính tổng, trung bình, tích, v.v.      | Khi kích thước dãy con cố định       |
| Dynamic-size Window | Tìm chuỗi con thỏa mãn điều kiện       | Khi kích thước dãy con thay đổi      |

Phương pháp sliding window giúp tối ưu hóa các bài toán liên quan đến dãy con liên tiếp nhờ vào việc tính toán lại các phần tử một cách hiệu quả.
