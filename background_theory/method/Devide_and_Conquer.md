# Divide and Conquer

## Giới thiệu

Divide and Conquer là một kỹ thuật giải quyết vấn đề bằng cách chia nhỏ một bài toán lớn thành nhiều bài toán con nhỏ hơn, giải quyết các bài toán con một cách độc lập, và sau đó kết hợp kết quả để tạo ra giải pháp cho bài toán lớn. Kỹ thuật này thường được áp dụng cho các bài toán có thể được chia thành các phần nhỏ hơn mà có thể giải quyết dễ dàng hơn.

## Đặc điểm của Divide and Conquer

1. **Chia (Divide)**: Chia bài toán lớn thành các bài toán con nhỏ hơn.
2. **Chinh phục (Conquer)**: Giải quyết các bài toán con một cách độc lập, thường bằng cách gọi đệ quy.
3. **Kết hợp (Combine)**: Kết hợp các kết quả của các bài toán con để tạo ra giải pháp cho bài toán lớn.

## Các bước cơ bản trong Divide and Conquer

1. **Xác định bài toán**: Xác định bài toán mà bạn cần giải quyết.
2. **Chia bài toán**: Phân chia bài toán thành các bài toán con nhỏ hơn.
3. **Giải quyết bài toán con**: Giải quyết các bài toán con một cách độc lập.
4. **Kết hợp kết quả**: Kết hợp kết quả của các bài toán con để tạo ra giải pháp cho bài toán lớn.

## Phân loại Divide and Conquer

1. **Phương pháp đệ quy**: Nhiều thuật toán Divide and Conquer được triển khai bằng cách sử dụng đệ quy, trong đó mỗi lần gọi đệ quy sẽ chia bài toán thành các phần nhỏ hơn.
   
2. **Phương pháp không đệ quy**: Một số thuật toán có thể được triển khai bằng cách sử dụng vòng lặp và ngăn xếp để tránh đệ quy.

## Ví dụ

### Sắp xếp Merge Sort

Merge Sort là một thuật toán sắp xếp điển hình minh họa kỹ thuật Divide and Conquer.

- Mô tả: Chia mảng thành hai nửa, sắp xếp từng nửa, sau đó kết hợp lại để tạo thành mảng đã sắp xếp.

```java
public class MergeSort {
    public void sort(int[] arr) {
        if (arr.length < 2) return; // Nếu mảng có 0 hoặc 1 phần tử
        int mid = arr.length / 2;
        
        // Chia mảng thành hai nửa
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        
        // Sắp xếp từng nửa
        sort(left);
        sort(right);
        
        // Kết hợp lại
        merge(arr, left, right);
    }
    
    private void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
```
Binary Search tìm kiếm một giá trị trong mảng đã sắp xếp
- Mô tả: Tìm kiếm một giá trị trong mảng đã sắp xếp bằng cách chia nó thành hai nửa, và kiểm tra xem giá trị cần tìm nằm ở nửa nào.
```java
public class BinarySearch {
    // Hàm tìm kiếm nhị phân
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Tính chỉ số giữa

            // Kiểm tra nếu phần tử ở giữa là giá trị cần tìm
            if (nums[mid] == target) {
                return mid; // Trả về chỉ số của phần tử
            }
            // Nếu giá trị ở giữa nhỏ hơn giá trị cần tìm, tìm trong nửa bên phải
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            // Nếu giá trị ở giữa lớn hơn giá trị cần tìm, tìm trong nửa bên trái
            else {
                right = mid - 1;
            }
        }

        return -1; // Nếu không tìm thấy, trả về -1
    }
}
```

## Ưu điểm và Nhược điểm

### Ưu điểm
- Thường mang lại giải pháp tối ưu cho các bài toán phức tạp.
- Dễ dàng triển khai với các bài toán có cấu trúc phân chia rõ ràng.

### Nhược điểm
- Độ phức tạp của giải pháp có thể cao nếu không được tối ưu hóa.
- Tốn kém bộ nhớ do sử dụng nhiều cuộc gọi đệ quy.

## Kết luận

Divide and Conquer là một kỹ thuật mạnh mẽ trong lập trình, giúp giải quyết nhiều bài toán phức tạp một cách hiệu quả. Việc hiểu rõ kỹ thuật này sẽ giúp bạn phát triển các thuật toán tối ưu hơn cho các bài toán thực tế trong lập trình.
