package demo.leecode.easy;

/**
 * @Author zhouchao
 * @Date 2020/12/23 17:34
 * @Description https://leetcode-cn.com/problems/first-unique-character-in-a-string/ 387. 字符串中的第一个唯一字符
 **/

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        //只循环了26次
        int result = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int firstIndex = s.indexOf(c);
            int lastIndex = s.lastIndexOf(c);

            //如果相等表示不重复
            if (lastIndex == firstIndex && firstIndex != -1) {
                result = Math.min(firstIndex, result);
            }
        }
        if (result != s.length()) {
            return result;
        }
        return -1;
    }
}
