package ArrayString;

import java.util.HashSet;

public class LongestNonRepeating {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int slider1 = 0;
        int slider2 = 0;
        HashSet<Character> set = new HashSet<>();

        while (slider2 < s.length()) {
            if (!set.contains(s.charAt(slider2))) { // then add into hash set update max
                set.add(s.charAt(slider2));
                maxLength = Math.max(set.size(), maxLength);
                slider2++;
            } else { // remove from hashset
                set.remove(s.charAt(slider1));
                slider1++;
            }
        }
        return maxLength;

    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcd");
    }
}