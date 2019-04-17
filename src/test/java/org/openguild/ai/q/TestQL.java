package org.openguild.ai.q;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestQL {

    @Test
    public void fromOneToTen() {
        Scout scout = new Scout();
        MappingFunctionExploreable exploreable = new MappingFunctionExploreable(
                "A",
                "B"
        );
        exploreable.setState("A", 2);
        exploreable.setState("B", 600);

        exploreable.addData("A",  1, 10);
        exploreable.addData("A",  2, 20);
        exploreable.addData("A",  3, 30);
        exploreable.addData("A",  4, 35);
        exploreable.addData("A",  5, 34);
        exploreable.addData("A",  6, 30);
        exploreable.addData("A",  7, 20);
        exploreable.addData("A",  8, 15);
        exploreable.addData("A",  9, 14);
        exploreable.addData("A",  10, 13);

        exploreable.addData("B", 599, 9);
        exploreable.addData("B", 600, 10);
        exploreable.addData("B", 601, 11);
        exploreable.addData("B", 602, 14);
        exploreable.addData("B", 603, 13);

        scout.setExploreable(exploreable);
        scout.explore();

        assertEquals(4, exploreable.getState("A"));
        assertEquals(602, exploreable.getState("B"));
        assertEquals(35 * 14, exploreable.getOutput());
    }

}