package DP;

public class minInsert {
    public int minInsertions(String s) {
        StringBuilder r = new StringBuilder(); // LCS //get longest palindromic string
        r.append(s);
        r = r.reverse();

        int len = s.length();
        int[][] matrix = new int[len + 1][len + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == 0 || j == 0)
                    matrix[i][j] = 0;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if ((s.substring(i - 1, i)).compareTo(r.substring(j - 1, j)) == 0) { // Matched
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        System.out.println("LPS" + matrix[len][len]);
        return s.length() - matrix[len][len];
    }
}