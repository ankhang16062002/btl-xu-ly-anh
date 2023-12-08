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
public class GianAnh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[][] se = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };

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
                    boolean isEqual = false;
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            if (se[k+1][l+1] == 1 && image[i + k][j + l] == 1) {
                                isEqual = true;
                                break;
                            }
                        }
                        if (isEqual) {
                            break;
                        }
                    }
                    if (isEqual) {
                        result[i-1][j-1] = 1;
                    }
            }
        }
        System.out.println("Ảnh sau khi giãn");
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
/* Test
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