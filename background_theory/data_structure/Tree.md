# Cấu Trúc Dữ Liệu Cây (Tree Data Structure)

Cấu trúc dữ liệu cây (tree) là một cấu trúc phi tuyến tính, trong đó các phần tử được tổ chức theo cấp bậc. Cây rất quan trọng trong khoa học máy tính và có nhiều biến thể khác nhau với các ứng dụng cụ thể.

## 1. Khái Niệm Cơ Bản

- **Nút (Node)**: Là thành phần cơ bản của cây, mỗi nút chứa dữ liệu và có thể có một hoặc nhiều nút con.
  - Ví dụ: Trong cây tổ chức công ty, một nút có thể là một nhân viên, và nút con của nó là các nhân viên cấp dưới.
- **Gốc (Root)**: Là nút cao nhất, không có nút cha.
  - Ví dụ: Trong cây phân cấp thư mục của hệ điều hành, thư mục gốc là thư mục chính, từ đó các thư mục con được phát sinh.
- **Cạnh (Edge)**: Kết nối hai nút với nhau, xác định mối quan hệ giữa chúng.
  - Ví dụ: Trong cây họ hàng, cạnh kết nối giữa cha và con đại diện cho mối quan hệ giữa chúng.
- **Lá (Leaf)**: Nút không có nút con nào.
  - Ví dụ: Trong cây thư mục máy tính, một tập tin cụ thể không chứa thư mục con nào chính là một nút lá.
- **Nút cha (Parent)**: Là nút mà một hoặc nhiều nút con kết nối đến nó.
  - Ví dụ: Trong cây phả hệ, một người cha là nút cha và các con của người đó là các nút con.
- **Nút con (Child)**: Là nút kết nối từ một nút cha.
  - Ví dụ: Trong cây tổ chức công ty, các nhân viên báo cáo trực tiếp cho một người quản lý là các nút con của người quản lý đó.
- **Mức (Level)**: Số lượng cạnh từ nút gốc đến một nút cụ thể.
  - Ví dụ: Trong cây thư mục máy tính, mức của một tập tin là số thư mục từ thư mục gốc đến tập tin đó.
- **Chiều cao (Height)**: Là chiều dài đường đi dài nhất từ một nút đến lá.
  - Ví dụ: Chiều cao của cây thư mục là số thư mục con từ thư mục gốc đến tập tin xa nhất.
- **Cây con (Subtree)**: Một cây con là một phần của cây mẹ, bao gồm một nút và tất cả các nút con của nó.
  - Ví dụ: Trong một cây họ hàng, một nhánh con của một gia đình có thể coi là một cây con.

## 2. Các Loại Cấu Trúc Cây Thường Gặp

### 2.1. Cây Tổng Quát (General Tree)

Mỗi nút có thể có một số nút con không giới hạn. Đây là dạng cây cơ bản và ít được dùng vì không có cấu trúc rõ ràng.

### 2.2. Cây Nhị Phân (Binary Tree)

Cây nhị phân là cây trong đó mỗi nút có tối đa 2 nút con: nút con trái và nút con phải.

**Triển khai cây nhị phân xem ở data_structure_implement/BinaryTree**

#### Phân loại cây nhị phân:

- **Cây nhị phân đầy đủ (Full Binary Tree)**: Mỗi nút có 0 hoặc 2 nút con.
- **Cây nhị phân hoàn chỉnh (Complete Binary Tree)**: Mọi mức đều được lấp đầy, trừ mức cuối cùng, và các nút ở mức cuối cùng được sắp từ trái sang phải.
- **Cây nhị phân cân bằng (Balanced Binary Tree)**: Độ sâu của cây con trái và cây con phải của mỗi nút không chênh lệch quá 1.

### 2.3. Cây Tìm Kiếm Nhị Phân (Binary Search Tree - BST)

Là cây nhị phân trong đó, với mỗi nút N, tất cả các nút trong cây con trái của N có giá trị nhỏ hơn N, và tất cả các nút trong cây con phải có giá trị lớn hơn N.

**Ứng dụng**: Được dùng để tìm kiếm, chèn, và xóa dữ liệu một cách hiệu quả.

### 2.4. Cây AVL

Là dạng cây tìm kiếm nhị phân, nhưng đảm bảo cân bằng độ cao giữa cây con trái và cây con phải để tối ưu các thao tác tìm kiếm, chèn và xóa.

#### Tính chất:

- Chiều cao của cây AVL luôn duy trì cân bằng sau các phép chèn hoặc xóa bằng cách thực hiện quay cây (rotation).

### 2.5. Cây Đỏ-Đen (Red-Black Tree)

Một cây tự cân bằng khác với mỗi nút có thêm thuộc tính màu (đỏ hoặc đen) để duy trì sự cân bằng trong cây sau các thao tác chèn và xóa.

#### Tính chất:

- Mỗi nút là đỏ hoặc đen.
- Gốc luôn là đen.
- Mỗi đường dẫn từ gốc đến lá chứa cùng số lượng nút đen.

### 2.6. Cây B (B-tree)

Cây B là một cây tự cân bằng trong đó mỗi nút có thể có nhiều hơn hai nút con. Cây B được dùng để lưu trữ dữ liệu trên đĩa hoặc cơ sở dữ liệu để giảm thiểu số lần truy xuất đĩa.

**Ứng dụng**: Cây B rất hiệu quả trong hệ thống file và cơ sở dữ liệu do khả năng lưu trữ lớn và truy xuất nhanh.

### 2.7. Cây Heaps

- **Max-Heap**: Mỗi nút đều có giá trị lớn hơn hoặc bằng giá trị của các nút con. Nút gốc là nút có giá trị lớn nhất.
- **Min-Heap**: Mỗi nút đều có giá trị nhỏ hơn hoặc bằng giá trị của các nút con. Nút gốc là nút có giá trị nhỏ nhất.

**Ứng dụng**: Heaps được dùng trong các thuật toán sắp xếp (heap sort) và trong cấu trúc dữ liệu ưu tiên (priority queue).

### 2.8. Trie (Prefix Tree)

Cây này được sử dụng để lưu trữ một tập hợp các chuỗi. Mỗi cạnh tương ứng với một ký tự, và một đường dẫn từ gốc đến một lá sẽ tương ứng với một chuỗi.

**Ứng dụng**: Trie thường được dùng để tìm kiếm nhanh các từ trong từ điển hoặc kiểm tra chuỗi con.

### 2.9. Cây Phân Đoạn (Segment Tree)

Cây phân đoạn được sử dụng để lưu trữ các khoảng (interval) hoặc đoạn của mảng và cho phép thực hiện các thao tác trên các đoạn, như tìm tổng, giá trị nhỏ nhất, hoặc lớn nhất trong khoảng thời gian O(log n).

### 2.10. Cây Phân Tán (Fenwick Tree / Binary Indexed Tree)

Cây phân tán được dùng để xử lý các thao tác trên mảng một cách hiệu quả, đặc biệt là tính toán tổng trước (prefix sum) và cập nhật giá trị phần tử.

## 3. Các Thuật Toán Liên Quan Đến Cây

### Duyệt Cây (Tree Traversal)

Các thuật toán duyệt cây là phương pháp truy cập vào từng nút của cây. Các phương pháp phổ biến:

- **Duyệt trước (Pre-order)**: Nút gốc -> Cây con trái -> Cây con phải.
- **Duyệt giữa (In-order)**: Cây con trái -> Nút gốc -> Cây con phải. Được sử dụng trong cây tìm kiếm nhị phân để duyệt theo thứ tự tăng dần.
- **Duyệt sau (Post-order)**: Cây con trái -> Cây con phải -> Nút gốc.
- **Duyệt theo tầng (Level-order)**: Duyệt từng tầng của cây theo thứ tự từ trên xuống dưới.

### Chèn, Xóa và Tìm Kiếm

Trong cây tìm kiếm nhị phân và các biến thể tự cân bằng như AVL, đỏ-đen, mỗi thao tác chèn (insert), xóa (delete) và tìm kiếm (search) đều được thực hiện với độ phức tạp O(log n) trong trường hợp tốt nhất khi cây được cân bằng.

### Cân Bằng Cây (Balancing Trees)

Để duy trì độ cao nhỏ nhất cho cây nhằm tối ưu hóa các thao tác, cây thường được cân bằng thông qua các thuật toán quay (rotation):

- **Quay trái (Left Rotation)**.
- **Quay phải (Right Rotation)**.

Các thao tác này thường được sử dụng trong cây AVL và cây đỏ-đen để đảm bảo cây luôn cân bằng sau khi chèn hoặc xóa.

## 4. Ứng Dụng Thực Tế của Cấu Trúc Dữ Liệu Cây

- **Hệ thống file (File System)**: Hệ điều hành sử dụng cây thư mục để quản lý tệp và thư mục.
- **Cây quyết định (Decision Trees)**: Được sử dụng trong trí tuệ nhân tạo và học máy để mô hình hóa các quyết định dựa trên các điều kiện.
- **Trie (Prefix Tree)**: Được sử dụng trong các ứng dụng kiểm tra từ điển hoặc autocomplete.
- **Heap**: Được sử dụng trong các hệ thống lập lịch CPU, thuật toán tìm kiếm đường đi ngắn nhất (Dijkstra), và quản lý bộ nhớ.
- **Cây phân đoạn và Fenwick Tree**: Sử dụng trong các bài toán về khoảng (interval), như tính tổng hoặc tìm giá trị lớn nhất/nhỏ nhất trong một đoạn của mảng.

## Kết Luận

Cây là một cấu trúc dữ liệu rất mạnh mẽ và linh hoạt, có rất nhiều loại khác nhau với các đặc điểm và ứng dụng riêng biệt. Việc lựa chọn loại cây nào phụ thuộc vào bài toán cụ thể và yêu cầu về độ phức tạp của các thao tác trên dữ liệu.
