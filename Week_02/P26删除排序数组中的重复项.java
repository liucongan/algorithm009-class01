//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：删除排序数组中的重复项
class P26RemoveDuplicatesFromSortedArray{
    public static void main(String[] args) {
        Solution solution = new P26RemoveDuplicatesFromSortedArray().new Solution();
        solution.removeDuplicates(new int[]{1,1,2});
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        //1. 使用一个数组来缓存
//        return resolve1(nums);
        //2.使用散列表（hashMap,hashTable）
//        return resolve2(nums);
        //1。维护未出现坐标和数值
        return resolve3(nums);
    }

        public int resolve1(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int[] temp = new int[nums.length];
        int val = 0,j=0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                val = nums[i];
                temp[j++] = val;
                continue;
            }
            if (val != nums[i]){
                val = nums[i];
                temp[j++] = val;
            }
        }
        for (int i = 0; i < j; i++) {
            nums[i] = temp[i];
        }
        return j;
    }

        private int resolve2(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            Map<Integer, Integer> map = new HashMap<>();
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])){
                    map.put(nums[i], nums[i]);
                    nums[j++] = nums[i];
                }
            }
            return j;
        }

        private int resolve3(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int start = 0, step = 1;
            while (step < nums.length){
                if (step == 1){

                }
                if (nums[start] != nums[step]){
                    nums[++start] = nums[step];
                }
                step++;
            }
            return start+1;
        }
}


//leetcode submit region end(Prohibit modification and deletion)

}