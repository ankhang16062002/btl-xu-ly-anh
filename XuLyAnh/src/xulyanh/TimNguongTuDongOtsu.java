/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xulyanh;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class TimNguongTuDongOtsu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập kích thước ma trận m x n
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Khởi tạo ma trận m x n
        int[][] image = new int[m][n];

        // Nhập giá trị cho từng phần tử của ma trận
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = scanner.nextInt();
            }
        }

        // Tiếp tục xử lý ảnh như trong phiên bản trước

        int[] values = unique(image);
        int len = values.length;

        int[] valueCounts = new int[len];
        for (int i = 0; i < len; i++) {
            int count = countOccurrences(image, values[i]);
            valueCounts[i] = count;
        }

        double[] pValues = new double[len];
        for (int i = 0; i < len; i++) {
            pValues[i] = (double) valueCounts[i] / (m * n);
        }

        double[] P1Values = new double[len];
        P1Values[0] = pValues[0];
        for (int i = 1; i < len; i++) {
            P1Values[i] = P1Values[i - 1] + pValues[i];
        }

        double[] mValues = new double[len];
        mValues[0] = values[0] * pValues[0];
        for (int i = 1; i < len; i++) {
            mValues[i] = mValues[i - 1] + values[i] * pValues[i];
        }

        double[] sValues = new double[len];
        double mg = mValues[len - 1];
        for (int i = 0; i < len - 1; i++) {
            sValues[i] = Math.pow(mg * P1Values[i] - mValues[i], 2) / (P1Values[i] * (1 - P1Values[i]));
        }

        sValues = roundArray(sValues, 4);

        double sMax = max(sValues);
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (sMax == sValues[i]) {
                index = i;
                break;
            }
        }

        System.out.println("Otsu threshold = " + values[index]);
    }

    private static int[] unique(int[][] array) {
        return Arrays.stream(array)
                     .flatMapToInt(Arrays::stream)
                     .distinct()
                     .toArray();
    }

    private static int countOccurrences(int[][] array, int value) {
        return (int) Arrays.stream(array)
                          .flatMapToInt(Arrays::stream)
                          .filter(v -> v == value)
                          .count();
    }

    private static double[] roundArray(double[] array, int decimals) {
        return Arrays.stream(array)
                     .map(d -> Math.round(d * Math.pow(10, decimals)) / Math.pow(10, decimals))
                     .toArray();
    }

    private static double max(double[] array) {
        return Arrays.stream(array)
                     .max()
                     .orElseThrow(() -> new IllegalArgumentException("Array is empty"));
    }
}
/*
6 5
0 1 2 3 4 5
0 0 1 2 3 4
0 0 0 1 2 3
0 0 0 0 1 2
0 0 0 0 0 1

8 6
1 4 1 1 2 3 2 3
3 2 4 2 5 2 6 2
2 1 8 2 5 2 5 6
2 5 2 4 7 9 1 4
2 2 3 0 0 1 2 1
1 5 7 1 2 4 5 6
*/
