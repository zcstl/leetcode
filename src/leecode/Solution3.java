package leecode;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.xml.soap.SOAPPart;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangcs on 12/1/2018.
 */
public class Solution3 {

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
                hash.put(s.charAt(j), 1);
                ++j;
            }
            else
            {
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
                } else {
                    ++j;
                }
            }
            result = tmpResult > result ? tmpResult : result;
        }

        return result;

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
