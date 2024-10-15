# HashTable và HashMap trong Java

## Giới thiệu

`HashTable` và `HashMap` là hai cấu trúc dữ liệu quan trọng trong Java, cho phép lưu trữ dữ liệu dưới dạng cặp khóa-giá trị. Cả hai đều sử dụng hàm băm để xác định vị trí lưu trữ của giá trị trong bảng.

## Nguyên lý hoạt động

### Hàm băm

Cả `HashTable` và `HashMap` đều sử dụng một hàm băm để chuyển đổi khóa thành chỉ mục trong mảng. Hàm băm là một hàm toán học nhận đầu vào là khóa (có thể là một chuỗi, số, hoặc bất kỳ kiểu dữ liệu nào khác) và trả về một giá trị số nguyên, được gọi là chỉ mục. Chỉ mục này xác định vị trí mà giá trị tương ứng sẽ được lưu trữ trong mảng.

Hàm băm cần phải đáp ứng một số yêu cầu để hoạt động hiệu quả:

1. **Tính duy nhất**: Hai khóa khác nhau nên cho ra hai chỉ mục khác nhau. Tuy nhiên, không thể tránh khỏi trường hợp mà hai khóa khác nhau lại cho ra cùng một chỉ mục, gọi là xung đột.

2. **Phân phối đều**: Hàm băm nên phân phối các khóa đều trên không gian chỉ mục để giảm thiểu khả năng xung đột. Điều này có thể đạt được bằng cách sử dụng các hàm băm tốt, như hàm băm FNV (Fowler–Noll–Vo), SHA-1, hoặc các thuật toán băm chuyên biệt cho từng loại dữ liệu.

3. **Tính toán nhanh**: Hàm băm cần phải được tính toán nhanh chóng để đảm bảo hiệu suất cao trong các thao tác chèn, tìm kiếm và xóa.

### Xung đột

Xung đột xảy ra khi hai hoặc nhiều khóa khác nhau dẫn đến cùng một chỉ mục trong bảng băm. Điều này có thể làm giảm hiệu suất của bảng băm vì nó có thể làm phức tạp các thao tác tìm kiếm, chèn và xóa.

Để xử lý xung đột, cả `HashTable` và `HashMap` sử dụng hai phương pháp chính:

1. **Nối chuỗi (Chaining)**: 
   - Trong phương pháp này, mỗi chỉ mục trong mảng không chỉ lưu trữ một giá trị mà có thể lưu trữ một danh sách (hoặc một cấu trúc dữ liệu khác như cây) chứa tất cả các cặp khóa-giá trị tương ứng với chỉ mục đó. 
   - Khi một xung đột xảy ra, giá trị mới sẽ được thêm vào danh sách này. Khi thực hiện tìm kiếm, chương trình sẽ kiểm tra từng phần tử trong danh sách để tìm ra giá trị tương ứng.

   **Ví dụ**: Giả sử ta có một bảng băm với kích thước 5 và sử dụng hàm băm `h(key) = key % 5`. 
   - Khi chèn các giá trị 10, 15 và 20, tất cả đều băm về chỉ mục 0:
     - `h(10) = 10 % 5 = 0`
     - `h(15) = 15 % 5 = 0`
     - `h(20) = 20 % 5 = 0`
   - Ta sẽ lưu trữ chúng trong một danh sách tại chỉ mục 0: `0 -> [10 -> 15 -> 20]`.

2. **Mở rộng (Open Addressing)**:
   - Phương pháp này không sử dụng danh sách liên kết. Thay vào đó, nếu xảy ra xung đột, nó sẽ tìm kiếm một chỉ mục khác trong mảng (thường là theo một quy tắc nhất định) cho đến khi tìm thấy một vị trí trống để lưu trữ giá trị mới. 
   - Có nhiều phương pháp mở rộng khác nhau như linear probing (tìm kiếm tuyến tính), quadratic probing (tìm kiếm bậc hai) và double hashing (băm đôi).

   **Ví dụ**: Vẫn với bảng băm có kích thước 5 và hàm băm như trên. 
   - Nếu ta chèn các giá trị 10 và 15, chúng sẽ được lưu trữ ở chỉ mục 0 và 0 (gây xung đột).
   - Khi chèn giá trị 15, ta sẽ tìm chỉ mục tiếp theo trống, có thể là chỉ mục 1, và lưu giá trị 15 tại đó.

Cả hai phương pháp đều có ưu và nhược điểm riêng. Nối chuỗi đơn giản và dễ triển khai, nhưng có thể dẫn đến việc sử dụng bộ nhớ lớn nếu nhiều xung đột xảy ra. Trong khi đó, mở rộng thường sử dụng bộ nhớ hiệu quả hơn nhưng có thể làm giảm hiệu suất nếu bảng băm quá đông đúc.


## HashTable

### Triển khai

`HashTable` là một lớp trong Java, được đồng bộ hóa (synchronized) và không cho phép các khóa hoặc giá trị là `null`. 

### Ví dụ sử dụng HashTable
```java
import java.util.Hashtable;

public class HashTableExample {
    public static void main(String[] args) {
        // Tạo một HashTable
        Hashtable<String, Integer> table = new Hashtable<>();

        // Thêm các cặp khóa-giá trị
        table.put("Apple", 50);
        table.put("Banana", 30);
        table.put("Orange", 40);

        // Lấy giá trị dựa trên khóa
        System.out.println("Giá của Apple: " + table.get("Apple")); // 50

        // Xóa phần tử
        table.remove("Banana");
        System.out.println("Giá của Banana sau khi xóa: " + table.get("Banana")); // null

        // In kích thước của HashTable
        System.out.println("Kích thước của HashTable: " + table.size()); // 2
    }
}
```
## HashMap

### Triển khai

`HashMap` cũng là một lớp trong Java, không đồng bộ hóa và cho phép khóa hoặc giá trị là `null`.

### Ví dụ sử dụng HashMap
```java
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // Tạo một HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Thêm các cặp khóa-giá trị
        map.put("Apple", 50);
        map.put("Banana", 30);
        map.put("Orange", 40);

        // Lấy giá trị dựa trên khóa
        System.out.println("Giá của Apple: " + map.get("Apple")); // 50

        // Xóa phần tử
        map.remove("Banana");
        System.out.println("Giá của Banana sau khi xóa: " + map.get("Banana")); // null

        // In kích thước của HashMap
        System.out.println("Kích thước của HashMap: " + map.size()); // 2
    }
}
```
## Khác biệt giữa HashTable và HashMap

| Đặc điểm        | HashTable                          | HashMap                            |
|----------------|------------------------------------|------------------------------------|
| Đồng bộ hóa     | Có (synchronized)                  | Không (không synchronized)         |
| Null keys/values| Không cho phép                     | Cho phép một khóa null và nhiều giá trị null |
| Tốc độ          | Chậm hơn do đồng bộ hóa            | Nhanh hơn trong hầu hết các tình huống |
| Ứng dụng        | Thường được sử dụng trong các ứng dụng đa luồng | Được ưa chuộng hơn trong các ứng dụng không đồng bộ hóa |

## Những điểm giống nhau giữa HashTable và HashMap

- Cả hai đều lưu trữ dữ liệu dưới dạng cặp khóa-giá trị.
- Cả hai đều sử dụng hàm băm để xác định vị trí lưu trữ của giá trị.
- Đều cho phép truy cập nhanh đến các giá trị thông qua khóa.
- Cả hai đều có thể được sử dụng trong nhiều ứng dụng để tối ưu hóa truy cập và lưu trữ dữ liệu.

## Ưu điểm và Nhược điểm

### HashTable

#### Ưu điểm
- An toàn khi sử dụng trong môi trường đa luồng do được đồng bộ hóa.
- Dễ dàng triển khai cho các ứng dụng cần đồng bộ hóa.

#### Nhược điểm
- Tốc độ chậm hơn so với `HashMap`.
- Không cho phép khóa hoặc giá trị là `null`, điều này có thể gây khó khăn trong một số tình huống.

### HashMap

#### Ưu điểm
- Hiệu suất tốt hơn trong hầu hết các tình huống do không có đồng bộ hóa.
- Cho phép sử dụng khóa và giá trị null, tạo sự linh hoạt hơn.

#### Nhược điểm
- Không an toàn trong môi trường đa luồng mà không có các biện pháp bảo vệ bổ sung.
- Có thể gặp phải các vấn đề về đồng bộ hóa nếu được sử dụng trong một ứng dụng đa luồng mà không được bảo vệ.

## Ứng dụng

- **HashTable** thường được sử dụng trong các ứng dụng mà đồng bộ hóa là cần thiết, chẳng hạn như trong các hệ thống giao dịch tài chính.
- **HashMap** được sử dụng phổ biến hơn trong các ứng dụng không cần đồng bộ hóa, chẳng hạn như trong các ứng dụng web hoặc API.

## Kết luận

Cả `HashTable` và `HashMap` đều là các cấu trúc dữ liệu mạnh mẽ trong Java. Lựa chọn giữa chúng phụ thuộc vào yêu cầu của ứng dụng, đặc biệt là về đồng bộ hóa và hiệu suất.
