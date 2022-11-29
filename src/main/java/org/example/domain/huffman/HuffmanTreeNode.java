package org.example.domain.huffman;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data()
@NoArgsConstructor
public class HuffmanTreeNode {
    private char element;
    private int weight;
    private HuffmanTreeNode left;
    private HuffmanTreeNode right;
    private String code = "";

    public HuffmanTreeNode(char element, int weight) {
        this.element = element;
        this.weight = weight;
    }
}
