package ArrayString;

public class FirstUniqueChar {
    public static int firstUniqChar(String s) {
        if (s.length() == 1)
            return 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && i != j) {
                    break;
                }
                if (j == s.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("dddccdbba"));
    }
}