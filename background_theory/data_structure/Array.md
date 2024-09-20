# Tài liệu về Array trong Java

## Khái niệm

Array (mảng) là một cấu trúc dữ liệu cho phép lưu trữ một tập hợp các phần tử cùng kiểu dữ liệu. Mỗi phần tử trong mảng có thể được truy cập thông qua chỉ số (index), bắt đầu từ 0. Mảng thường được sử dụng để lưu trữ dữ liệu có kích thước cố định và có thể dễ dàng truy cập, thay đổi.

## Đặc điểm

### Ưu điểm

1. **Truy cập nhanh**: Các phần tử trong mảng có thể được truy cập nhanh chóng thông qua chỉ số. Thời gian truy cập là O(1).
2. **Lưu trữ liên tiếp**: Mảng lưu trữ các phần tử trong vùng nhớ liên tiếp, giúp cải thiện hiệu suất khi truy cập dữ liệu.
3. **Dễ dàng sử dụng**: Cú pháp để khai báo và sử dụng mảng trong Java rất đơn giản.

### Nhược điểm

1. **Kích thước cố định**: Kích thước của mảng phải được xác định khi khai báo, không thể thay đổi trong quá trình thực thi chương trình. Điều này có thể dẫn đến lãng phí bộ nhớ nếu mảng được khai báo lớn hơn nhu cầu thực tế.
2. **Chèn và xóa phức tạp**: Việc chèn hoặc xóa phần tử trong mảng có thể tốn nhiều thời gian, vì phải dịch chuyển các phần tử khác để tạo ra không gian cho phần tử mới hoặc để lấp đầy khoảng trống.

## Cách triển khai và sử dụng

Mảng (Java) có thể được khai báo và khởi tạo như sau:

```java
// Khai báo mảng
int[] numbers = new int[5];

// Khởi tạo mảng với giá trị
int[] numbers = {1, 2, 3, 4, 5};

// Truy cập phần tử
int firstElement = numbers[0]; // Truy cập phần tử đầu tiên

// Thay đổi giá trị phần tử
numbers[1] = 10; // Thay đổi giá trị phần tử thứ hai thành 10

// Duyệt mảng
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

Trong đoạn mã trên:

- Mảng `numbers` được khai báo với kích thước 5 và sau đó được khởi tạo với 5 giá trị.
- Các phần tử trong mảng được truy cập và thay đổi thông qua chỉ số.
- Một vòng lặp `for` được sử dụng để duyệt qua các phần tử trong mảng và in ra giá trị của chúng.

## Kết luận

Array là một trong những cấu trúc dữ liệu cơ bản và quan trọng trong lập trình, đặc biệt là trong Java. Mặc dù có những hạn chế về kích thước và khả năng chèn/xóa phần tử, nhưng sự tiện lợi trong việc truy cập và hiệu suất cao khiến mảng trở thành một lựa chọn phổ biến cho nhiều ứng dụng. Việc hiểu rõ về cách sử dụng và triển khai mảng sẽ giúp lập trình viên xây dựng các ứng dụng hiệu quả hơn.
