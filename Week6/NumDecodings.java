package demo.leecode.medium;

/**
 * @Auther: zhouc
 * @Date: 2020/12/27 23:02
 * @Description: https://leetcode-cn.com/problems/decode-ways/ 91. 解码方法
 */
public class NumDecodings {
    public int numDecodings(String s) {
        /*
        // 特殊处理的字符；
        if (s == null) return 0;
        if (s.startsWith("0") || s.contains("00")) return 0;
        if (s.length() < 2) return s.length();

        int[] result = new int[s.length() + 1];

        //初始值，result[0]也设置为1
        result[0] = 1;
        result[1] = 1;

        // 动态规划处理
        for (int i = 1; i < s.length(); i++) {
            String str = s.substring(i - 1, i + 1);
            int num = Integer.parseInt(str);

            //如果这一位是0，需要判断这个数字是否大于26，如果大于直接返回0
            if ('0' == str.charAt(1) &&Integer.parseInt(str) > 26) return 0;

            if (str.startsWith("0")) {
                result[i + 1] = result[i - 2];
            } else if (str.endsWith("0")) {
                result[i + 1] = result[i - 1];
            } else if (num < 27) {
                result[i + 1] = result[i] + result[i - 1];
            } else {
                result[i + 1] = result[i];
            }
        }
        return result[s.length()];
        */


        // 上面是自己写的，太啰嗦了，下面借鉴了别人的
        int[] result = new int[s.length() + 1];

        //初始值，result[0]也设置为1
        result[0] = 1;
        char prev = ' ';

        // 动态规划处理
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0'){
                if (i == 0) return 0;
                if (prev == '1' || prev == '2'){
                    result[i+1] = result[i-1];
                    prev = s.charAt(i);
                    continue;
                }
                return 0;
            }

            if (prev == '1') {
                result[i + 1] = result[i] + result[i - 1];
            } else if (prev == '2'){
                result[i+1] = s.charAt(i) > '6' ? result[i] : result[i] + result[i - 1];
            } else {
                result[i + 1] = result[i];
            }
            prev = s.charAt(i);
        }
        return result[s.length()];
    }

    public static void main(String[] args) {

        String s = "0";

        int result = new NumDecodings().numDecodings(s);
        System.out.println(result);
    }


}
