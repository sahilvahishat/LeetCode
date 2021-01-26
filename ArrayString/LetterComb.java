package ArrayString;

import java.util.*;

public class LetterComb {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.length() == 0)
            return result;
        String[] map = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        result.add("");

        for (int i = 0; i < digits.length(); i++) { // pricess all digits
            int index = Character.getNumericValue(digits.charAt(i)); // 2

            while (result.peek().length() == i) {

                char[] curr = map[index].toCharArray(); // process all char in digits

                String currResultVal = result.remove(); // take out a and and ad ae af

                for (char c : curr) {
                    result.add(currResultVal + c);
                }
            }
        }
        return result;
    }
}
