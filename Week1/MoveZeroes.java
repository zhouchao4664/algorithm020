package demo.leecode.easy;

/**
 * @Author zhouchao
 * @Date 2020/11/18 16:29
 * @Description
 **/

public class MoveZeroes {
    //思路：设置一个index，表示非0数的个数，循环遍历数组，
    // 如果不是0，将非0值移动到第index位置,然后index + 1
    //遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
    /*public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }*/


    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0, j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) continue;
            if (j == 0) j = i;
            for (; j < nums.length; j++) {
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    j++;
                    break;
                }
            }
            if (j==nums.length) break;
        }
    }

    public static void main(String[] args) {
        System.out.println("start...");
        int[] nums = {0,0,0};
        new MoveZeroes().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
        System.out.println();
        System.out.println("end...");
    }
}
