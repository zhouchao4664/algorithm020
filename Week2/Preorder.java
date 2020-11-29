package demo.leecode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhouc
 * @Date: 2020/11/28 16:00
 * @Description: https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/ 589. N叉树的前序遍历
 */
public class Preorder {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);
        for (Node c : root.children) {
            result.addAll(preorder(c));
        }
        return result;
    }

}
