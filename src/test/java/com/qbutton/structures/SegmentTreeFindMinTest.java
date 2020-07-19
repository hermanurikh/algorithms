package com.qbutton.structures;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SegmentTreeFindMinTest {

    private final int[] array = {1,0,3,-5,4,6,2};

    private final int from;
    private final int to;
    private final int minVal;
    private final int minIdx;

    public SegmentTreeFindMinTest(int from, int to, int minVal, int minIdx) {
        this.from = from;
        this.to = to;
        this.minVal = minVal;
        this.minIdx = minIdx;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> inputData() {
        return Arrays.asList(new Object[][] {
                {0,0,1,0},
                {1,1,0,1},
                {2,2,3,2},
                {3,3,-5,3},
                {4,4,4,4},
                {5,5,6,5},
                {6,6,2,6},
                {0,1,0,1},
                {0,2,0,1},
                {0,3,-5,3},
                {0,4,-5,3},
                {0,5,-5,3},
                {0,6,-5,3},
                {2,3,-5,3},
                {4,5,4,4},
                {4,6,2,6}
        });
    }

    @Test
    public void findMin_shouldPickMinCorrectly1() {
        //given
        var segmentTree = new SegmentTree(array);

        //when
        SegmentTree.El foundMin = segmentTree.findMin(from, to);

        //then
        assertThat(foundMin.val, is(minVal));
        assertThat(foundMin.idx, is(minIdx));
    }
}