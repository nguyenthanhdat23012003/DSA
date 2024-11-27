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

#### Unimodal Functions

- **Định nghĩa**: Một hàm được gọi là unimodal nếu nó có một cực trị duy nhất (có thể là cực đại hoặc cực tiểu) trong miền xác định của nó. Điều này có nghĩa là giá trị của hàm tăng lên cho đến một điểm (cực trị) và sau đó giảm xuống (hoặc ngược lại).

- **Đặc điểm**:

    - Hàm có thể có dạng tăng rồi giảm hoặc giảm rồi tăng.
    - Cực trị có thể là điểm tối đa hoặc tối thiểu, nhưng chỉ có một điểm như vậy.

- **Hình ảnh minh họa**: Một đồ thị của một hàm unimodal sẽ có dạng giống như hình chữ U hoặc hình nón, với một điểm cao nhất hoặc thấp nhất.

#### Bimodal Functions

- **Định nghĩa**: Một hàm được gọi là bimodal nếu nó có hai cực trị (cùng là cực đại hoặc cực tiểu) trong miền xác định của nó. Điều này có nghĩa là hàm có hai điểm mà tại đó giá trị của nó cùng là lớn nhất hoặc nhỏ nhất.

- **Đặc điểm**:

    - Hàm có ba điểm cực trị, có thể là hai điểm tối đa và một điểm tối thiểu hoặc hai điểm tối thiểu và một điểm tối đa .
    - Các giá trị của hàm tăng lên đến điểm cực trị đầu tiên, giảm xuống, và sau đó lại tăng lên đến điểm cực trị thứ hai. (hoặc ngược lại)

- **Hình ảnh minh họa**: Một đồ thị của một hàm bimodal sẽ có dạng giống như một ngọn đồi với hai đỉnh cao và một thung lũng ở giữa

#### Anagram

- **Định nghĩa**: Phép đảo chữ (tiếng Anh: Anagram, hay còn gọi là thuật đảo chữ) là cách một từ hay cụm từ được tái sắp xếp thành các ký tự của 1 từ hay cụm từ khác, sử dụng các ký tự ban đầu chỉ 1 lần duy nhất.
- **Ví dụ**: Từ "rail safety" có thể viết thành "fairy tales" với cùng số lượng từng chữ cái.

#### Happy Number

- **Định nghĩa**: Trong toán học, Happy Number (Số Hạnh Phúc) là một số nguyên dương được xác định dựa trên một quá trình lặp lại. Quá trình này gồm:

1. Lấy các chữ số của số đó, bình phương từng chữ số, rồi cộng lại để tạo ra một số mới.
2. Lặp lại quá trình này với số mới.
3. Nếu quá trình dẫn đến số 1, thì số ban đầu được gọi là Happy Number.
4. Nếu quá trình rơi vào một vòng lặp vô tận mà không bao giờ đạt đến 1, thì số đó được gọi là Unhappy Number.

- **Ví dụ**: Kiểm tra số 19 có phải là Happy Number không:
    - Bước 1: 1^2 + 9^2 = 82
    - Bước 2: 8^2 + 2^2 = 68
    - Bước 3: 6^2 + 8^2 = 100
    - Bước 4: 1^2 + 0^2 + 0^2 = 1
    - Vì quá trình kết thúc với số 1, nên 19 là một Happy Number.