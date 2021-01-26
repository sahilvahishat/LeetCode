package ArrayString;

public class strStr {
    public static int strStrLength(String haystack, String needle) {
        if (needle.length() > haystack.length())
            return -1;
        if (needle.isEmpty())
            return 0;
        for (int i = 0; i < haystack.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if ((i + j) > haystack.length() - 1) // make sure index is not out of bound
                    return -1;
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break; // compare each corresponding

            }
            if (j == needle.length())
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStrLength("mississippi", "issipi"));
    }
}