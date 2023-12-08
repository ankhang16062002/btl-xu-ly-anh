/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xulyanh;

/**
 *
 * @author nguye
 */
import java.util.*;

class HuffmanNode {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        left = right = null;
    }
}

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.frequency - y.frequency;
    }
}

public class MaHoaHuffman {
    static Map<Character, String> huffmanCodes = new HashMap<>();

    public static void printCodes(HuffmanNode root, String s) {
        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.data, s);
            return;
        }

        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }

    public static void buildHuffmanTree(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(new MyComparator());

        for (char key : frequencyMap.keySet()) {
            priorityQueue.add(new HuffmanNode(key, frequencyMap.get(key)));
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode x = priorityQueue.poll();
            HuffmanNode y = priorityQueue.poll();

            HuffmanNode sum = new HuffmanNode('\0', x.frequency + y.frequency);
            sum.left = x;
            sum.right = y;

            priorityQueue.add(sum);
        }

        HuffmanNode root = priorityQueue.poll();
        printCodes(root, "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        buildHuffmanTree(text);

        System.out.println("Huffman Codes are: " + huffmanCodes);
    }
}
//HDHHGEHGECDDGFECGBBAFDHGHDBAAH
