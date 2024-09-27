# Prefix Sum

## Định nghĩa
Prefix Sum (Tổng tiền tố) là một kỹ thuật được sử dụng để tính toán tổng của một đoạn con bất kỳ trong một mảng một cách nhanh chóng. Thay vì tính tổng lại mỗi khi có yêu cầu, Prefix Sum tính trước tổng của các phần tử từ đầu mảng đến mỗi vị trí, giúp giảm thời gian tính toán sau này.

## Cách hoạt động
Giả sử bạn có một mảng `arr[]` gồm `n` phần tử. Ta xây dựng một mảng `prefix[]` sao cho:

- `prefix[0] = arr[0]`
- `prefix[i] = prefix[i-1] + arr[i]` với `1 <= i < n`

Sau khi xây dựng xong mảng `prefix[]`, tổng của đoạn con từ chỉ số `l` đến `r` có thể được tính như sau:
- Nếu `l = 0`, tổng đoạn con là `prefix[r]`
- Nếu `l > 0`, tổng đoạn con là `prefix[r] - prefix[l-1]`

## Ứng dụng
- **Tính tổng đoạn con**: Thay vì duyệt lại mảng nhiều lần, với mảng Prefix Sum, việc tính tổng của đoạn con có thể thực hiện trong thời gian `O(1)` sau khi xây dựng mảng tiền tố.
- **Giải quyết các bài toán dãy con**: Prefix Sum thường được sử dụng trong các bài toán tìm dãy con có tổng thỏa mãn một điều kiện nhất định.

## Ví dụ
Giả sử bạn có mảng `arr = [3, 2, 1, 4, 5]` và cần tính tổng các phần tử từ vị trí 1 đến vị trí 3.

1. **Xây dựng mảng Prefix Sum**:
   - `prefix[0] = 3`
   - `prefix[1] = 3 + 2 = 5`
   - `prefix[2] = 5 + 1 = 6`
   - `prefix[3] = 6 + 4 = 10`
   - `prefix[4] = 10 + 5 = 15`

2. **Tính tổng đoạn con từ vị trí 1 đến 3**:
   - Tổng của đoạn con là `prefix[3] - prefix[0] = 10 - 3 = 7`.

## Mã ví dụ

Dưới đây là đoạn mã đơn giản để minh họa cách tạo mảng Prefix Sum và tính tổng đoạn con:

```java
int[] arr = {3, 2, 1, 4, 5};
int n = arr.length;
int[] prefix = new int[n];

// Xây dựng mảng prefix sum
prefix[0] = arr[0];
for (int i = 1; i < n; i++) {
    prefix[i] = prefix[i - 1] + arr[i];
}

// Tính tổng đoạn con từ l đến r
int l = 1;
int r = 3;
int sum;
if (l == 0) {
    sum = prefix[r];
} else {
    sum = prefix[r] - prefix[l - 1];
}

System.out.println("Tổng đoạn con từ " + l + " đến " + r + " là: " + sum);
```
