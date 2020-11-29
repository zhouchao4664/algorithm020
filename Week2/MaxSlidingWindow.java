package demo.leecode.difficult;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Auther: zhouc
 * @Date: 2020/11/29 18:04
 * @Description: https://leetcode-cn.com/problems/sliding-window-maximum/  239. 滑动窗口最大值
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || nums.length * k == 0) return new int[0];

        int[] result = new int[nums.length - k + 1];

        LinkedBlockingDeque<Integer> ad = new LinkedBlockingDeque(k);

        for (int i = 0; i < nums.length; i++) {
            //如果第一个元素划出窗口边界，就弹出去
            if (!ad.isEmpty() && ad.getFirst() == i - k) {
                ad.pop();
            }
            //队列里比新划进的元素小的都移除掉，保证队列的顺序是先进来的是最大的,如果没有比刚进入窗口的元素大的，队列会被清空
            while (!ad.isEmpty() && nums[i] > nums[ad.peekLast()]) ad.pollLast();

            //把当前元素加入队列
            ad.offer(i);

            //队列里第一个元素是窗口里最大值
            if (i + 2 > k) {
                result[i - k + 1] = nums[ad.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 4};
        int k = 2;
        int[] result = new MaxSlidingWindow().maxSlidingWindow(nums, k);
        Arrays.stream(result).forEach(System.out::println);
    }
}
