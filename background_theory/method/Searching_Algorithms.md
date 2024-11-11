# Searching Algorithms

## Định nghĩa và ứng dụng

Thuật toán tìm kiếm là các quy trình hoặc tập hợp quy tắc có hệ thống để tìm kiếm thông tin trong một tập dữ liệu lớn, như cơ sở dữ liệu hoặc trang web. Chúng được thiết kế để tìm kiếm mục tiêu một cách hiệu quả nhất với số lần so sánh hoặc lặp lại ít nhất có thể.

Các thuật toán này đóng vai trò quan trọng trong các tương tác số hàng ngày. Chẳng hạn, Google dùng chúng để tìm kiếm thông tin trên Internet, Amazon và các nền tảng thương mại điện tử khác dùng để tìm sản phẩm, trong khi các trang mạng xã hội hay dịch vụ streaming như Facebook và Netflix sử dụng chúng để cung cấp nội dung phù hợp với người dùng.

## Các thuật toán tìm kiếm phổ biến

### 1. Thuật toán tìm kiếm tuyến tính (Linear Search)

**Giới thiệu**:  
Tìm kiếm tuyến tính là thuật toán đơn giản nhất, nơi ta kiểm tra từng phần tử trong mảng cho đến khi tìm thấy phần tử mục tiêu hoặc hết mảng. 

**Cách triển khai**:  
Thuật toán bắt đầu từ phần tử đầu tiên trong mảng, so sánh từng phần tử với giá trị mục tiêu. Nếu một phần tử khớp, thuật toán trả về chỉ số của nó. Nếu không tìm thấy, thuật toán trả về giá trị báo không tìm thấy.

**Triển khai**:

```java
public class Solution {
    public int linearSearch(int[] arr, int target) {
        // Duyệt qua từng phần tử trong mảng
        for (int i = 0; i < arr.length; i++) {
            // Kiểm tra xem phần tử hiện tại có phải là mục tiêu không
            if (arr[i] == target) {
                return i;  // Trả về chỉ số của phần tử
            }
        }
        
        return -1;  // Trả về -1 nếu không tìm thấy phần tử
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 2, 3, 7, 5, 9};
        int target = 7;
        int result = solution.linearSearch(arr, target);

        if (result != -1) {
            System.out.println("Phần tử " + target + " được tìm thấy tại chỉ số " + result + ".");
        } else {
            System.out.println("Phần tử " + target + " không tồn tại trong mảng.");
        }
    }
}

```

**Độ phức tạp**:  
- **Thời gian**: O(n) trong trường hợp xấu nhất (khi phần tử mục tiêu ở cuối mảng hoặc không tồn tại).
- **Không gian**: O(1) (sử dụng không gian cố định).

**Ứng dụng**:  
Thích hợp cho các tập dữ liệu nhỏ hoặc không được sắp xếp.

**Ưu điểm**:  
- Dễ hiểu và triển khai.
- Không yêu cầu dữ liệu phải được sắp xếp.

**Nhược điểm**:  
- Không hiệu quả với các tập dữ liệu lớn.

---

### 2. Thuật toán tìm kiếm nhị phân (Binary Search)

**Giới thiệu**:  
Tìm kiếm nhị phân là một thuật toán tìm kiếm hiệu quả hơn cho các mảng đã được sắp xếp. Nó giảm nửa khoảng tìm kiếm mỗi lần.

**Cách triển khai**:  
Thuật toán bắt đầu với phần tử ở giữa mảng và so sánh giá trị đó với giá trị mục tiêu. Nếu giá trị mục tiêu nhỏ hơn phần tử giữa, thuật toán tìm kiếm trong nửa bên trái; nếu lớn hơn, tìm kiếm trong nửa bên phải.

**Triển khai**:
- Triển khai Tìm kiếm Nhị phân bằng Đệ quy
```java
public class Solution {
    public int binarySearchRecursive(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;  
        }

        int mid = left + (right - left) / 2;
        if(nums[mid] == target) return mid;
        if(nums[mid] > target){
            return binarySearchRecursive(nums, target, left, mid - 1);
        } else {
            return binarySearchRecursive(nums, target, mid + 1, right);
        }
    }

    public int binarySearch(int[] nums, int target){
        int n = nums.length;
        return binarySearchRecursive(nums, target, 0, n - 1);
    }
}

```
- Triển khai Tìm kiếm Nhị phân bằng Vòng lặp
```java
public class Solution {
    public int binarySearchIterative(int[] nums, int target){
        int n = nums.length;
        int left = 0; 
        int right = n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            // int mid = (left + right) / 2; (dùng thế này cũng được nhưng có thể gây tràn bộ nhớ)
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) left = mid - 1;
            else right = mid + 1;
        }

        return -1;
    }
}
```

**Độ phức tạp**:  
- **Thời gian**: O(log n).
- **Không gian**: O(1) cho tìm kiếm không đệ quy, O(log n) cho tìm kiếm đệ quy.

**Ứng dụng**:  
Tìm kiếm trong cơ sở dữ liệu, tìm kiếm trong các mảng đã sắp xếp.

**Ưu điểm**:  
- Hiệu quả cho các tập dữ liệu lớn.
- Thời gian tìm kiếm ngắn.

**Nhược điểm**:  
- Cần mảng đã được sắp xếp trước.

---

### 3. Thuật toán tìm kiếm nội suy (Interpolation Search)

**Giới thiệu**:  
Tìm kiếm nội suy là một phiên bản nâng cao của tìm kiếm nhị phân, phù hợp cho các mảng đã sắp xếp với các giá trị phân bố đều. Thay vì luôn lấy phần tử ở giữa, thuật toán tìm kiếm nội suy xác định vị trí ước tính dựa trên giá trị của mục tiêu so với các giá trị ở biên của mảng.

**Cách triển khai**:  
Thuật toán sử dụng công thức nội suy để tính vị trí ước tính `mid` của phần tử mục tiêu `target` như sau:

$$
\text{mid} = \text{left} + \frac{(\text{target} - \text{arr[left]}) \times (\text{right} - \text{left})}{\text{arr[right]} - \text{arr[left]}}
$$


1. **Giải thích công thức**:
   - `target - arr[left]` tính khoảng cách của `target` so với phần tử ở biên trái `left`.
   - `(right - left) / (arr[right] - arr[left])` đại diện cho tỷ lệ giữa độ dài của chỉ số mảng và giá trị phần tử ở biên.
   - Nhân với khoảng cách này và cộng `left` sẽ cho vị trí `mid` ước tính gần nhất với `target`.

2. **Phiên bản biến tấu tính `mid` theo `right`**:  
   Công thức trên thường tính toán từ `left`, nhưng cũng có thể tính `mid` dựa trên `right` như sau:

$$
\text{mid} = \text{right} - \frac{(\text{arr[right]} - \text{target}) \times (\text{right} - \text{left})}{\text{arr[right]} - \text{arr[left]}}
$$

   - Công thức này sử dụng khoảng cách từ `target` đến `right` để ước lượng `mid` và thu hẹp khoảng tìm kiếm từ biên phải.

**Ví dụ minh họa**:  
Giả sử chúng ta có mảng `arr = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]` và muốn tìm `target = 70`.

1. **Tính toán bước đầu tiên**:
- `left = 0`, `right = 9`, `arr[left] = 10`, và `arr[right] = 100`.
- Thay vào công thức:

$$
\text{mid} = 0 + \frac{(70 - 10) \times (9 - 0)}{100 - 10} = 0 + \frac{60 \times 9}{90} = 0 + 6 = 6
$$
- Chỉ số `mid = 6`, và `arr[6] = 70`, trùng với `target`. Thuật toán trả về `mid = 6` là vị trí của `target`.

2. **Giải thích**:  
- Vì các giá trị trong mảng được phân bố đều, công thức ước tính đã đưa ra `mid = 6` một cách chính xác, giúp tiết kiệm số lần lặp và truy vấn so với tìm kiếm nhị phân, vốn sẽ kiểm tra lần lượt từ `4` rồi `6`.

**Triển khai**:

```java

public class Solution {
    // Phương thức tìm kiếm nội suy sử dụng vòng lặp
    public int interpolationSearchIterative(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        
        while (left <= right && target >= nums[left] && target <= nums[right]) {
            // Tính toán chỉ số giữa
            int mid = left + (right - left) * (target - nums[left]) / (nums[right] - nums[left]);
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1; 
        }
        
        return -1; 
    }
    
    // Phương thức tìm kiếm nội suy sử dụng đệ quy
    public int interpolationSearch(int[] nums, int target) {
        int n = nums.length;
        return interpolationSearchRecursive(nums, target, 0, n - 1);
    }
    
    public int interpolationSearchRecursive(int[] nums, int target, int left, int right) {
        if (left <= right && target >= nums[left] && target <= nums[right]) {
            // Tính toán chỉ số giữa
            int mid = left + (right - left) * (target - nums[left]) / (nums[right] - nums[left]);
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) return interpolationSearchRecursive(nums, target, mid + 1, right);
            else return interpolationSearchRecursive(nums, target, left, mid - 1);
        }
        
        return -1; 
    }
}

```

**Độ phức tạp**:  
- **Thời gian**: O(log log n) trong trường hợp tốt nhất với các mảng có phân bố đồng đều, O(n) trong trường hợp xấu nhất.
- **Không gian**: O(1), vì không yêu cầu bộ nhớ bổ sung ngoài các biến chỉ số.

**Ứng dụng**:  
- Thích hợp cho tìm kiếm trong các cơ sở dữ liệu lớn với các trường có phân bố giá trị đồng đều, hoặc trong các bảng biểu tượng (symbol tables).

**Ưu điểm**:  
- Nhanh hơn tìm kiếm nhị phân khi các giá trị phân bố đều, vì nó ước lượng chính xác vị trí của `target`.

**Nhược điểm**:  
- Hiệu quả giảm nếu giá trị trong mảng không phân bố đồng đều, làm cho tính toán vị trí `mid` kém chính xác.


---

### 4. Thuật toán tìm kiếm nhảy (Jump Search)

**Giới thiệu**:  
Tìm kiếm nhảy là một thuật toán hiệu quả cho các mảng đã được sắp xếp, cho phép nhảy qua các phần tử với các bước cố định.

**Cách triển khai**:  
Tìm kiếm nhảy xác định bước nhảy (thường là căn bậc hai của độ dài mảng) và kiểm tra phần tử ở các vị trí nhảy. Nếu phần tử mục tiêu nằm trong khoảng nhảy, thuật toán sử dụng tìm kiếm tuyến tính trong khoảng đó. Ví dụ, nếu mảng có 100 phần tử, bước nhảy sẽ là 10. Thuật toán kiểm tra phần tử ở các vị trí nhảy (0, 10, 20, ...) cho đến khi tìm thấy một phần tử lớn hơn hoặc bằng phần tử mục tiêu. Sau đó, nó sẽ sử dụng tìm kiếm tuyến tính trong khoảng giữa vị trí nhảy gần nhất và vị trí trước đó để tìm kiếm phần tử mục tiêu.

**Ví dụ minh họa**:

Giả sử chúng ta có mảng đã sắp xếp sau:
```arr = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]```
Và chúng ta muốn tìm phần tử mục tiêu là ```11```. Bước nhảy sẽ được tính là ```√n = √10 ≈ 3```. Thuật toán sẽ kiểm tra các chỉ số 0, 3, 6 và thấy rằng ```arr[6] = 13```, lớn hơn ```11```, nên thuật toán sẽ thực hiện tìm kiếm tuyến tính từ chỉ số 3 đến 6. Sau đó, nó tìm thấy ```11``` tại vị trí 5.

**Triển khai**:  

```java
public class Solution {
    public int jumpSearch(int[] nums, int target){
    	int n = nums.length;
    	int step = Math.sqrt(n);
    	int nearlyIdx = 0;
    	
    	while(nearlyIdx < n && target >= nums[nearlyIdx]){
    	    nearlyIdx += step;
    	}
    	
    	int startIdx = Math.max(0, nearlyIdx - step);
    	int endIdx = Math.min(nearlyIdx, n);
        for (int i = startIdx; i < endIdx; i++) {
            if (nums[i] == target) return i;
        }
    	
    	return -1;
    }
}
```

**Độ phức tạp**:  
- **Thời gian**: O(√n).
- **Không gian**: O(1).

**Ứng dụng**:  
Tìm kiếm trong các hệ thống cơ sở dữ liệu lớn, tối ưu hiệu suất trong các ứng dụng JavaScript.

**Ưu điểm**:  
- Nhanh hơn tìm kiếm tuyến tính.

**Nhược điểm**:  
- Cần mảng đã được sắp xếp và bước nhảy tối ưu.

---

### 5. Thuật toán tìm kiếm lũy thừa (Exponential Search)

**Giới thiệu**:  
Tìm kiếm lũy thừa (Exponential Search) là một thuật toán tìm kiếm hiệu quả trên các mảng đã sắp xếp. Thuật toán này đặc biệt hữu ích khi làm việc với các mảng lớn, vì nó nhanh chóng mở rộng phạm vi tìm kiếm cho đến khi giá trị mục tiêu nằm trong một khoảng xác định, sau đó sử dụng tìm kiếm nhị phân trong khoảng này để tìm ra kết quả.

**Cách triển khai**:  
1. **Nhảy theo cấp số nhân (Exponential Jump)**: Bắt đầu từ vị trí đầu tiên và tăng chỉ số tìm kiếm theo lũy thừa của 2 (0, 1, 2, 4, 8, …) cho đến khi tìm thấy giá trị lớn hơn hoặc bằng mục tiêu hoặc khi vượt qua kích thước của mảng.

2. **Tìm kiếm nhị phân trong khoảng đã xác định**: Sau khi xác định khoảng từ bước nhảy mũ, thuật toán sẽ tiến hành tìm kiếm nhị phân trong khoảng đó để tìm vị trí chính xác của giá trị mục tiêu.

**Ví dụ**:

Giả sử  có một mảng đã sắp xếp như sau: ```[2, 3, 5, 7, 9, 14, 17, 23, 28, 35, 42, 47, 53, 59, 67, 72, 81, 89, 95]```

Và muốn tìm giá trị 53.

1. **Bước nhảy theo lũy thừa**: 
- Bắt đầu từ vị trí `0 (2)`, tăng chỉ số theo lũy thừa của 2 cho đến khi giá trị hiện tại vượt quá giá trị cần tìm.
- Các bước kiểm tra: `2, 3, 5, 9, 28, 81` (chỉ số `0, 1, 2, 4, 8, 16`).
- Đến chỉ số 16, bạn có giá trị `81`, lớn hơn `53`, nên bạn dừng lại và biết rằng `53` nằm trong khoảng từ chỉ số `8` đến `16`.

2. **Tìm kiếm nhị phân**: 
- Thực hiện tìm kiếm nhị phân trong khoảng `[8, 16]`.
- Xác định vị trí giữa là `12` với giá trị `53`, trùng với giá trị cần tìm.

**Triển khai**:  

```java
public class Solution {
    public int exponentialSearch(int[] nums, int target){
    	int n = nums.length;
    	if (n == 0) return -1;
    	if(nums[0] == target) return 0;
    	int step = 1;
    	while(step < n && nums[step] <= target) {
    	    step*=2;
    	}
    	
    	int left = step / 2;
        int right = Math.min(step, n - 1);
        return binarySearch(nums, target, left, right);
    }
    
    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
```

**Độ phức tạp**:  
- **Thời gian**: O(log i) cho phần nhảy theo lũy thừa, với i là chỉ số cuối cùng trước khi vượt quá giá trị mục tiêu, cộng với O(log i) cho tìm kiếm nhị phân. Tổng thời gian là O(log n).
- **Không gian**: O(1).

**Ứng dụng**:  
Thường được sử dụng trong các hệ thống hoặc cơ sở dữ liệu lớn, đặc biệt khi cần hiệu quả cao trên các tập dữ liệu đã sắp xếp.

**Ưu điểm**:  
- Hiệu quả cho các mảng lớn, kết hợp nhảy nhanh và tìm kiếm nhị phân tối ưu.

**Nhược điểm**:  
- Không phù hợp cho các mảng nhỏ, vì tìm kiếm nhị phân đơn giản có thể nhanh hơn.

---

### 6. Thuật toán tìm kiếm tam phân (Ternary Search)

**Giới thiệu**:  
Thuật toán tìm kiếm tam phân (Ternary Search) là một phương pháp tìm kiếm trong mảng đã được sắp xếp. Tương tự như tìm kiếm nhị phân, thuật toán này cũng chia nhỏ không gian tìm kiếm để giảm số lượng phần tử cần kiểm tra. Tuy nhiên, thay vì chia không gian thành hai phần như tìm kiếm nhị phân, tìm kiếm tam phân chia không gian thành ba phần bằng cách xác định hai vị trí chia nhỏ trong mỗi bước lặp.

**Cách triển khai**:  
Tìm kiếm tam phân kiểm tra hai điểm chia trong mảng để xác định khoảng tìm kiếm cho giá trị mục tiêu:
1. Xác định hai chỉ số `mid1` và `mid2`, lần lượt là điểm một phần ba và hai phần ba của khoảng `[left, right]`.
2. So sánh `target` với các giá trị tại `mid1` và `mid2`:
   - Nếu `target` bằng giá trị tại `mid1`, trả về `mid1`.
   - Nếu `target` bằng giá trị tại `mid2`, trả về `mid2`.
   - Nếu `target` nhỏ hơn giá trị tại `mid1`, tìm trong khoảng `[left, mid1 - 1]`.
   - Nếu `target` lớn hơn giá trị tại `mid2`, tìm trong khoảng `[mid2 + 1, right]`.
   - Nếu `target` nằm giữa `mid1` và `mid2`, tìm trong khoảng `[mid1 + 1, mid2 - 1]`.
3. Lặp lại quá trình cho đến khi tìm thấy `target` hoặc không còn phần tử nào để kiểm tra.

**Ví dụ**:  
Giả sử có mảng đã sắp xếp `nums = [2, 4, 7, 10, 15, 19, 23, 27, 31, 35]` và cần tìm giá trị `15`.

- Bước 1: `left = 0`, `right = 9`. Tính `mid1 = 3`, `mid2 = 6`. Kiểm tra:
  - `nums[mid1] = 10`, `nums[mid2] = 23`.
  - `target = 15` nằm giữa `mid1` và `mid2`, nên chỉ tìm trong khoảng `[4, 5]`.
- Bước 2: Cập nhật `left = 4`, `right = 5`. Tính `mid1 = 4`, `mid2 = 5`.
  - `nums[mid1] = 15`, `target = 15`.
- Kết quả: Trả về `mid1 = 4`, vì đã tìm thấy `target`.

**Triển khai**:

```java
public class Solution {
    // Triển khai đệ quy
    public int ternarySearch(int[] nums, int target) {
        return ternarySearchRecursive(nums, target, 0, nums.length - 1);
    }
    
    private int ternarySearchRecursive(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (nums[mid1] == target) return mid1;
            if (nums[mid2] == target) return mid2;

            if (target < nums[mid1]) {
                return ternarySearchRecursive(nums, target, left, mid1 - 1);
            } else if (target > nums[mid2]) {
                return ternarySearchRecursive(nums, target, mid2 + 1, right);
            } else {
                return ternarySearchRecursive(nums, target, mid1 + 1, mid2 - 1);
            }
        }
        return -1;
    }

    // Triển khai lặp
    public int ternarySearchIterative(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (nums[mid1] == target) return mid1;
            if (nums[mid2] == target) return mid2;

            if (target < nums[mid1]) {
                right = mid1 - 1;
            } else if (target > nums[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1;
    }
}
```

**Độ phức tạp**:  
- **Thời gian**: O(log₃ n) – nhanh hơn một chút so với tìm kiếm nhị phân với O(log₂ n) trong các trường hợp lý tưởng, vì số phần tử giảm theo log₃ mỗi lần lặp.
- **Không gian**: O(1) trong triển khai lặp hoặc O(log₃ n) nếu triển khai đệ quy (do sử dụng thêm bộ nhớ ngăn xếp cho các lệnh gọi hàm).

**Ứng dụng**:  
Tìm kiếm tam phân không phổ biến bằng tìm kiếm nhị phân, do các yêu cầu chặt chẽ về phân phối của mảng và độ phức tạp của việc chia thành ba phần, nhưng đôi khi có thể hiệu quả hơn trong các hệ thống đặc thù hoặc với dữ liệu có phân bố đồng đều.

**Ưu điểm**:  
- Có thể nhanh hơn tìm kiếm nhị phân trong một số trường hợp nhất định khi xử lý mảng lớn và phân bố đều.

**Nhược điểm**:  
- Không hiệu quả cho mảng nhỏ hoặc khi triển khai vì mất thêm chi phí chia thành ba phần, đồng thời ít phổ biến hơn so với tìm kiếm nhị phân.

## So sánh Binary Search và Ternary Search
- Nhiều thắc mắc được đưa ra rằng tại sao Tenary Search với độ phức tạp là $O(log_3 (n))$ lại không được ưa chuộng so với Binary Search với độ phức tạp lớn hơn là $O(log_2 (n))$ , hãy cùng xem xét độ phức tạp thực tế của chúng
### Độ phức tạp thuật toán của Binary Search
```java
    public int binarySearchIterative(int[] nums, int target){
        int n = nums.length;
        int left = 0; 
        int right = n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) left = mid - 1;
            else right = mid + 1;
        }

        return -1;
    }
```
- Ở mỗi bước, binary search tiến hành chia đôi mảng, giả sử độ dài mảng là n, thì trong trường hợp xấu nhất (phần tử ở đầu hoặc cuối mảng) thì số lần chia đôi mảng sẽ là k thỏa mãn 
$$
\dfrac{n}{2^k} = 1
$$
- Giải phương trình trên ta có 
$$
2^k = n \rightarrow k = log_2 (n)
$$
- Như vậy, số lần lặp để chia đôi mảng sẽ là $log_2 (n)$ tương đương với độ phức tạp thuật toán sẽ là $O(log_2 (n))$
- Tuy nhiên, hãy để ý vào mỗi lần lặp, Binary Search sẽ cần thực hiện một phép tính (tính **mid**) và hai phép so sánh (so sánh bằng và so sánh lớn hơn hoặc nhỏ hơn), như vậy, **số toán tử thực tế** mà Binary Search sẽ cần tính toán sẽ được tính bằng công thức sau đây:
$$
T_b (n) = 3 \times log_2 (n)
$$
    
### Độ phức tạp thuật toán của Ternary Search
```java
    public int ternarySearchIterative(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (nums[mid1] == target) return mid1;
            if (nums[mid2] == target) return mid2;

            if (target < nums[mid1]) {
                right = mid1 - 1;
            } else if (target > nums[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1;
    }
```
- Ở mỗi bước, ternary search tiến hành chia mảng thành ba phần, giả sử độ dài mảng là n, thì trong trường hợp xấu nhất (phần tử ở đầu hoặc cuối mảng) thì số lần chia mảng thành ba phần sẽ là k thỏa mãn 
$$
\dfrac{n}{3^k} = 1
$$
- Giải phương trình trên ta có 
$$
3^k = n \rightarrow k = log_3 (n)
$$
- Như vậy, số lần lặp để chia mảng thành ba phần sẽ là $log_3 (n)$ tương đương với độ phức tạp thuật toán sẽ là $O(log_3 (n))$
- Tuy nhiên, cũng như Binary Seach, Ternary Search sẽ cần thực hiện nhiều hơn một toán tử, ở đây cụ thể là 2 phép tính (tính  **mid1** và **mid2**) và 4 phép so sánh (so sánh bằng và so sánh lớn hơn hoặc nhỏ hơn với từng **mid1** và **nid2**), như vậy, **số toán tử thực tế** mà Binary Search sẽ cần tính toán sẽ được tính bằng công thức sau đây:
$$
T_t (n) = 6 \times log_3 (n)
$$

### So sánh và kết luận
- So sánh số toán tử thực tế mà Binary Search và Ternary Search cần để hoàn thành thuật toán trong trường hợp xấu nhất, ta thấy như sau: 
 
$$
\dfrac{T_t (n)}{T_b (n)} = \dfrac{6 \times log_3 (n)}{3 \times log_2 (n)} = \dfrac{2 \times log_3 (n)}{log_2 (n)} 
$$
$$
= \dfrac{2 \times log_3 (n)}{log_2 (3) \times log_3 (n)} = \dfrac{2}{log_2 (3)} \approx 1.26 > 1
$$

- Như vậy có thể kết luận rằng Ternary Search sẽ thực hiện nhiều toán tử hơn so với Binary mặc dù có độ phức tạp thuật toán nhỏ hơn, vì vậy trong thực tế, thời gian thực thi Binary Search sẽ tốt hơn so với Ternary Search và Binary Search sẽ được sử dụng nhiều hơn