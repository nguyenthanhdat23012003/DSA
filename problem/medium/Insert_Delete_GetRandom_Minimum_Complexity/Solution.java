package problem.medium.Insert_Delete_GetRandom_Minimum_Complexity;

import java.util.*;

class RandomizedSet {
    private List<Integer> nums;
    private Map<Integer, Integer> map;
    private Random rand;

    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastElement = nums.get(nums.size() - 1);
        nums.set(index, lastElement);
        map.put(lastElement, index);
        nums.remove(nums.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
