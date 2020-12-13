package demo.leecode.easy;

import java.util.Arrays;

/**
 * @Auther: zhouc
 * @Date: 2020/12/13 14:37
 * @Description: https://leetcode-cn.com/problems/lemonade-change/description/ 860. 柠檬水找零
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) return true;
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five==0) return false;
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five > 2) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {10,10};
        System.out.println(new LemonadeChange().lemonadeChange(bills));
    }
}
