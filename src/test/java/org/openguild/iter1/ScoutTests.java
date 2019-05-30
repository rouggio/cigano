package org.openguild.iter1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ScoutTests {

    @Test
    public void simpleSearch() {
        Scout scout = new Scout();

        MappingFunctionExplorable explorable = new MappingFunctionExplorable(
                "A",
                "B"
        );
        explorable.setState("A", 2);
        explorable.setState("B", 600);

        explorable.addData("A", 1, 10);
        explorable.addData("A", 2, 20);
        explorable.addData("A", 3, 30);
        explorable.addData("A", 4, 35);
        explorable.addData("A", 5, 34);
        explorable.addData("A", 6, 30);
        explorable.addData("A", 7, 20);
        explorable.addData("A", 8, 15);
        explorable.addData("A", 9, 14);
        explorable.addData("A", 10, 13);

        explorable.addData("B", 599, 9);
        explorable.addData("B", 600, 10);
        explorable.addData("B", 601, 11);
        explorable.addData("B", 602, 14);
        explorable.addData("B", 603, 13);

        scout.setExplorable(explorable);
        scout.explore();

        assertEquals(4, explorable.getState("A"));
        assertEquals(602, explorable.getState("B"));
        assertEquals(35 * 14, explorable.getOutput());
    }

}