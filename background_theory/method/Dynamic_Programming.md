# Dynamic Programming (DP)

## Giới thiệu

Dynamic Programming (DP) là một kỹ thuật lập trình được sử dụng để giải quyết các bài toán phức tạp bằng cách chia chúng thành các bài toán con đơn giản hơn và lưu trữ kết quả của các bài toán con để tránh việc tính toán lại nhiều lần. Kỹ thuật này thường được áp dụng cho các bài toán có đặc điểm **tối ưu con** (optimal substructure) và **tính lặp lại** (overlapping subproblems).

## Đặc điểm của Dynamic Programming

1. **Tối ưu con**: Bài toán lớn có thể được giải quyết bằng cách kết hợp các giải pháp tối ưu của các bài toán con.
2. **Tính lặp lại**: Nhiều bài toán con có thể được tính toán nhiều lần trong quá trình giải quyết bài toán lớn.

## Các bước cơ bản trong Dynamic Programming

1. **Xác định bài toán**: Xác định bài toán mà bạn cần giải quyết.
2. **Xác định cấu trúc của bài toán con**: Chia bài toán thành các bài toán con nhỏ hơn.
3. **Lưu trữ kết quả**: Lưu trữ kết quả của các bài toán con đã tính toán để tránh tính toán lại.
4. **Giải quyết bài toán con**: Giải quyết các bài toán con và kết hợp kết quả để tìm ra giải pháp cho bài toán gốc.

## Phân loại Dynamic Programming

1. **Top-Down Approach** (Memoization): 
   - Bắt đầu từ bài toán lớn và chia nhỏ nó thành các bài toán con. Lưu trữ kết quả của các bài toán con đã giải quyết để sử dụng lại khi cần thiết.
   - Thường được triển khai bằng cách sử dụng đệ quy.

2. **Bottom-Up Approach** (Tabulation):
   - Bắt đầu từ các bài toán con nhỏ nhất và dần dần xây dựng giải pháp cho bài toán lớn hơn bằng cách sử dụng kết quả của các bài toán con đã giải quyết.
   - Thường được triển khai bằng cách sử dụng vòng lặp.

## Ví dụ

### Bài toán Fibonacci

Bài toán Fibonacci là một ví dụ đơn giản để minh họa kỹ thuật DP.

- Mô tả: Tính số Fibonacci thứ n, trong đó F(0) = 0, F(1) = 1, và F(n) = F(n-1) + F(n-2) cho n >= 2.

#### Top-Down Approach (Memoization)

```java
public class Fibonacci {
    private int[] memo;

    public int fib(int n) {
        memo = new int[n + 1];
        return fibMemo(n);
    }

    private int fibMemo(int n) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibMemo(n - 1) + fibMemo(n - 2);
        return memo[n];
    }
}
```

#### Bottom-Up Approach (Tabulation)
```java
public class Fibonacci {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
```

## Ưu điểm và Nhược điểm

### Ưu điểm
- Giảm thiểu thời gian tính toán bằng cách tránh việc tính toán lại.
- Cung cấp một cách tiếp cận hệ thống để giải quyết các bài toán phức tạp.

### Nhược điểm
- Cần phải sử dụng thêm bộ nhớ để lưu trữ kết quả của các bài toán con (trong trường hợp không tối ưu).
- Cấu trúc mã có thể phức tạp hơn so với các phương pháp khác.

## Kết luận

Dynamic Programming là một kỹ thuật mạnh mẽ trong lập trình, giúp tối ưu hóa giải pháp cho nhiều bài toán khác nhau. Hiểu và nắm vững DP sẽ giúp bạn giải quyết được nhiều bài toán phức tạp trong lập trình và tối ưu hóa hiệu suất của ứng dụng.
