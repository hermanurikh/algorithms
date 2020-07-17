package com.qbutton.structures;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SegmentTreeTest {

    private final int[] array = {1,0,3,-5,4,6,2};

    private final int from;
    private final int to;
    private final int min;

    public SegmentTreeTest(int from, int to, int min) {
        this.from = from;
        this.to = to;
        this.min = min;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> inputData() {
        return Arrays.asList(new Object[][] {
                {0,0,1},
                {1,1,0},
                {2,2,3},
                {3,3,-5},
                {4,4,4},
                {5,5,6},
                {6,6,2},
                {0,1,0},
                {0,2,0},
                {0,3,-5},
                {0,4,-5},
                {0,5,-5},
                {0,6,-5},
                {2,3,-5},
                {4,5,4},
                {4,6,2}
        });
    }

    @Test
    public void findMin_shouldPickMinCorrectly1() {
        //given
        var segmentTree = new SegmentTree(array);

        //when
        var foundMin = segmentTree.findMin(from, to);

        //then
        assertThat(foundMin, is(min));
    }
}