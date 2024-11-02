# Phương Pháp Sliding Window

Phương pháp **Sliding Window** (cửa sổ trượt) là một kỹ thuật được sử dụng rộng rãi để xử lý chuỗi hoặc mảng, giúp giải quyết các bài toán yêu cầu kiểm tra các dãy con liên tiếp của dữ liệu một cách hiệu quả.

## Ý tưởng Chính
Sliding Window sử dụng một "cửa sổ" di chuyển dọc theo mảng hoặc chuỗi và chỉ chứa một số phần tử nhất định. Khi cửa sổ di chuyển, các phần tử mới sẽ được thêm vào và các phần tử cũ sẽ bị loại ra, giúp tối ưu hóa quá trình tính toán.

## Các Loại Sliding Window
1. **Fixed-size Window**: Cửa sổ có kích thước cố định, sử dụng khi cần tính toán trên các dãy con có độ dài xác định.
2. **Dynamic-size Window**: Cửa sổ có kích thước thay đổi, sử dụng khi cần tìm dãy con thỏa mãn điều kiện nhất định.

## Ví dụ Minh Họa
Giả sử có bài toán tìm **tổng lớn nhất của dãy con liên tiếp gồm `k` phần tử** trong mảng `arr`.

### Input
- `arr = [2, 1, 5, 1, 3, 2]`
- `k = 3`

### Bước 1: Tính Tổng Của Cửa Sổ Đầu Tiên
- Tổng của `[2, 1, 5]` là `2 + 1 + 5 = 8`.

### Bước 2: Di Chuyển Cửa Sổ Sang Phải
- Di chuyển cửa sổ sang phải bằng cách bỏ phần tử bên trái (`2`) và thêm phần tử kế tiếp (`1`).
- Tổng mới: `8 - 2 + 1 = 7`.

### Bước 3: Tiếp Tục Di Chuyển Đến Cuối Mảng
- Lặp lại đến khi cửa sổ chạm cuối mảng và chọn tổng lớn nhất.

## Code Mẫu
Dưới đây là code mẫu cho phương pháp **Sliding Window** để tìm tổng lớn nhất của dãy con có độ dài `k`:

```java
public class SlidingWindow {

    // Phương thức tìm tổng lớn nhất của dãy con có độ dài k
    public static int maxSumSubarray(int[] arr, int k) {
        // Tính tổng của cửa sổ đầu tiên
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int currentSum = maxSum;

        // Trượt cửa sổ từ đầu đến cuối mảng
        for (int i = k; i < arr.length; i++) {
            // Cập nhật tổng của cửa sổ
            currentSum += arr[i] - arr[i - k];
            // Cập nhật maxSum nếu tìm thấy tổng lớn hơn
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Max sum: " + maxSumSubarray(arr, k));  // Output: 9
    }
}
```


## Ứng Dụng
- Tìm dãy con có **tổng lớn nhất** hoặc **tổng nhỏ nhất**.
- Tìm **chuỗi con thỏa mãn điều kiện** (độ dài, ký tự cụ thể).
- **Trung bình động** của dữ liệu thời gian (moving average).
- Các bài toán đếm dãy con thỏa mãn điều kiện (tổng, tích, hoặc dạng dãy con không có phần tử lặp lại).

## Độ Phức Tạp
- **Thời gian**: `O(n)`, nhờ vào việc tính toán lại chỉ một phần tử thay vì toàn bộ dãy con.
- **Bộ nhớ**: `O(1)`, vì chỉ cần giữ tổng hiện tại của cửa sổ.
