import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class kfreq {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();

        for (String word : words) {
            myMap.put(word, myMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String word1, String word2) {
                int f1 = myMap.get(word1);
                int f2 = myMap.get(word2);
                if (f1 == f2)
                    return word2.compareTo(word1);
                return f1 - f2;
            }
        });

        for (Map.Entry<String, Integer> entry : myMap.entrySet()) { // [a,b ,c, d]
            pq.add(entry.getKey()); // insert
            if (pq.size() > k) // remove first element
                pq.poll();

        }
        System.out.println(pq);

        List<String> result = new ArrayList<String>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.reverse(result);

        System.out.println(result);

        return result;
    }
}
