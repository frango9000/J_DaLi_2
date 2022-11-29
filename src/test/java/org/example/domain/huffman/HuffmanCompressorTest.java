package org.example.domain.huffman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HuffmanCompressorTest {

    @Test
    void should_compress_a_string() {
        String toCompress = "Wait a minute, Doc. What are you talking about? What happens to us in the future? What do we become assholes or something?";
        HuffmanCompressor compressor = new HuffmanCompressor();
        HuffmanCompression compression = compressor.compress(toCompress);

        String decompressed = compressor.decompress(compression);

        assertEquals(decompressed, toCompress);
    }

}
