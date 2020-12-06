package demo.leecode.medium;

import java.util.Arrays;

/**
 * @Auther: zhouc
 * @Date: 2020/12/6 23:03
 * @Description: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/comments/ 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
                break;
            }
        }

        return root;
    }
}
