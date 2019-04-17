package org.openguild.ai.q;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestQL {

    @Test
    public void fromOneToTen() {
        Scout scout = new Scout(2);
        scout.setFactor(new Factor(
                new int[][]{
                        new int[]{1, 10},
                        new int[]{2, 20},
                        new int[]{3, 30},
                        new int[]{4, 35},
                        new int[]{5, 34},
                        new int[]{6, 30},
                        new int[]{7, 20},
                        new int[]{8, 15},
                        new int[]{9, 14},
                        new int[]{10, 13}
                }));
        scout.explore();

        assertEquals(4, scout.getState());
    }

}