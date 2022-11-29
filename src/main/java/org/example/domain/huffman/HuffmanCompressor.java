package org.example.domain.huffman;

import org.example.domain.heap.ArrayHeap;
import org.example.domain.heap.Heap;

import java.util.HashMap;
import java.util.Map;

public class HuffmanCompressor {

    public HuffmanCompressor() {
    }


    public HuffmanCompression compress(String text) {
        int[] counts = getCharacterFrequency(text);
        HuffmanTree tree = getHuffmanTree(counts);
        String[] codes = getCodes(tree.getRoot());

        return HuffmanCompression.builder()
                .compressed(toCompressed(text, codes))
                .decompressed(text)
                .codes(getCodesMap(codes))
                .build();

    }

    private Map<Character, String> getCodesMap(String[] codes) {

        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < codes.length; i++) {
            if (codes[i] != null) {
                map.put((char) i, codes[i]);
            }
        }
        return map;
    }

    private String toCompressed(String text, String[] codes) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            builder.append(codes[text.charAt(i)]);
        }

        return builder.toString();
    }

    private int[] getCharacterFrequency(String toCompress) {
        int[] counts = new int[256];
        for (int i = 0; i < toCompress.length(); i++) {
            counts[toCompress.charAt(i)]++;
        }
        return counts;
    }


    private void assignCode(HuffmanTreeNode root, String[] codes) {
        if (root.getLeft() != null) {
            root.getLeft().setCode(root.getCode() + "0");
            assignCode(root.getLeft(), codes);
            root.getRight().setCode(root.getCode() + "1");
            assignCode(root.getRight(), codes);
        } else {
            codes[root.getElement()] = root.getCode();
        }
    }


    private String[] getCodes(HuffmanTreeNode root) {
        if (root == null) {
            return null;
        }
        String[] codes = new String[256];
        assignCode(root, codes);
        return codes;
    }

    private HuffmanTree getHuffmanTree(int[] counts) {
        Heap<HuffmanTree> heap = new ArrayHeap<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                heap.add(new HuffmanTree((char) i, counts[i]));
            }
        }

        while (heap.getSize() > 1) {
            HuffmanTree t1 = heap.remove();
            HuffmanTree t2 = heap.remove();
            heap.add(new HuffmanTree(t1, t2));
        }

        return heap.remove();
    }

    public String decompress(HuffmanCompression compression) {
        String binary = compression.getCompressed();
        StringBuilder decompressed = new StringBuilder();

        while (binary.length() > 0) {
            for (Map.Entry<Character, String> entry : compression.getCodes().entrySet()) {
                if (binary.startsWith(entry.getValue())) {
                    binary = binary.substring(entry.getValue().length());
                    decompressed.append(entry.getKey());
                }
            }
        }
        return decompressed.toString();
    }

}
