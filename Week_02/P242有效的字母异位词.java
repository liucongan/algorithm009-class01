//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Java：有效的字母异位词
class P242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        solution.isAnagram("anagram", "nagaram");
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            //暴力解法 使用排序
//            return resolve1(s, t);
            //使用哈希表
            return resolve2(s, t);
        }




        private boolean resolve1(String s, String t){
            if (s == null || t == null || s.length() != t.length()){return false;}

            char[] ss = s.toCharArray();
            char[] ts = t.toCharArray();
            Arrays.sort(ss);
            Arrays.sort(ts);
            for (int i = 0; i < ss.length; i++) {
                if (ss[i] != ts[i]){
                    return false;
                }
            }
            return true;
        }

        private boolean resolve2(String s, String t) {
            if (s == null || t == null || s.length() != t.length()){return false;}
            int[] count = new int[126];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)]++;
                count[t.charAt(i)]--;
            }
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0){
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}