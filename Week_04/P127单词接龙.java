//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


package leetcode.editor.cn;

import java.util.*;

//Java：单词接龙
class P127WordLadder {
    public static void main(String[] args) {
        Solution solution = new P127WordLadder().new Solution();
        String[] str = new String[] {"ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"};
        solution.ladderLength("ymain", "oecij", Arrays.asList(str));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            return resolve1(beginWord, endWord, wordList);
        }

        private int resolve1(String beginWord, String endWord, List<String> wordList) {

            Set<String> set = new HashSet<>(wordList);

            if (set.size() == 0 || !set.contains(endWord)){return 0;}

            if (beginWord.equals(endWord)){return 1;}

            //将单词字典的初始化单词去除
            set.remove(beginWord);

            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);

            int len = beginWord.length();

            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            int step = 0;
            while (!queue.isEmpty()){
                step++;
                int size = queue.size();
                for (int i = 0; i < size; i++){
                    String poll = queue.poll();

                    if (len != poll.length()) continue;

                    char[] chars = poll.toCharArray();

                    for (int j = 0; j < len; j++){
                        char oldChar = chars[j];

                        for (char a = 'a'; a < 'z'; a++){
                            if (a == oldChar) continue;
                            chars[j] = a;
                            String newStr = String.valueOf(chars);
                            if (!set.contains(newStr)) continue;
                            if (endWord.equals(newStr)) return step + 1;
                            if (!visited.contains(newStr)){
                                visited.add(newStr);
                                queue.add(newStr);
                            }
                        }

                        chars[j] = oldChar;
                    }
                }
            }

            return 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}