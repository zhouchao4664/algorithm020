package demo.leecode.easy;

/**
 * @Auther: zhouc
 * @Date: 2020/12/13 15:21
 * @Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/ 122. 买卖股票的最佳时机 II
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int result = 0;
        int prev = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prev) {
                result += prices[i] - prev;
            }
            prev = prices[i];
        }
        return result;
    }
}
