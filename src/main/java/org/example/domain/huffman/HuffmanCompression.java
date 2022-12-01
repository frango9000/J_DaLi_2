package org.example.domain.huffman;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class HuffmanCompression implements Serializable {
    private static final long serialVersionUID = 1541134143517823239L;
    private final String compressed;
    private final HuffmanTree tree;
}
