package demo.leecode.medium;

/**
 * @Auther: zhouc
 * @Date: 2020/12/6 22:39
 * @Description: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/ 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        //如果左右都不为空，证明pq在两边，返回rot
        if (left!=null&&right!=null) return root;

        return left != null ? left : right;
    }
}
