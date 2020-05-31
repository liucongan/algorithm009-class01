//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


package leetcode.editor.cn;

import java.util.*;

//Java：字母异位词分组
class P49GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
//        return resolve1(strs);

        return resolve2(strs);
    }

        private List<List<String>> resolve2(String[] strs) {
            if (strs == null || strs.length == 0) return new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            int[] ca = new int[26];
            for (String s : strs) {

                for (char c : s.toCharArray()) ca[c - 'a']++;
                String keyStr = Arrays.toString(ca);
                if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
                map.get(keyStr).add(s);
            }
            return new ArrayList<>(map.values());
        }

        private void resize(int[] nums){
            for(int i = 0; i < nums.length; i++){
                nums[i] = 0;
            }
        }


        private List<List<String>> resolve1(String[] strs) {
            List<List<String>> lists = new ArrayList<>();
            if (strs == null || strs.length == 0){
                return lists;
            }
            Map<String, List<String>> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String s = String.valueOf(chars);
                if (map.containsKey(s)){
                    List<String> strings = map.get(s);
                    strings.add(strs[i]);
                } else {
                    List<String> strings = new ArrayList<>();
                    strings.add(strs[i]);
                    map.put(s, strings);
                }
            }
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                lists.add(entry.getValue());
            }

            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}