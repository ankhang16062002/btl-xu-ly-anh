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
public class PhatHienBienRobert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đọc kích thước ma trận
        int n = scanner.nextInt();

        int[][] image = new int[n+1][n+1];

        // Đọc ma trận
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = scanner.nextInt();
            }
        }

        // Khởi tạo ma trận kết quả
        int[][] result = new int[n][n];

        // Ma trận gradient theo chiều x
        int[][] Gx = {{1, 0}, {0, -1}};

        // Ma trận gradient theo chiều y
        int[][] Gy = {{0, -1}, {1, 0}};

        // Áp dụng thuật toán edge detection
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int gx = convolution(image, i, j, Gx);
                int gy = convolution(image, i, j, Gy);
                int G = (int) Math.round(Math.sqrt(gx * gx + gy * gy));
                result[i][j] = G;
            }
        }

        // In ma trận kết quả
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    // Hàm tích chập
    private static int convolution(int[][] image, int row, int col, int[][] kernel) {
        int sum = 0;
        int kernelSize = kernel.length;

        for (int i = 0; i < kernelSize; i++) {
            for (int j = 0; j < kernelSize; j++) {
                sum += image[row + i][col + j] * kernel[i][j];
            }
        }

        return sum;
    }
}
/*
7
2 2 2 2 2 2 2
2 2 2 2 2 2 2
2 2 15 15 15 2 2
2 2 13 12 16 2 2
2 2 15 15 15 2 2
2 2 2 2 2 2 2
2 2 2 2 2 2 2
*/
