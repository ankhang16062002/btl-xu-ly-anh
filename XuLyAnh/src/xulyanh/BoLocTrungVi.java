/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xulyanh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class BoLocTrungVi {
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
        System.out.println("In ra tmp");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                List<Integer> tmp = new ArrayList<>();
                int index = 0;
                boolean hasAddedValue = false;
                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        int value = a[i + k][j + l];
                        if (!tmp.contains(value)) {
                            tmp.add(value);
                        }
                    }
                }
                System.out.println("a"+i+j+": ");
                Collections.sort(tmp);
                for (int p = 0; p <tmp.size(); p++) {
                        System.out.print(tmp.get(p) + " ");
                    
                }
                System.out.println();
                if(tmp.size()%2==0)
                    result[i - 1][j - 1] = tmp.get(tmp.size()/2-1);
                else 
                    result[i - 1][j - 1] = tmp.get((tmp.size()+1)/2-1);
            }
        }

        // Hiển thị ma trận kết quả
        System.out.println("Ma trận kết quả:");
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
/*
4
2 7 3 0
3 1 6 3
0 1 3 5
3 6 7 1

4
1 2 2 1
2 3 3 2
2 3 4 3
1 2 3 2
*/
