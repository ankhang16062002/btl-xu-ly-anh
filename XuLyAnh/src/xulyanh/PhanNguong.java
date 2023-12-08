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
public class PhanNguong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập ngưỡng và kích thước ma trận
        int threshold = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] image = new int[n][n];

        // Nhập ma trận ảnh
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = scanner.nextInt();
            }
        }

        // Áp dụng phân ngưỡng
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] <= threshold) {
                    image[i][j] = 0;
                } else {
                    image[i][j] = 255;
                }
            }
        }

        // In ma trận ảnh đã biến đổi theo đúng định dạng đầu ra
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
/*
100
4 
50 150 200 50
75 180 30 220
160 40 90 120
210 70 250 25
*/
