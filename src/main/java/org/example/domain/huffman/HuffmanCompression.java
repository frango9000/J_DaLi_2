package org.example.domain.huffman;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class HuffmanCompression {
    private final String compressed;
    private final String decompressed;
    private final Map<Character, String> codes;
}
