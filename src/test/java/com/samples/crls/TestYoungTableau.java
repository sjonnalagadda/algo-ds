package com.samples.crls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestYoungTableau {

    @Test
    public void testExtractMinYoungTableau() {
        YoungTableau youngTableau = new YoungTableau(3,3);
        youngTableau.feedData(0, 0, 2);
        youngTableau.feedData(0, 1, 3);
        youngTableau.feedData(0, 2, 4);

        youngTableau.feedData(1, 0, 5);
        youngTableau.feedData(1, 1, 8);
        youngTableau.feedData(1, 2, 9);

        youngTableau.feedData(2, 0, 12);
        youngTableau.feedData(2, 1, 14);
        youngTableau.feedData(2, 2, 16);

        Assertions.assertEquals(2, youngTableau.extractMin());
        Assertions.assertEquals(3, youngTableau.extractMin());
        Assertions.assertEquals(4, youngTableau.extractMin());

        Assertions.assertEquals(5, youngTableau.extractMin());
        Assertions.assertEquals(8, youngTableau.extractMin());
        Assertions.assertEquals(9, youngTableau.extractMin());

        Assertions.assertEquals(12, youngTableau.extractMin());
        Assertions.assertEquals(14, youngTableau.extractMin());
        Assertions.assertEquals(16, youngTableau.extractMin());
    }
}
