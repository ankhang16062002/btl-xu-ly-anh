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
public class BLTBCoTrongSo {
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
        
//        for (int i = 0; i < n+2; i++) {
//            for (int j = 0; j < n+2; j++) {
//                System.out.print(a[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println("Ảnh kết quả");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                float tmp = 0;
                int w;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if(l!=0 && k!=0) w=1;
                        else if(l==0 && k==0) w=4;
                        else w=2;
                        tmp += a[i + k][j + l]*w;
                    }
                }
                System.out.print(Math.round(tmp / 16) + " ");
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
