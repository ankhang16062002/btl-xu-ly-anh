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
public class CoAnh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n_se = scanner.nextInt();

        int[][] se = new int[n_se][n_se];
        for (int i = 0; i < n_se; i++) {
            for (int j = 0; j < n_se; j++) {
                se[i][j] = scanner.nextInt();
            }
        }

        int n = scanner.nextInt();
        int[][] image = new int[n+2][n+2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                image[i][j] = scanner.nextInt();
            }
        }

        int[][] result = new int[n][n];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i + n_se <= n+1 && j + n_se <= n+1) {
                    boolean isEqual = true;
                    for (int k = 0; k < n_se; k++) {
                        for (int l = 0; l < n_se; l++) {
                            if (se[k][l] == 1 && image[i + k][j + l] != 1) {
                                isEqual = false;
                                break;
                            }
                        }
                        if (!isEqual) {
                            break;
                        }
                    }
                    if (isEqual) {
                        result[i-1 + n_se / 2][j-1 + n_se / 2] = 1;
                    }
                }
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
3
1 0 0
0 1 1
1 0 0
8
0 1 1 0 0 1 0 0 
1 1 0 0 0 1 1 0
0 1 1 0 1 1 1 1 
1 1 0 1 1 1 1 1
1 0 1 1 1 1 0 0
1 0 0 1 0 1 1 1
1 0 1 1 1 0 1 0
1 0 0 0 1 1 1 1
*/