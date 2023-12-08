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
public class BoLocLaplacian {
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
        int[][] laplace = {
                {0, 1, 0},
                {1, -4, 1},
                {0, 1, 0}
        };

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int L = 0;

                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        L += a[i + k][j + l] * laplace[k + 1][l + 1];
                    }
                }

                result[i-1][j-1] = Math.abs(L);
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
