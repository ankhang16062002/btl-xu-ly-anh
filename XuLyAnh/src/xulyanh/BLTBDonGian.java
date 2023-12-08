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
public class BLTBDonGian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        solve(scanner);

        scanner.close();
    }

    static void solve(Scanner scanner) {
        int n = scanner.nextInt();

        // Thêm số 0 bao quanh ma trận
        int[][] a = new int[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        
        for (int i = 0; i < n+2; i++) {
            for (int j = 0; j < n+2; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        tmp += a[i + k][j + l];
                    }
                }
                System.out.print(Math.round((float)tmp / 9) + " ");
            }
            System.out.println();
        }
    }
}
/*
5
0 5 0 5 5
1 7 6 6 7
5 5 6 2 7
6 6 7 5 6
0 1 5 0 2
*/