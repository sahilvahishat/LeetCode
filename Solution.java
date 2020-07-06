public class Solution {
    public static void main(String[] args) {
        // Object
        kfreq kfreqObj = new kfreq();
        // inputs
        String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
        int k = 2;
        // Method call
        kfreqObj.topKFrequent(words, k);
    }

}