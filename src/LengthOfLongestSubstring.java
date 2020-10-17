import java.util.HashSet;

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

    }

    public int lengthOfLongestSubstring(String s) {
        int max=0,cmax=0;
        String cs="";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                cs=s.substring(i,j+1);
                cmax=isSubstring(cs);
                if(cmax>max){
                    max=isSubstring(cs);
                }
            }
        }
        return max;
    }

    public static int isSubstring(String s){
        if(s.equals("")){
            return 0;
        }
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
