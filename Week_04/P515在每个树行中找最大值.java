//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//Java：在每个树行中找最大值
class P515FindLargestValueInEachTreeRow{
    public static void main(String[] args) {
        Solution solution = new P515FindLargestValueInEachTreeRow().new Solution();
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
    public List<Integer> largestValues(TreeNode root) {
//        BFS
//        return resolve1(root);

        //DFS
        return resolve2(root);
    }

    private List<Integer> resolve1(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root != null){
            queue.add(root);
            res.add(root.val);
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            Integer max = null;
            for (int i = 0; i < size; i++){
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    queue.add(poll.left);
                }
                if (poll.right != null){
                    queue.add(poll.right);
                }
                if (max == null){max = poll.val;}
                max = max < poll.val ? poll.val : max;
            }
            res.add(max);
        }

        return res;
    }


    private List<Integer> resolve2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recur(root, res, 0);
        return res;
    }

    private void recur(TreeNode root, List<Integer> res, int level) {
        if (root == null){return;}

        if (level == res.size()){
            res.add(root.val);
        } else {
            res.set(level, Math.max(res.get(level), root.val));
        }

        recur(root.left, res, level + 1);
        recur(root.right, res, level + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}