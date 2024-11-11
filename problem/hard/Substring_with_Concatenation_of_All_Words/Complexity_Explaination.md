# Phân Tích Độ Phức Tạp cho Bài Toán `Substring with Concatenation of All Words`

## Mô Tả Bài Toán

Cho một chuỗi `s` và một mảng các chuỗi `words`, tìm tất cả các chỉ số bắt đầu của các chuỗi con trong `s` là sự kết hợp liên tiếp của từng từ trong `words` mà không có bất kỳ ký tự xen giữa.

### Ký Hiệu

- `n`: Độ dài của chuỗi `s`.
- `m`: Số lượng từ trong mảng `words`.
- `k`: Độ dài của mỗi từ trong `words`.

---

## Thuật Toán 1: Brute Force + Hash Map

### Cách Tiếp Cận

1. Sử dụng một cửa sổ trượt có kích thước $ m \cdot k $ (`sumLength`), trong đó `m` là số lượng từ và `k` là độ dài của mỗi từ.
2. Với mỗi cửa sổ:
   - Lưu chuỗi con có kích thước $ m \cdot k $ vào biến `subString`.
   - Chia chuỗi con thành các phần nhỏ có kích thước `k` (`subSubString`).
   - Kiểm tra nếu các phần này khớp với số lượng từ trong mảng `words` bằng cách sử dụng một HashMap.
3. Đặt lại HashMap và tiếp tục với chỉ số bắt đầu mới trong chuỗi `s`.

### Độ Phức Tạp

#### Độ Phức Tạp Thời Gian

Bước 1: Khởi tạo `storeWords` và `check`
- **Khởi tạo `storeWords`:**
  - Duyệt qua mảng `words` có $ m $ phần tử:
    - Với mỗi từ, thêm vào HashMap bằng thao tác `put` hoặc cập nhật số lần xuất hiện bằng `get` và `put`.
  - **Thời gian:** $ O(m) $.

- **Sao chép `storeWords` sang `check`:**
  - Sử dụng `putAll` để sao chép HashMap `storeWords` có kích thước $ m $.
  - **Thời gian:** $ O(m) $.

Bước 2: Vòng lặp `while` với cửa sổ độ dài `sumLength`

1. **Số lần lặp của vòng `while`:**
   - Vòng `while` chạy từ $ \text{startIdx} = 0 $ đến $ \text{startIdx} + \text{sumLength} \leq n $, với $ \text{sumLength} = m \cdot k $.
   - Số lần lặp: $ O(n - \text{sumLength} + 1) = O(n) $.

2. **Bên trong vòng `while`:**
   - **Tạo `subString`:**
     - Tách chuỗi con có độ dài $ \text{sumLength} = m \cdot k $.
     - **Thời gian:** $ O(m \cdot k) $.

   - **Vòng lặp `for` để kiểm tra từ trong `subString`:**
     - Lặp qua từng từ trong `subString` (có $ m $ từ):
       - Tách chuỗi con `subSubString` có độ dài $ k $.
         - **Thời gian:** $ O(k) $.
       - Kiểm tra và cập nhật trong HashMap `storeWords`:
         - Thao tác `containsKey`, `get`, `put`, hoặc `remove` đều mất $ O(1) $ trung bình.
       - **Thời gian mỗi vòng lặp:** $ O(k) $.
     - **Thời gian cho vòng lặp `for`:** $ O(m \cdot k) $.

   - **Kiểm tra và thêm vào `result`:**
     - Nếu kích thước của `storeWords` bằng 0, thêm `startIdx` vào `result`.
     - **Thời gian:** $ O(1) $.

   - **Đặt lại `storeWords`:**
     - Sao chép lại HashMap `check` sang `storeWords`.
     - **Thời gian:** $ O(m) $.

3. **Tổng thời gian mỗi lần lặp của `while`:**
   - $ O(m \cdot k) + O(m \cdot k) + O(m) = O(m \cdot k) $.

4. **Tổng thời gian cho tất cả các lần lặp `while`:**
   - $ O(n) \cdot O(m \cdot k) = O(n \cdot m \cdot k) $.

---

**Tổng Thời Gian**
- $ O(m) $ (khởi tạo `storeWords` và `check`) + $ O(n \cdot m \cdot k) $ (vòng lặp `while`).
- **Kết luận:** $ O(m + n \cdot m \cdot k) $.

---

#### Độ Phức Tạp Không Gian

1. **`storeWords` và `check`:**
   - Hai HashMap lưu số lần xuất hiện của từng từ trong `words`.
   - Kích thước tối đa: $ m $.
   - **Không gian:** $ O(m) $.

2. **`subString`:**
   - Lưu chuỗi con của `s` -  `subString` có độ dài $ \text{sumLength} = m \cdot k $ (sử dụng **substring** thì không cần lưu trong bộ nhớ, nhưng cần lưu chuỗi ban đầu trong bộ nhớ để duyệt, ở đây ta tìm `subSubString` nên cần lưu `subString` lại trong bộ nhớ)
   - **Không gian:** $ O(m \cdot k) $.

3. **Danh sách `result`:**
   - Lưu các chỉ số bắt đầu của các chuỗi con hợp lệ.
   - Trong trường hợp xấu nhất, mọi chỉ số đều hợp lệ. Số lượng phần tử tối đa là $ n $.
   - **Không gian:** $ O(n) $.

4. **Biến tạm:**
   - Các biến như `startIdx`, `subSubString`, và `sumLength` có không gian cố định.
   - **Không gian:** $ O(1) $.

---

**Tổng Không Gian**
- **HashMap:** $ O(m) $.
- **Chuỗi con `subString`:** $ O(m \cdot k) $.
- **Danh sách kết quả `result`:** $ O(n) $.
- **Biến tạm:** $ O(1) $.
- **Tổng cộng:** $ O(m + m \cdot k + n) $.
---

## Thuật Toán 2: Sliding Window + Hash Map

### Cách Tiếp Cận

1. Sử dụng một cửa sổ trượt với bước nhảy bằng `k` (độ dài của từ).
2. Với mỗi đoạn có kích thước bằng từ trong `s`:
   - Đếm số lần xuất hiện của các từ trong cửa sổ hiện tại bằng HashMap (`currentWord`).
   - Nếu số lần xuất hiện của từ vượt quá yêu cầu trong `storeWord`, điều chỉnh chỉ số bắt đầu của cửa sổ.
3. Nếu tất cả từ khớp, lưu chỉ số bắt đầu.

### Độ Phức Tạp

#### Độ Phức Tạp Thời Gian

Bước 1: Khởi tạo `storeWord`

- **Khởi tạo `storeWord`:**
  - Duyệt qua mảng `words` có $ m $ phần tử:
    - Với mỗi từ, thêm vào HashMap bằng thao tác `put` hoặc cập nhật số lần xuất hiện bằng `getOrDefault`.
  - **Thời gian:** $ O(m) $.

---

Bước 2: Vòng lặp qua các điểm bắt đầu khả thi trong `s`

1. **Số lần lặp của vòng `for`:**
   - Vòng `for` chạy từ $ i = 0 $ đến $ i < k $, với `k` là độ dài của mỗi từ.
   - **Số lần lặp:** $ O(k) $.

2. **Bên trong vòng lặp `for`:**

   - **Vòng `while`:**
     - Vòng `while` chạy từ `startIdx = i` đến $ \text{endIdx} + k \leq n $, với $ n $ là độ dài của chuỗi `s`.
     - Số lần lặp: $ O(n / k) $.

   - **Trong mỗi lần lặp của `while`:**
     - **Lấy `subString`:**
       - Tách chuỗi con từ `s` có độ dài $ k $.
       - **Thời gian:** $ O(k) $.

     - **Cập nhật HashMap `currentWord`:**
       - Kiểm tra và cập nhật `currentWord`:
         - Thao tác `containsKey`, `getOrDefault`, hoặc `put`: $ O(1) $.
       - **Thời gian:** $ O(1) $.

     - **Kiểm tra giới hạn và điều chỉnh cửa sổ:**
       - Nếu số lần xuất hiện của từ vượt quá giới hạn trong `storeWord`, điều chỉnh `startIdx`:
         - Tách từ ở đầu cửa sổ (`leftWord`) và cập nhật `currentWord`.
         - **Thời gian:** $ O(1) $ cho mỗi lần điều chỉnh.
       - Tổng số lần điều chỉnh: $ O(m) $ trong trường hợp xấu nhất (tối đa $ m $ từ trong cửa sổ).

     - **Kiểm tra và thêm vào `result`:**
       - Nếu số từ trong cửa sổ khớp với `words`, thêm `startIdx` vào danh sách kết quả.
       - **Thời gian:** $ O(1) $.

   - **Thời gian mỗi lần lặp của `while`:**
     - $ O(k) + O(1) + O(1) = O(k) $.

   - **Tổng thời gian cho vòng `while`:**
     - $ O(n / k) \cdot O(k) = O(n) $.

3. **Tổng thời gian cho vòng lặp `for`:**
   - $ O(k) \cdot O(n) = O(n) $.

---

**Tổng Thời Gian**

- $ O(m) $ (khởi tạo `storeWord`) + $ O(n) $ (vòng lặp).
- **Kết luận:** $ O(m + n) $.

---

#### Độ Phức Tạp Không Gian

1. **`storeWord`:**
   - HashMap lưu số lần xuất hiện của từng từ trong `words`.
   - Kích thước tối đa: $ m $.
   - **Không gian:** $ O(m) $.

2. **`currentWord`:**
   - HashMap theo dõi số lần xuất hiện của các từ trong cửa sổ hiện tại.
   - Kích thước tối đa: $ m $.
   - **Không gian:** $ O(m) $.

3. **Danh sách `result`:**
   - Lưu các chỉ số bắt đầu của các chuỗi con hợp lệ.
   - Trong trường hợp xấu nhất, mọi chỉ số đều hợp lệ. Số lượng phần tử tối đa là $ n $.
   - **Không gian:** $ O(n) $.

4. **Biến tạm:**
   - Các biến như `count`, `startIdx`, `endIdx`, và `subString` có không gian cố định.
   - **Không gian:** $ O(1) $.

---

**Tổng Không Gian**

- **HashMap:** $ O(m) + O(m) = O(m) $.
- **Danh sách kết quả `result`:** $ O(n) $.
- **Biến tạm:** $ O(1) $.
- **Tổng cộng:** $ O(m + n) $.
---

## So Sánh

| **Đặc Điểm**        | **Thuật Toán 1** (Brute Force)       | **Thuật Toán 2** (Sliding Window)       |
|----------------------|-------------------------------------|-----------------------------------------|
| **Thời Gian**        | $$ O(n \cdot m \cdot k + m) $$     | $$ O(n + m) $$                         |
| **Không Gian**       | $$ O(m + m \cdot k + n) $$         | $$ O(m + n) $$                         |

---

## Nhận Xét

- **Thuật Toán 1** lưu tường minh các chuỗi con (`subString`) cho mỗi cửa sổ, dẫn đến không gian sử dụng cao hơn.
- **Thuật Toán 2** xử lý từ động trong cửa sổ trượt, giúp giảm đáng kể chi phí không gian.

---

## Kết Luận

Với các trường hợp sử dụng thực tế, **Thuật Toán 2 (Sliding Window)** được ưu tiên hơn nhờ vào độ phức tạp thời gian và không gian thấp, đặc biệt với chuỗi dài và mảng từ lớn.
