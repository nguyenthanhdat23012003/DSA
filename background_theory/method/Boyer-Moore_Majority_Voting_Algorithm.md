# Boyer-Moore Majority Voting Algorithm

## Giới thiệu
Thuật toán Boyer-Moore Majority Voting được thiết kế để tìm kiếm phần tử xuất hiện nhiều nhất (majority element) trong một mảng. Phần tử này được định nghĩa là phần tử xuất hiện nhiều hơn n/2 lần trong mảng, với n là độ dài của mảng. Thuật toán này có độ phức tạp thời gian O(n) và sử dụng O(1) không gian.

## Ý tưởng
Thuật toán hoạt động theo nguyên tắc bầu cử, trong đó nó duy trì một ứng viên cho phần tử majority và một biến đếm. Nếu ứng viên hiện tại không còn được ủng hộ bởi các phần tử khác, thuật toán sẽ thay đổi ứng viên. Quá trình này được lặp lại cho đến khi một ứng viên được xác nhận.

### Các bước thực hiện:
1. **Khởi tạo**:
   - Một biến `candidate` để lưu ứng viên hiện tại cho phần tử majority.
   - Một biến `count` để đếm số lần xuất hiện của ứng viên.

2. **Duyệt qua mảng**:
   - Nếu `count` bằng 0, đặt `candidate` bằng phần tử hiện tại và tăng `count`.
   - Nếu phần tử hiện tại bằng `candidate`, tăng `count`.
   - Nếu phần tử hiện tại khác `candidate`, giảm `count`.

3. **Xác nhận**:
   - Sau khi duyệt hết mảng, phần tử `candidate` có thể là phần tử majority, nhưng cần kiểm tra lại để xác nhận số lần xuất hiện của nó.

## Độ phức tạp
- **Thời gian**: O(n) - thuật toán chỉ cần duyệt qua mảng một lần.
- **Không gian**: O(1) - chỉ sử dụng một vài biến để lưu trữ thông tin.

## Ví dụ
```java
public class BoyerMoore {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;

        // Bước 1: Tìm ứng viên cho phần tử majority
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Bước 2: Xác nhận ứng viên
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        return count > nums.length / 2 ? candidate : -1; // -1 nếu không tìm thấy phần tử majority
    }
}
```
## Kết luận

Thuật toán Boyer-Moore Majority Voting là một công cụ hiệu quả và tối ưu để tìm kiếm phần tử xuất hiện nhiều nhất trong một mảng. Nó có thể được áp dụng trong nhiều tình huống khác nhau, đặc biệt khi làm việc với các tập dữ liệu lớn.