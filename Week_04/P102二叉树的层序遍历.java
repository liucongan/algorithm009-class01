//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


package leetcode.editor.cn;

import java.util.*;

//Java：二叉树的层序遍历
class P102BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.*/
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return resolve1(root);
    }

    private List<List<Integer>> resolve1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root != null){
            queue.add(root);
        }

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();

            int size = queue.size();

            for (int i = 0; i < size; i++){
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    queue.add(poll.left);
                }
                if (poll.right != null){
                    queue.add(poll.right);
                }

                level.add(poll.val);
            }
            res.add(level);
        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}