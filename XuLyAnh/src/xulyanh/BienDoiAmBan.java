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
public class BienDoiAmBan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập kích thước ma trận
        int n = scanner.nextInt();

        int[][] image = new int[n][n];

        // Nhập ma trận ảnh
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = scanner.nextInt();
            }
        }

        // Thực hiện biến đổi ảnh (ví dụ: in ngược màu)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = 255 - image[i][j];
            }
        }

        // In ma trận ảnh đã biến đổi
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
4
100 150 200 50
75 180 30 220
160 40 90 120
210 70 250 25
*/
