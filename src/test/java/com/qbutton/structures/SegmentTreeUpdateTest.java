package com.qbutton.structures;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SegmentTreeUpdateTest {
    private final int[] array = {-1,2,4,1,7,1,3,2};

    @Test
    public void updateRange_shouldWorkCorrectlyForSingleUpdate() {
        //given
        var segmentTree = new SegmentTree(array);

        //when
        segmentTree.incrementBy(3, 0, 3);
        SegmentTree.El foundMin = segmentTree.findMin(0, 3);

        //then
        //then
        assertThat(foundMin.val, is(2));
        assertThat(foundMin.idx, is(0));
    }

    @Test
    public void updateRange_shouldWorkCorrectlyForDoubleUpdate() {
        //given
        var segmentTree = new SegmentTree(array);

        //when
        segmentTree.incrementBy(3, 0, 3);
        segmentTree.incrementBy(1, 0, 3);
        SegmentTree.El foundMin = segmentTree.findMin(0, 3);

        //then
        //then
        assertThat(foundMin.val, is(3));
        assertThat(foundMin.idx, is(0));
    }

    @Test
    public void updateRange_shouldWorkCorrectlyForTripleUpdate1() {
        //given
        var segmentTree = new SegmentTree(array);

        //when
        //{6,6,8,5,7,1,3,2};
        segmentTree.incrementBy(3, 0, 3);
        segmentTree.incrementBy(1, 0, 3);
        segmentTree.incrementBy(3, 0, 0);
        SegmentTree.El foundMin = segmentTree.findMin(0, 3);

        //then
        //then
        assertThat(foundMin.val, is(5));
        assertThat(foundMin.idx, is(3));
    }

    @Test
    public void updateRange_shouldWorkCorrectlyForTripleUpdate2() {
        //given
        var segmentTree = new SegmentTree(array);

        //when
        //{6,6,8,5,7,1,3,2};
        segmentTree.incrementBy(3, 0, 3);
        segmentTree.incrementBy(1, 0, 3);
        segmentTree.incrementBy(3, 0, 0);
        SegmentTree.El foundMin = segmentTree.findMin(3, 5);

        //then
        //then
        assertThat(foundMin.val, is(1));
        assertThat(foundMin.idx, is(5));
    }
}
