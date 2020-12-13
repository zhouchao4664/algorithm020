package demo.leecode.easy;

import java.util.Arrays;

/**
 * @Auther: zhouc
 * @Date: 2020/12/13 15:57
 * @Description: https://leetcode-cn.com/problems/assign-cookies/description/ 455. 分发饼干
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (index < g.length && g[index] <= s[i]){
                result++;
                index++;
            }
        }
        return result;
    }
}
