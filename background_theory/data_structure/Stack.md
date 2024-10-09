# Tài liệu về Stack trong Java

## Khái niệm

Stack (ngăn xếp) là một cấu trúc dữ liệu tuyến tính theo nguyên tắc LIFO (Last In, First Out), nghĩa là phần tử được thêm vào sau cùng sẽ được truy xuất trước. Ngăn xếp thường được sử dụng để quản lý các tác vụ cần phải hoàn thành theo thứ tự ngược lại, như quay lại trang web, xử lý các phép toán và kiểm tra biểu thức.

## Đặc điểm

### Ưu điểm

1. **Quản lý đơn giản**: Cú pháp sử dụng Stack rất đơn giản, với các thao tác cơ bản như push (thêm), pop (xóa), và peek (truy cập phần tử trên cùng).
2. **Tính bảo mật**: Stack giúp bảo vệ dữ liệu và tránh truy cập không hợp lệ vào các phần tử, vì chỉ có phần tử trên cùng mới có thể được truy xuất.
3. **Sử dụng hiệu quả bộ nhớ**: Stack có thể được triển khai bằng mảng hoặc danh sách liên kết, tùy thuộc vào nhu cầu của ứng dụng.

### Nhược điểm

1. **Kích thước cố định (nếu dùng mảng)**: Nếu sử dụng mảng để triển khai Stack, kích thước của Stack sẽ bị giới hạn bởi kích thước của mảng.
2. **Tốc độ truy cập chậm**: Việc truy cập các phần tử không phải là phần tử trên cùng sẽ tốn thời gian, vì phải pop các phần tử trên cùng trước khi truy cập.
3. **Rủi ro tràn Stack**: Nếu Stack được sử dụng không hợp lý, có thể dẫn đến tình trạng tràn Stack (stack overflow), gây lỗi trong chương trình.

## Cách triển khai và sử dụng

Stack (trong Java) có thể được khai báo và sử dụng như sau:
```java
// Khai báo Stack
Stack<Integer> stack = new Stack<>();

// Thêm phần tử vào Stack
stack.push(1);
stack.push(2);
stack.push(3);

// Truy cập phần tử trên cùng
int topElement = stack.peek(); // Truy cập phần tử trên cùng

// Xóa phần tử trên cùng
int poppedElement = stack.pop(); // Xóa phần tử trên cùng

// Duyệt Stack
for (Integer number : stack) {
    System.out.println(number);
}
```
Trong đoạn mã trên:

- Stack được khai báo để lưu trữ các số nguyên.
- Các phần tử được thêm vào và truy cập thông qua các phương thức có sẵn.
- Một vòng lặp `for-each` có thể được sử dụng để duyệt qua các phần tử trong Stack, nhưng lưu ý rằng các phần tử sẽ được duyệt theo thứ tự từ phần tử dưới cùng đến phần tử trên cùng.

## Ứng dụng

Stack có nhiều ứng dụng trong lập trình, bao gồm:

1. **Quản lý lịch sử duyệt web**: Ngăn xếp được sử dụng để lưu trữ lịch sử các trang web đã truy cập, cho phép người dùng quay lại trang trước đó.
2. **Xử lý biểu thức**: Stack thường được sử dụng trong việc phân tích và đánh giá các biểu thức toán học, bao gồm các phép toán trong biểu thức.
3. **Quản lý ngăn xếp gọi hàm**: Trong quá trình thực thi chương trình, Stack được sử dụng để lưu trữ địa chỉ trả về và các biến cục bộ của các hàm đã được gọi.
4. **Thực hiện các thao tác quay ngược**: Ngăn xếp có thể được sử dụng để thực hiện các thao tác quay ngược, chẳng hạn như hoàn tác (undo) trong ứng dụng.

## Kết luận

Stack là một cấu trúc dữ liệu quan trọng và hữu ích trong lập trình, đặc biệt trong các tình huống cần quản lý dữ liệu theo thứ tự LIFO. Mặc dù có những hạn chế về kích thước và tốc độ truy cập, nhưng sự đơn giản và hiệu quả của Stack làm cho nó trở thành một công cụ mạnh mẽ cho nhiều ứng dụng. Việc hiểu rõ về cách sử dụng và triển khai Stack sẽ giúp lập trình viên xây dựng các ứng dụng hiệu quả hơn.
