package demo.leecode.easy;

/**
 * @Auther: zhouc
 * @Date: 2021/1/11 00:51
 * @Description: https://leetcode-cn.com/problems/power-of-two/ 231. 2的幂
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = n;
        return (x & (-x)) == x;
    }

    public static void main(String[] args) {
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(-2147483648));
    }
}
