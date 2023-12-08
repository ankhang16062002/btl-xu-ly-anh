/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package xulyanh;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author nguye
 */
public class CanBangLuocDoXam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();

        double l = sc.nextInt();

        int[][] a = new int[m][n];

        HashMap<Integer, Double> map = new HashMap<>();

        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

               a[i][j] = sc.nextInt();

               if(map.get(a[i][j]) == null) map.put(a[i][j], (double)1);

               else map.put(a[i][j], map.get(a[i][j]) + 1);

            }

        }

        Set<Integer> set = map.keySet();

        HashMap<Integer, Long> map2 = new HashMap<>();

        double tmp = 0;

        for(Integer x : set){

            map.put(x, map.get(x) + tmp);

            tmp = map.get(x);

            double s = (l-1)*tmp / (m*n);

            map2.put(x, Math.round((s*10)/10));

        }

        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                System.out.print(map2.get(a[i][j]) + " ");

            }

            System.out.println("");

        }
    }
    
}
/*
5 4
8
1 2 0 4
1 0 0 7
2 2 1 0
4 1 2 1
2 0 1 1
*/
