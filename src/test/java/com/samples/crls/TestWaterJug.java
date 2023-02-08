package com.samples.crls;

import org.junit.jupiter.api.Test;

public class TestWaterJug {

    @Test
    public void testGroupingOfJugs() {
        Jug[] jugs = {new Jug(1, 'B'),
                new Jug(3, 'B'),
                new Jug(1, 'R'),
                new Jug(2, 'R'),
                new Jug(2, 'B'),
                new Jug(3, 'R'),
        };
        WaterJug.groupJugs(jugs);
        System.out.println("Wait");
    }
}
