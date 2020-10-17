import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args){
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring1(s));
//        System.out.println(lengthOfLongestSubstring());
    }
    //滑动窗口解法
    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> ooc=new HashSet<Character>();
        int n=s.length();

        int max=0,rk=-1;//右指针，初始值为-1,相当于在我们字符串的左边界的左侧，还没有开始移动
        for (int i=0;i<n;i++){
            if (i!=0){
                //左指针向右移动一格，移除一个字符
                ooc.remove(s.charAt(i-1));
            }
            while (rk+1<n&&!ooc.contains(s.charAt(rk+1))){
                ooc.add(s.charAt(rk+1));
                rk++;
            }
            max=Math.max(max,rk-i+1);
        }
        return max;
    }


    /**
     * 代码正确但是超出时间限制（寻找时间小的解法）
     * 通过测试用例986 / 987 个
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int max=0,cmax=0;
        String cs="";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                cs=s.substring(i,j);
                cmax=isSubstring(cs);
                if(cmax>max){
                    max=isSubstring(cs);
                }
            }
        }
        return max;
    }

    public static int isSubstring(String s){
        HashSet hashSet=new HashSet();
        boolean isSubstring=true;
        hashSet.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(hashSet.contains(s.charAt(i))){
                isSubstring=false;
                break;
            }else{
                hashSet.add(s.charAt(i));
            }
        }
        if(isSubstring==true){
            return s.length();
        }else{
            return 1;
        }
    }
}
