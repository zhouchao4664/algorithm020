package demo.leecode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhouc
 * @Date: 2020/11/26 00:52
 * @Description: https://leetcode-cn.com/problems/valid-anagram/description/ 242. 有效的字母异位词
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {

        /*if (s.length() != t.length()) return false;

        Map<Character,Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                return false;
            } else if (count > 1) {
                map.put(ch, count - 1);
            } else {
                map.remove(ch);
            }
        }

        return map.isEmpty();*/

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        Arrays.sort(schars);
        Arrays.sort(tchars);

        return String.valueOf(schars).equals(String.valueOf(tchars));
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new IsAnagram().isAnagram(s,t));
    }
}
