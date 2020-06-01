//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Java：二叉树的中序遍历
class P94BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
        P94BinaryTreeInorderTraversal tra = new P94BinaryTreeInorderTraversal();

        P94BinaryTreeInorderTraversal.TreeNode treeNode = tra.new TreeNode(1);
        treeNode.right = tra.new TreeNode(3);
        treeNode.right.left = tra.new TreeNode(2);
        solution.inorderTraversal(treeNode);
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
    public List<Integer> inorderTraversal(TreeNode root) {
        //递归解法
//        return resolve1(root);
        //2。基于栈解法
//        return resolve2(root);
        //3.线性二叉树
        return resolve3(root);
    }

    private List<Integer> resolve1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        search(root, list);
        return list;
    }

    private void search(TreeNode root, List<Integer> list){
        if (root != null){
            if (root.left != null){
                search(root.left, list);
            }
            list.add(root.val);

            if (root.right != null){
                search(root.right, list);
            }
        }
    }

    /**
     *
     * @param root
     * @return
     */
    private List<Integer> resolve2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while(curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }


    private List<Integer> resolve3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null){
            if (curr.left == null){
                list.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return list;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}