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
public class BienDoiTuyenTinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập a, b và kích thước ma trận
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        int n = scanner.nextInt();

        int[][] image = new int[n][n];

        // Nhập ma trận ảnh
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = scanner.nextInt();
            }
        }

        // Áp dụng biến đổi tuyến tính
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int newValue = (int) (a * image[i][j] + b);
                // Đảm bảo giới hạn giá trị trong phạm vi [0, 255]
                newValue = Math.max(0, Math.min(255, newValue));
                image[i][j] = newValue;
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
1.5
50
4
100 150 200 50
75 180 30 220
160 40 90 120
210 70 250 25
*/
