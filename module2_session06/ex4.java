package module2_session06;

import java.util.Scanner;

public class ex4 {
    private static String longestIncreasingSubsequence(String str) {
        int n = str.length();
        if (n == 0) return "";

        int[] length = new int[n];
        int[] previousIndex = new int[n];

        for (int i = 0; i < n; i++) {
            length[i] = 1;
            previousIndex[i] = -1;
        }

        int maxLength = 1;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (str.charAt(i) > str.charAt(j) && length[i] < length[j] + 1) {
                    length[i] = length[j] + 1;
                    previousIndex[i] = j;
                }
            }
            if (length[i] > maxLength) {
                maxLength = length[i];
                maxIndex = i;
            }
        }

        StringBuilder result = new StringBuilder();
        while (maxIndex >= 0) {
            result.append(str.charAt(maxIndex));
            maxIndex = previousIndex[maxIndex];
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào chuỗi bất kỳ: ");
        String input = scanner.nextLine();

        String result = longestIncreasingSubsequence(input);
        System.out.println("Chuỗi con tăng dần dài nhất là: " + result);

        scanner.close();
    }
}
