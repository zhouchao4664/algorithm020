package demo.leecode.medium;

/**
 * @Auther: zhouc
 * @Date: 2021/1/18 01:17
 * @Description: https://leetcode-cn.com/problems/reverse-words-in-a-string/ 151. 翻转字符串里的单词
 */
public class ReverseWords {
    public String reverseWords(String s) {
        s = s.replaceAll(" +", " ").trim();
        String[] strings = s.split(" ");
        int j = strings.length - 1;
        for (int i = 0; i < j; i++, j--) {
            String temp = strings[i];
            strings[i] = strings[j];
            strings[j] = temp;
        }

        return String.join(" ",strings);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("the sky is blue"));
    }
}
