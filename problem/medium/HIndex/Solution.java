package problem.medium.HIndex;

class Solution {
    // // Solution 1
    // // Sort
    // public int hIndex(int[] citations) {
    //     int count = 0;
    //     sort(citations);
    //     for(int i = citations.length - 1; i >=0; i--){
    //         if(citations[i] >= citations.length - i) {
    //             count++;
    //         } else {
    //             break;
    //         }
    //     }

    //     return count;
    // }

    // public void sort(int[] citations) {
    //     for(int i = 0; i < citations.length; i++){
    //         for(int j = 0; j < citations.length - i - 1; j++){
    //             if(citations[j] > citations[j + 1]){
    //                 int temp = citations[j];
    //                 citations[j] = citations[j + 1];
    //                 citations[j + 1] = temp;
    //             }
    //         }
    //     }
    // }

    // Solution 2
    // Counting Sort
    public int hIndex(int[] citations) {
        int[] counting = new int[citations.length + 1];
        for(int i = 0; i < citations.length; i++){
            if(citations[i] > citations.length) {
                citations[i] = citations.length;
            }
        }

        for(int i = 0; i < citations.length; i++){
            counting[citations[i]]++;
        }

        int total = 0;
        for(int i = counting.length - 1; i >= 0; i--){
            total += counting[i];
            if(total >= i) {
                return i;
            }
        }

        return 0;
    }
}