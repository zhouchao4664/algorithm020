package demo.leecode.easy;

/**
 * @Auther: zhouc
 * @Date: 2021/1/11 00:19
 * @Description: https://leetcode-cn.com/problems/number-of-1-bits/ 191. 位1的个数
 */
public class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int c = 0;
        while (n != 0) {
            c += n & 1;
            n = n >>> 1;
        }
        return c;
    }
}
