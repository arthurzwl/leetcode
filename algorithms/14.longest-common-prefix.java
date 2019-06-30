/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if (strs.length == 0 || strs[0].length() == 0) {
//             return "";
//         }
//         StringBuilder sb = new StringBuilder();
//         int i = 0;
//         boolean flag = true;
//         while (flag) {
//             if (strs[0].length() <= i) {
//                 break;
//             }
//             char c = strs[0].charAt(i);
//             for (String str : strs) {
//                 if (str.length() <= i) {
//                     flag = false;
//                     break;
//                 }
//                 if (c != str.charAt(i)) {
//                     flag = false;
//                     break;
//                 }
//             }
//             if (flag) {
//                 sb.append(c);
//             }
//             i++;
//         }
//         return sb.toString();
//     }
// }

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0] == null || strs[0].length() == 0) {
            return "";
        }
        String first = strs[0];
        int endIndex = first.length();
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            if (s == null || s.length() == 0) {
                return "";
            }
            endIndex = Math.min(endIndex, s.length());
            while (!s.startsWith(first.substring(0, endIndex))) {
                if (endIndex < 1) {
                    return "";
                }
                endIndex--;
            }
        }
        return first.substring(0, endIndex);
    }
}

