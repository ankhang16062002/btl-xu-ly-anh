/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xulyanh;

/**
 *
 * @author nguye
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LZW {
    public static Map<String, Integer> buildDictionary() {
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            dictionary.put("" + (char) i, i);
        }
        return dictionary;
    }

    public static String compressLZW(String input) {
        Map<String, Integer> dictionary = buildDictionary();
        int nextCode = 256;
        StringBuilder compressed = new StringBuilder();
        String current = "";

        for (char symbol : input.toCharArray()) {
            String combined = current + symbol;
            if (dictionary.containsKey(combined)) {
                current = combined;
            } else {
                compressed.append(dictionary.get(current)).append(" ");
                dictionary.put(combined, nextCode++);
                current = "" + symbol;
            }
        }

        if (!current.equals("")) {
            compressed.append(dictionary.get(current));
        }

        return compressed.toString();
    }

    public static String decompressLZW(String compressed) {
        Map<Integer, String> dictionary = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            dictionary.put(i, "" + (char) i);
        }

        StringBuilder decompressed = new StringBuilder();
        String[] codes = compressed.split(" ");
        int prevCode = Integer.parseInt(codes[0]);
        decompressed.append(dictionary.get(prevCode));

        int nextCode = 256;
        for (int i = 1; i < codes.length; i++) {
            int currentCode = Integer.parseInt(codes[i]);

            String entry;
            if (dictionary.containsKey(currentCode)) {
                entry = dictionary.get(currentCode);
            } else if (currentCode == nextCode) {
                entry = dictionary.get(prevCode) + dictionary.get(prevCode).charAt(0);
            } else {
                throw new IllegalArgumentException("Invalid compressed data");
            }

            decompressed.append(entry);
            dictionary.put(nextCode++, dictionary.get(prevCode) + entry.charAt(0));
            prevCode = currentCode;
        }

        return decompressed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputText = scanner.nextLine();

        String compressedText = compressLZW(inputText);
        System.out.println("LZW Compressed: " + compressedText);

        String decompressedText = decompressLZW(compressedText);
        System.out.println("LZW Decompressed: " + decompressedText);
    }
}
//BABAABAAA