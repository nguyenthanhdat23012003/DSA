#### In-place algorithm 
- Là một thuật toán mà khi thực hiện, nó không cần hoặc chỉ sử dụng một lượng bộ nhớ bổ sung nhỏ so với kích thước đầu vào. 
- Nói cách khác, thuật toán thực hiện việc biến đổi dữ liệu đầu vào ngay trên bộ nhớ của chính nó mà không cần phải sử dụng thêm không gian bộ nhớ khác với kích thước đáng kể.

#### Majority element
- Là phần tử xuất hiện nhiều hơn n/2 lần trong mảng, với n là độ dài của mảng

#### Palindrome
- Là một chuỗi ký tự mà khi đọc từ trái sang phải hay từ phải sang trái đều cho ra cùng một dãy ký tự. 

#### Monotonic function
- Hàm monotonic (hay hàm đơn điệu) là một hàm mà giá trị của nó luôn tăng hoặc luôn giảm trong suốt miền xác định của hàm đó. Một cách cụ thể:
    - **Hàm đơn điệu tăng**: là hàm mà khi đầu vào tăng, đầu ra cũng tăng hoặc giữ nguyên. Với mọi $ x_1 < x_2 , f(x_1) \leq f(x_2) $
    - **Hàm đơn điệu giảm**: là hàm mà khi đầu vào tăng, đầu ra sẽ giảm hoặc giữ nguyên. Với mọi $ x_1 > x_2 , f(x_1) \leq f(x_2) $

- Nhờ tính chất này, các hàm đơn điệu thường được dùng trong các thuật toán tìm kiếm và tối ưu hóa để giảm độ phức tạp tính toán, chẳng hạn như khi tìm kiếm nhị phân trong một mảng đơn điệu.

#### Predicate functions
- Predicate functions (hàm điều kiện) là những hàm trong lập trình mà chúng trả về một giá trị boolean (true hoặc false) dựa trên một điều kiện nào đó. Những hàm này thường được sử dụng để kiểm tra, so sánh hoặc xác định tính chất của một đối tượng hay một tập hợp.

    - **Trả về giá trị boolean**: Một hàm predicate chỉ trả về hai giá trị: true hoặc false.
    - **Sử dụng trong các cấu trúc điều kiện**: Các hàm này thường được sử dụng trong các câu lệnh điều kiện, như if, while, hoặc trong các hàm lọc dữ liệu.
    - **Kiểm tra tính chất**: Chúng thường kiểm tra một điều kiện cụ thể, như xem một số có phải là số chẵn hay không, hoặc một chuỗi có chứa một ký tự cụ thể.

#### Monotonic Predicate Function
- Monotonic Predicate Function (hàm điều kiện đơn điệu) là một loại hàm điều kiện có tính chất monotonic, tức là hàm này duy trì tính chất đơn điệu trong miền xác định của nó. Cụ thể, một hàm predicate được coi là monotonic nếu nó luôn trả về giá trị boolean (true hoặc false) mà không thay đổi theo chiều tăng hoặc giảm của các đầu vào.
- Đặc điểm của Monotonic Predicate Function
    - **Monotonic Tăng**: Nếu hàm predicate là đơn điệu tăng, điều này có nghĩa là khi đầu vào tăng, giá trị trả về của hàm chỉ có thể giữ nguyên hoặc trở thành true. Ví dụ, với một hàm predicate kiểm tra xem một số có lớn hơn một giá trị cố định không, nếu số này tăng, thì giá trị trả về sẽ không giảm xuống.

    - **Monotonic Giảm**: Nếu hàm predicate là đơn điệu giảm, điều này có nghĩa là khi đầu vào tăng, giá trị trả về chỉ có thể giữ nguyên hoặc trở thành false. Ví dụ, một hàm predicate kiểm tra xem một số có nhỏ hơn một giá trị cố định không sẽ là hàm đơn điệu giảm.

