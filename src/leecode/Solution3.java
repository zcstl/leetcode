package leecode;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.xml.soap.SOAPPart;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangcs on 12/1/2018.
 */
public class Solution3 {
    //@link(https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.print(solution3.lengthOfLongestSubstring("aaa"));
        System.out.print(solution3.lengthOfLongestSubstring("a"));
        System.out.print(solution3.lengthOfLongestSubstring("ab"));
        System.out.print(solution3.lengthOfLongestSubstring("aba"));
        System.out.print(solution3.lengthOfLongestSubstring("abasdfasdfaasbababsasdfjxzcvkzljxhhsdhfasaafjfksdjfsdiuofsdfjhxljkfd"));

    }
}


//思路ok，但实现太挫
class Solution3_1 {

    public int lengthOfLongestSubstring(String s)
    {
        if (s == null || s.length() == 0)
        {
            return 0;
        }

        int result = 0, tmpResult = 1;
        //
        Map<Character, Integer> hash = new HashMap<>();
        char repeatChar = '0';
        hash.put(s.charAt(0), 1);
        for (int i = 0, j = 0; j < s.length(); )
        {
            if (!hash.containsKey(s.charAt(j)) || hash.get(s.charAt(j)) == 0)
            {
                ++tmpResult;
                hash.put(s.charAt(j++), 1);
            }
            else
            {
                /*
                *@note
                * 1.repeatChar 无用变量
                * 2.map可用set替代
                * 3.若i==j，则set为空，故可不判断i<j
                * 4.tmpResult即j-i
                * */
                repeatChar = s.charAt(j);
                if (i < j)
                {
                    hash.put(s.charAt(i), hash.get(s.charAt(i)) - 1);
                    if (s.charAt(i) == repeatChar)
                    {
                        repeatChar = '0';
                    }
                    --tmpResult;
                    ++i;
                } else
                {
                    ++j;
                }
            }
            result = tmpResult > result ? tmpResult : result;
        }

        return result;

    }

}

//
class Solution3_2 {

    public int lengthOfLongestSubstring(String s)
    {
        if (s == null)
        {
            return 0;
        }

        int result = 0;
        Set<Character> hash = new HashSet<>();
        for (int i = 0, j = 0; j < s.length(); )
        {
            if (!hash.contains(s.charAt(j)))
            {
                hash.add(s.charAt(j++));
                result = Math.max(result, j - i);
            }
            else
            {
                //此处一定i<j
                hash.remove(s.charAt(i++));
            }
        }

        return result;
    }

}
