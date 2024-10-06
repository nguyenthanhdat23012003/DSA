# Brute Force Algorithm

## 1. Khái niệm

**Brute Force** (vét cạn) là một phương pháp tiếp cận đơn giản nhất để giải quyết bài toán bằng cách thử tất cả các khả năng có thể cho đến khi tìm được kết quả đúng. Trong một thuật toán Brute Force, tất cả các trường hợp, cấu hình hoặc phép tính có thể sẽ được duyệt qua mà không có bất kỳ tối ưu hóa nào. Mặc dù phương pháp này có thể đảm bảo tìm ra giải pháp, nhưng nó thường không hiệu quả và không tối ưu khi xử lý các bài toán có kích thước lớn.

## 2. Đặc điểm

### Ưu điểm:
- **Dễ hiểu**: Thuật toán brute force đơn giản để triển khai vì nó chỉ yêu cầu duyệt qua tất cả các trường hợp có thể.
- **Bảo đảm giải pháp**: Vì tất cả các khả năng đều được xét, thuật toán brute force luôn tìm ra giải pháp nếu có tồn tại.

### Nhược điểm:
- **Độ phức tạp thời gian cao**: Do phải kiểm tra tất cả các khả năng, thuật toán brute force thường có độ phức tạp thời gian rất lớn, có thể là O(n^2), O(2^n), hoặc thậm chí tệ hơn.
- **Không tối ưu**: Brute force không có cơ chế để tối ưu hóa quá trình tìm kiếm hoặc loại bỏ các trường hợp không cần thiết.

## 3. Cách tiếp cận

Cách tiếp cận brute force thường được chia thành các bước như sau:
1. **Liệt kê tất cả các trường hợp**: Tạo ra tất cả các trường hợp có thể xảy ra trong không gian tìm kiếm của bài toán.
2. **Kiểm tra điều kiện**: Với mỗi trường hợp, kiểm tra xem nó có thỏa mãn điều kiện của bài toán không.
3. **Kết luận kết quả**: Nếu tìm được trường hợp thỏa mãn điều kiện, đưa ra kết quả hoặc tiếp tục cho đến khi duyệt hết tất cả các trường hợp.

### Ví dụ: Tìm cặp số trong mảng có tổng bằng một giá trị cho trước

Giả sử  có một mảng số nguyên và một số nguyên mục tiêu, cần tìm hai số trong mảng có tổng bằng mục tiêu đó.

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution"); 
    }
}

```

## 4. Ứng dụng của Brute Force

Mặc dù brute force không phải là phương pháp tối ưu cho các bài toán lớn, nhưng nó vẫn có thể được sử dụng trong một số trường hợp:
- **Bài toán nhỏ**: Khi không gian tìm kiếm của bài toán nhỏ, brute force có thể được sử dụng để tìm ra giải pháp một cách nhanh chóng.
- **Giải pháp ban đầu**: Trong nhiều bài toán, brute force có thể được sử dụng để tìm ra giải pháp ban đầu trước khi tối ưu hóa với các thuật toán khác.
- **Các bài toán không có cấu trúc rõ ràng**: Trong những bài toán mà không gian tìm kiếm không thể dễ dàng chia nhỏ hoặc không có chiến lược tìm kiếm tốt hơn, brute force có thể là phương pháp khả thi duy nhất.

## 5. Độ phức tạp của Brute Force

Brute force thường có độ phức tạp thời gian rất lớn, tùy thuộc vào không gian tìm kiếm của bài toán:
- **Bài toán tìm kiếm**: Nếu cần duyệt qua mọi phần tử trong một danh sách có n phần tử, độ phức tạp sẽ là O(n).
- **Bài toán tổ hợp**: Nếu cần thử mọi tổ hợp của n phần tử, độ phức tạp sẽ là O(2^n) hoặc O(n!), phụ thuộc vào số lượng tổ hợp cần xét.
- **Bài toán hình học**: Trong các bài toán như kiểm tra giao điểm của các hình, độ phức tạp thường là O(n^2), vì phải kiểm tra tất cả các cặp hình với nhau.

## 6. Khi nào nên tránh sử dụng Brute Force

Brute force nên được tránh khi:
- **Không gian tìm kiếm quá lớn**: Khi không gian tìm kiếm của bài toán lớn, brute force sẽ tốn quá nhiều thời gian và tài nguyên để tìm giải pháp.
- **Có giải pháp tối ưu hơn**: Nếu bài toán có thể được giải quyết bằng một thuật toán hiệu quả hơn (ví dụ: chia để trị, tham lam, lập trình động), thì nên sử dụng những phương pháp đó thay vì brute force.

## 7. Tổng kết

Brute force là phương pháp đơn giản và dễ hiểu để giải quyết bài toán, nhưng thường không tối ưu về thời gian và tài nguyên. Mặc dù có thể dùng brute force cho các bài toán nhỏ hoặc không có cấu trúc, nhưng việc tìm ra các thuật toán tối ưu hơn thường là lựa chọn tốt hơn cho các bài toán có quy mô lớn.
