package org.example.domain.huffman;

import lombok.Data;

@Data
public class HuffmanTree implements Comparable<HuffmanTree> {
    private HuffmanTreeNode root;

    public HuffmanTree(char element, int weight) {
        root = new HuffmanTreeNode(element, weight);
    }

    public HuffmanTree(HuffmanTree t1, HuffmanTree t2) {
        root = new HuffmanTreeNode();
        root.setLeft(t1.root);
        root.setRight(t2.root);
        root.setWeight(t1.root.getWeight() + t2.root.getWeight());
    }

    @Override
    public int compareTo(HuffmanTree o) {
        return Integer.compare(o.root.getWeight(), root.getWeight());
    }
}
