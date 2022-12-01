package org.example.domain.huffman;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data()
@NoArgsConstructor
public class HuffmanTreeNode implements Serializable {
    private static final long serialVersionUID = -116604258492025539L;
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
