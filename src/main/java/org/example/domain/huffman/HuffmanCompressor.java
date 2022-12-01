package org.example.domain.huffman;

import org.example.domain.heap.ArrayHeap;
import org.example.domain.heap.Heap;

public class HuffmanCompressor {

    public HuffmanCompressor() {
    }

    public HuffmanCompression compress(String text) {
        int[] counts = _getCharacterFrequency(text);
        HuffmanTree tree = _getHuffmanTree(counts);
        String[] codes = _getCodes(tree.getRoot());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            builder.append(codes[text.charAt(i)]);
        }

        return HuffmanCompression.builder()
                .compressed(builder.toString())
                .tree(_getHuffmanTree(counts))
                .build();

    }

    public String decompress(HuffmanCompression compression) {
        String[] codes = _getCodes(compression.getTree().getRoot());
        return _decompress(compression.getCompressed(), codes);
    }

    private int[] _getCharacterFrequency(String toCompress) {
        int[] counts = new int[256];
        for (int i = 0; i < toCompress.length(); i++) {
            counts[toCompress.charAt(i)]++;
        }
        return counts;
    }


    private void _assignCode(HuffmanTreeNode root, String[] codes) {
        if (root.getLeft() != null) {
            root.getLeft().setCode(root.getCode() + "0");
            _assignCode(root.getLeft(), codes);
            root.getRight().setCode(root.getCode() + "1");
            _assignCode(root.getRight(), codes);
        } else {
            codes[root.getElement()] = root.getCode();
        }
    }


    private String[] _getCodes(HuffmanTreeNode root) {
        if (root == null) {
            return null;
        }
        String[] codes = new String[256];
        _assignCode(root, codes);
        return codes;
    }

    private HuffmanTree _getHuffmanTree(int[] counts) {
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


    private String _decompress(String binary, String[] codes) {
        StringBuilder decompressed = new StringBuilder();

        while (binary.length() > 0) {
            for (int i = 0; i < codes.length; i++) {
                if (codes[i] != null && binary.startsWith(codes[i])) {
                    binary = binary.substring(codes[i].length());
                    decompressed.append((char) i);
                }
            }
        }
        return decompressed.toString();
    }

}
