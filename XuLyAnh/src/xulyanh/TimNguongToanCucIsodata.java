/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xulyanh;

import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class TimNguongToanCucIsodata {
    public static int calculateIsodataThreshold(int[][] grayMatrix) {
        int rows = grayMatrix.length;
        int cols = grayMatrix[0].length;

        // Initialize threshold t0 with the average gray level
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += grayMatrix[i][j];
            }
        }
        int t0 = sum / (rows * cols);

        int t1;
        do {
            t1 = t0;
            int sum1 = 0, count1 = 0;
            int sum2 = 0, count2 = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grayMatrix[i][j] <= t0) {
                        sum1 += grayMatrix[i][j];
                        count1++;
                    } else {
                        sum2 += grayMatrix[i][j];
                        count2++;
                    }
                }
            }

            // Calculate the new threshold
            int mean1 = (count1 == 0) ? 0 : sum1 / count1;
            int mean2 = (count2 == 0) ? 0 : sum2 / count2;
            t0 = (mean1 + mean2) / 2;
        } while (t1 != t0);

        return t0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the image (square): ");
        int size = scanner.nextInt();

        int[][] grayMatrix = new int[size][size];

        System.out.println("Enter the gray levels for each pixel:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grayMatrix[i][j] = scanner.nextInt();
            }
        }

        int threshold = calculateIsodataThreshold(grayMatrix);

        System.out.println("Automatic Threshold (Isodata): " + threshold);
    }
}
/*
5


100 120 110 95 105
90 100 115 105 98
105 110 105 98 100
80 85 95 100 110
120 125 130 125 120
*/
