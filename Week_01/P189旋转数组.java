//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组


package leetcode.editor.cn;
//Java：旋转数组
class P189RotateArray{
    public static void main(String[] args) {
        Solution solution = new P189RotateArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        //暴力解法
//        resolve1(nums, k);

        //新数组
//        resolve2(nums, k);

        //环状替换(暂时还没有太弄懂)
//        resolve3(nums, k);

        resolve4(nums, k);
    }

        private void resolve1(int[] nums, int k){
            int pre, temp;
            for (int i = 0; i < k; i++) {
                pre = nums[nums.length - 1];
                for (int j = 0; j < nums.length; j++) {
                    temp = nums[j];
                    nums[j] = pre;
                    pre = temp;
                }
            }
        }

        private void resolve2(int[] nums, int k){
            int len = nums.length;
            int[] n = new int[len];
            for (int i = 0; i < len; i++) {
                n[(i+k) % len] = nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = n[i];
            }

        }

        private void resolve3(int[] nums, int k){

        }

        private void resolve4(int[] nums, int k){
            k %= nums.length;
            reverse(nums, 0 , nums.length - 1);
            reverse(nums, 0 , k - 1);
            reverse(nums, k, nums.length - 1);
        }

        private void reverse(int[] nums, int start, int end){
            while (start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)
}