package Graph;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        int level = 1;
        for (String s : wordList)
            set.add(s);

        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int queue_size = queue.size();
            for (int i = 0; i < queue_size; i++) {
                String curr_word = queue.poll();
                char[] curr_word_array = curr_word.toCharArray();
                // traverse char array
                for (int j = 0; j < curr_word_array.length; j++) {
                    char orig_curr_char = curr_word_array[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (orig_curr_char == c)
                            continue;
                        curr_word_array[j] = c;
                        String new_word = String.valueOf(curr_word_array); // convert char array to string
                        if (new_word.equals(endWord)) // string compare is equals
                            return level + 1;
                        // new tranformation
                        if (set.contains(new_word)) {
                            queue.offer(new_word);
                            set.remove(new_word);
                        }
                        curr_word_array[j] = orig_curr_char;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}