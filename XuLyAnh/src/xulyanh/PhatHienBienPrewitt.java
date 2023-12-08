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
public class PhatHienBienPrewitt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] a = new int[n+2][n+2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        int[][] result = new int[n][n];
        int[][] Gx = {
                {-1, 0, 1},
                {-1, 0, 2},
                {-1, 0, 1}
        };
        int[][] Gy = {
                {-1, -1, -1},
                {0, 0, 0},
                {1, 1, 1}
        };

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n; j++) {
                int gx = 0, gy = 0;

                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        gx += a[i + k][j + l] * Gx[k + 1][l + 1];
                        gy += a[i + k][j + l] * Gy[k + 1][l + 1];
                    }
                }

                int G = (int) Math.round(Math.sqrt(gx * gx + gy * gy));
                result[i-1][j-1] = G;
            }
        }

        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
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