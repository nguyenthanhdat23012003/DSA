# Greedy Algorithm

## Giới thiệu
Phương pháp Greedy (Tham lam) là một kỹ thuật giải bài toán trong đó giải pháp được xây dựng từng bước, với mỗi bước chọn lựa giải pháp tốt nhất tại thời điểm đó mà không xem xét các lựa chọn sau này. Mục tiêu của thuật toán Greedy là tìm ra một lời giải tối ưu cho bài toán bằng cách lựa chọn các bước tối ưu cục bộ.

## Nguyên tắc
- **Tối ưu cục bộ**: Tại mỗi bước, chọn lựa lựa chọn tốt nhất (tối ưu nhất) mà không cần quan tâm đến kết quả tổng thể.
- **Quyết định không quay lui**: Một khi đã đưa ra quyết định, thuật toán sẽ không thay đổi quyết định đó.
- **Lựa chọn ngắn hạn**: Chọn lựa tối ưu nhất tại thời điểm mà không cần xem xét ảnh hưởng của nó đến các lựa chọn trong tương lai.

## Đặc điểm
- Thuật toán Greedy không đảm bảo rằng nó sẽ luôn tìm ra giải pháp tối ưu toàn cục. Tuy nhiên, trong nhiều trường hợp, nó có thể đạt được giải pháp gần tối ưu.
- Độ phức tạp của thuật toán Greedy thường thấp hơn so với các phương pháp khác như quy hoạch động.

## Ví dụ
1. **Bài toán Ba lô (Knapsack Problem)**: Trong bài toán ba lô, thuật toán Greedy có thể được áp dụng để chọn những vật phẩm có giá trị cao nhất trong giới hạn trọng lượng của ba lô.

```java
// Ví dụ 1: Bài toán Ba lô (Knapsack Problem)
// Mô tả: Cho một tập hợp các vật phẩm, mỗi vật phẩm có giá trị và trọng lượng. 
// Mục tiêu là chọn một tập hợp con các vật phẩm sao cho tổng trọng lượng không vượt quá dung tích của ba lô và tổng giá trị là lớn nhất.

import java.util.Arrays;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class Knapsack {
    public static double getMaxValue(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double maxValue = 0;
        for (Item item : items) {
            if (capacity <= 0) break;

            if (item.weight <= capacity) {
                maxValue += item.value;
                capacity -= item.weight;
            } else {
                maxValue += item.value * ((double) capacity / item.weight);
                capacity = 0;
            }
        }

        return maxValue;
    }
}
```
   
2. **Bài toán Coin Change**: Khi đưa ra số tiền và yêu cầu sử dụng ít đồng tiền nhất có thể, thuật toán Greedy sẽ chọn các đồng tiền lớn nhất trước, miễn là còn đủ để hoàn thành số tiền cần thiết.

```java
// Ví dụ 2: Bài toán Coin Change
// Mô tả: Cho một tập hợp các đồng tiền có giá trị khác nhau và một số tiền cần đổi. 
// Mục tiêu là sử dụng số lượng đồng tiền ít nhất để đổi thành số tiền đó.
import java.util.Arrays;

public class CoinChange {
    public static int getMinCoins(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }

        return count;
    }
}
```

3. **Sắp xếp thời gian**: Bài toán sắp xếp thời gian là một ví dụ điển hình khác, nơi ta muốn chọn các nhiệm vụ sao cho không có nhiệm vụ nào chồng chéo nhau.

```java
// Ví dụ 3: Sắp xếp thời gian
// Mô tả: Cho một tập hợp các công việc, mỗi công việc có thời gian bắt đầu, thời gian kết thúc và lợi nhuận. 
// Mục tiêu là chọn một tập hợp con các công việc không chồng chéo sao cho tổng lợi nhuận là lớn nhất.
import java.util.Arrays;
import java.util.Comparator;

class Job {
    int start, end, profit;

    Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

public class JobScheduling {
    public static int scheduleJobs(Job[] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.end));

        int maxProfit = 0;
        int lastJobEndTime = -1;

        for (Job job : jobs) {
            if (job.start >= lastJobEndTime) {
                maxProfit += job.profit;
                lastJobEndTime = job.end;
            }
        }

        return maxProfit;
    }
}
```

## Ưu điểm
- Đơn giản, dễ hiểu và dễ triển khai.
- Thường có độ phức tạp thấp, nhanh hơn nhiều phương pháp khác.
  
## Nhược điểm
- Không phải lúc nào cũng đạt được giải pháp tối ưu toàn cục.
- Cần phải kiểm tra kỹ lưỡng để đảm bảo rằng chiến lược Greedy là phù hợp với bài toán cụ thể.

## Kết luận
Phương pháp Greedy là một công cụ mạnh mẽ trong lập trình và giải quyết bài toán. Mặc dù không phải lúc nào cũng cho kết quả tối ưu, nhưng với nhiều bài toán, nó là một phương pháp hiệu quả để tìm ra giải pháp nhanh chóng và dễ hiểu.
