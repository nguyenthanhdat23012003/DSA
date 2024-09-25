# Các Thuật Toán Sắp Xếp Phổ Biến

Thuật toán sắp xếp là những kỹ thuật quan trọng trong khoa học máy tính, giúp tổ chức dữ liệu theo thứ tự nhằm phục vụ cho việc tìm kiếm và xử lý hiệu quả. Dưới đây là một số thuật toán sắp xếp phổ biến, cùng với phân tích về độ phức tạp thời gian và không gian của chúng.

## 1. Sắp Xếp Nổi Bọt (Bubble Sort)

### Mô tả
Sắp xếp nổi bọt là thuật toán so sánh đơn giản. Nó thực hiện việc duyệt qua danh sách nhiều lần, so sánh các phần tử kề nhau và hoán đổi chúng nếu chúng sai thứ tự. Quá trình này lặp lại cho đến khi danh sách được sắp xếp.

### Triển khai
```java
public class BubbleSort {
    public void bubbleSort(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1)
                }
            }
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

// Flag for best case
public class BubbleSort {
    public void bubbleSort(int[] nums) {
        int n = nums.length;
        boolean swapped;  
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        BubbleSort sorter = new BubbleSort();
        int[] nums = {5, 1, 4, 2, 8};
        sorter.bubbleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

```

### Độ phức tạp thời gian
- **Trường hợp tốt nhất**: O(n) (khi mảng đã được sắp xếp, cần thực hiện gắn cờ để kiểm tra)
- **Trường hợp trung bình**: O(n²)
- **Trường hợp xấu nhất**: O(n²)

### Độ phức tạp không gian
- O(1) (thuật toán sắp xếp tại chỗ - in-place)

### Đặc điểm
- Đơn giản và dễ cài đặt
- Không hiệu quả cho dữ liệu lớn
- Thuật toán sắp xếp tại chỗ (in-place algorithm)

---

## 2. Sắp Xếp Chọn (Selection Sort)

### Mô tả
Thuật toán sắp xếp chọn chia danh sách thành hai phần: đã sắp xếp và chưa sắp xếp. Nó chọn phần tử nhỏ nhất từ phần chưa sắp xếp và hoán đổi nó với phần tử đầu tiên của phần chưa sắp xếp. Quá trình này tiếp tục cho đến khi toàn bộ danh sách được sắp xếp.

### Triển khai
```java
public class SelectionSort {
    public void selectionSort(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n - 1; i++){
            int minIdx = i;
            for(int j = i + 1; j < n; j++){
                if(nums[j] < nums[minIdx]){
                    minIdx = j;
                } 
            }
            swap(nums, i, minIdx);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
### Độ phức tạp thời gian
- **Trường hợp tốt nhất**: O(n²)
- **Trường hợp trung bình**: O(n²)
- **Trường hợp xấu nhất**: O(n²)

### Độ phức tạp không gian
- O(1) (thuật toán sắp xếp tại chỗ)

### Đặc điểm
- Luôn thực hiện O(n²) phép so sánh, không phụ thuộc vào thứ tự ban đầu
- Phù hợp với dữ liệu nhỏ
- Thuật toán sắp xếp tại chỗ

---

## 3. Sắp Xếp Chèn (Insertion Sort)

### Mô tả
Sắp xếp chèn xây dựng mảng đã sắp xếp theo từng bước. Nó chọn phần tử tiếp theo từ mảng chưa sắp xếp và chèn nó vào đúng vị trí trong mảng đã sắp xếp.

### Triển khai
```java
public class InsertionSort {
    public void insertionSort(int[] nums) {
        int n = nums.length;
        
        for (int i = 1; i < n; i++) {
            int key = nums[i];  
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            
            nums[j + 1] = key;
        }
    }
}

```

### Độ phức tạp thời gian
- **Trường hợp tốt nhất**: O(n) (khi mảng đã được sắp xếp)
- **Trường hợp trung bình**: O(n²)
- **Trường hợp xấu nhất**: O(n²)

### Độ phức tạp không gian
- O(1) (thuật toán sắp xếp tại chỗ)

### Đặc điểm
- Hiệu quả cho dữ liệu nhỏ hoặc gần như đã sắp xếp
- Thuật toán sắp xếp tại chỗ
- Thuật toán ổn định

---

## 4. Sắp Xếp Trộn (Merge Sort)

### Mô tả
Sắp xếp trộn là thuật toán "chia để trị". Nó chia mảng thành hai phần, sắp xếp từng phần, và sau đó trộn lại thành mảng đã sắp xếp.

### Triển khai
```java
public class MergeSort{
    public void mergeSort(int[] nums){
        int n = nums.length;
        mergeSortRecursive(nums, 0, n - 1);
    }

    public void mergeSortRecursive(int[] nums, int start, int end){
        int mid = (start + end) / 2;
        if (start >= end) {
            return;
        }
        mergeSortRecursive(nums, start, mid);
        mergeSortRecursive(nums, mid + 1, end);
        mergeSortArray(nums, start, end);
    }

    public void mergeSortArray(int int[] nums, int start, int end){
        int mid = (start + end) / 2;
        int[] temp = new int[end - start + 1]
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;

        while(p1 <= mid && p2 <= end){
            if(nums[p1] <= nums[p2]) {
                temp[p++] = nums[p1++];
            } else {
                temp[p++] = nums[p2++];
            }
        }

        while (p1 <= mid) {
            temp[p++] = nums[p1++];
        }

        while (p2 <= end) {
            temp[p++] = nums[p2++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[start + i] = temp[i];
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

### Độ phức tạp thời gian
- **Trường hợp tốt nhất**: O(n log n)
- **Trường hợp trung bình**: O(n log n)
- **Trường hợp xấu nhất**: O(n log n)

### Độ phức tạp không gian
- O(n) (cần thêm bộ nhớ cho việc trộn)

### Đặc điểm
- Hiệu quả cho dữ liệu lớn
- Thuật toán ổn định
- Không phải là thuật toán sắp xếp tại chỗ

---

## 5. Sắp Xếp Nhanh (Quick Sort)

### Mô tả
Sắp xếp nhanh là một thuật toán "chia để trị" khác. Nó chọn một phần tử làm trục (pivot) và phân vùng mảng thành hai phần: một phần chứa các phần tử nhỏ hơn trục, phần còn lại chứa các phần tử lớn hơn. Sau đó, sắp xếp hai phần này.

### Triển khai
```java
public class QuickSort {
    public void quickSort(int[] nums) {
        int n = nums.length;
        quickSortRecursive(nums, 0, n - 1);
    }

    public void quickSortRecursive(int[] nums, int start, int end) {
        if(start >= end) return;
        int pivot = partition(nums, start, end);
        quickSortRecursive(nums, start, pivot - 1);
        quickSortRecursive(nums, pivot + 1, end);
    }

    public int partition(int[] nums,int start, int end) {
        int pivotValue = nums[end];
        int pivotIdx = start;
        for(int i = start; i < end; i++){
            if(nums[i] < pivotValue) {
                swap(nums, i ,pivotIdx);
                pivotIdx++;
            }
        }

        swap(nums, pivotIdx, end);
        return pivotIdx;
    }

    public void swap(int[] nums, int a, int b){
        if(a == b) return;
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
```

### Độ phức tạp thời gian
- **Trường hợp tốt nhất**: O(n log n)
- **Trường hợp trung bình**: O(n log n)
- **Trường hợp xấu nhất**: O(n²) (khi trục được chọn không tốt)

### Độ phức tạp không gian
- O(log n) (cho các lời gọi đệ quy)

### Đặc điểm
- Thuật toán sắp xếp tại chỗ
- Không ổn định
- Nhanh trong thực tế hơn các thuật toán O(n log n) khác như Merge Sort

---

## 6. Sắp Xếp Đếm (Counting Sort)

### Mô tả
Sắp xếp đếm là thuật toán dựa trên số nguyên, hoạt động bằng cách đếm số lượng phần tử có cùng giá trị và sử dụng thông tin này để sắp xếp các phần tử theo đúng thứ tự.

### Triển khai
```java
public class CountingSort {

    public void countingSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int[] count = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            output[count[nums[i]] - 1] = nums[i];
            count[nums[i]]--;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
    }
}
```

### Độ phức tạp thời gian
- **Trường hợp tốt nhất**: O(n + k), với k là giá trị lớn nhất trong mảng
- **Trường hợp trung bình**: O(n + k)
- **Trường hợp xấu nhất**: O(n + k)

### Độ phức tạp không gian
- O(n + k)

### Đặc điểm
- Phù hợp với các giá trị số nguyên có phạm vi giới hạn
- Không phải là thuật toán sắp xếp tại chỗ
- Thuật toán ổn định

---

## Kết luận

Thuật toán sắp xếp là nền tảng của việc tối ưu hóa hiệu quả xử lý dữ liệu. Mỗi thuật toán đều có ưu và nhược điểm tùy thuộc vào kích thước và đặc điểm của dữ liệu. Ví dụ, Quick Sort thường nhanh hơn trên thực tế nhưng có thể gặp trường hợp xấu nhất với độ phức tạp O(n²), trong khi Merge Sort đảm bảo O(n log n) nhưng yêu cầu thêm bộ nhớ.

Việc lựa chọn thuật toán sắp xếp phù hợp phụ thuộc vào yêu cầu cụ thể của bài toán như tính ổn định, độ phức tạp không gian, và đặc điểm của dữ liệu đầu vào.
