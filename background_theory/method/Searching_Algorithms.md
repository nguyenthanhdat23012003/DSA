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
Tìm kiếm nhảy xác định bước nhảy (thường là căn bậc hai của độ dài mảng) và kiểm tra phần tử ở các vị trí nhảy. Nếu phần tử mục tiêu nằm trong khoảng nhảy, thuật toán sử dụng tìm kiếm tuyến tính trong khoảng đó.

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
Tìm kiếm lũy thừa là một phương pháp tìm kiếm cho các mảng lớn, bắt đầu từ vị trí đầu tiên và nhân đôi khoảng tìm kiếm cho đến khi tìm thấy giá trị mục tiêu hoặc vượt quá giá trị đó.

**Cách triển khai**:  
Thuật toán tìm kiếm một cách lũy thừa cho đến khi giá trị mục tiêu được tìm thấy hoặc vị trí hiện tại vượt quá kích thước mảng, sau đó sử dụng tìm kiếm nhị phân trong khoảng tìm kiếm đã xác định.

**Độ phức tạp**:  
- **Thời gian**: O(log n).
- **Không gian**: O(1).

**Ứng dụng**:  
Tìm kiếm trong các mảng lớn đã sắp xếp.

**Ưu điểm**:  
- Hiệu quả cho các mảng lớn.

**Nhược điểm**:  
- Không hiệu quả với mảng nhỏ.

---

### 6. Thuật toán tìm kiếm tam phân (Ternary Search)

**Giới thiệu**:  
Tìm kiếm tam phân chia mảng thành ba phần thay vì hai, giúp thu hẹp nhanh chóng không gian tìm kiếm.

**Cách triển khai**:  
Tìm kiếm tam phân kiểm tra hai điểm chia trong mảng để xác định khoảng tìm kiếm cho giá trị mục tiêu và tiếp tục cho đến khi tìm thấy.

**Độ phức tạp**:  
- **Thời gian**: O(log3 n).
- **Không gian**: O(1).

**Ứng dụng**:  
Tìm kiếm trong các hàm đơn điệu để xác định giá trị cực đại hoặc cực tiểu.

**Ưu điểm**:  
- Có thể hiệu quả hơn trong một số tình huống so với tìm kiếm nhị phân.

**Nhược điểm**:  
- Thực hiện phức tạp hơn và không phải lúc nào cũng nhanh hơn tìm kiếm nhị phân.
