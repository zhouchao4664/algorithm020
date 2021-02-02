package demo.leecode.easy;

/**
 * @Auther: zhouc
 * @Date: 2021/1/18 00:50
 * @Description: https://leetcode-cn.com/problems/reverse-string-ii/ 541. 反转字符串 II
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ) {

            // 如果剩余字符小于k，全部翻转
            if (chars.length - i < k) {
                for (int j = chars.length - 1; j > i; j--, i++) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
                break;
            } else {
                for (int j = i + k - 1; j > i; j--, i++) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
                // 移动index到下一组2k上
                i = i - (k / 2) + 2 * k;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        new ReverseStr().reverseStr("a",2);
    }
}
