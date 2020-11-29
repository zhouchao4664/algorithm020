package demo.leecode.easy;

import java.util.HashMap;

/**
 * @Author zhouchao
 * @Date 2020/11/19 13:40
 * @Description https://leetcode-cn.com/problems/two-sum/description/ 1. 两数之和
 **/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i && target == nums[i] + nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }*/

        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                result[0] = i;
                result[1] = hash.get(nums[i]);
                return result;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};

        int[] result = new TwoSum().twoSum(nums,6);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
