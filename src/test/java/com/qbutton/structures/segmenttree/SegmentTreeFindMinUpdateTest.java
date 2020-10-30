package com.qbutton.structures.segmenttree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SegmentTreeFindMinUpdateTest {
    private final int[] array = {-1,2,4,1,7,1,3,2};
    private final int[] zeroArray = {0,0,0,0};

    @Test
    public void updateRange_shouldWorkCorrectlyForZeroArraySingleUpdate() {
        //given
        var segmentTree = new SegmentTreeFindMin(zeroArray);

        //when
        segmentTree.incrementBy(1, 0, 1);
        int foundMin1 = segmentTree.findMin(0, 0);
        int foundMin2 = segmentTree.findMin(1, 1);

        //then
        assertThat(foundMin1, is(1));
        assertThat(foundMin2, is(1));
    }

    @Test
    public void updateRange_shouldWorkCorrectlyForZeroArrayMultipleUpdates() {
        //given
        var segmentTree = new SegmentTreeFindMin(zeroArray);

        //when
        segmentTree.incrementBy(1, 1, 3);
        segmentTree.incrementBy(1, 0, 1);
        int foundMin1 = segmentTree.findMin(0, 0);
        int foundMin2 = segmentTree.findMin(1, 1);
        int foundMin3 = segmentTree.findMin(2, 2);
        int foundMin4 = segmentTree.findMin(3, 3);

        //then
        assertThat(foundMin1, is(1));
        assertThat(foundMin2, is(2));
        assertThat(foundMin3, is(1));
        assertThat(foundMin4, is(1));
    }

    @Test
    public void updateRange_shouldWorkCorrectlyForSingleUpdate() {
        //given
        var segmentTree = new SegmentTreeFindMin(array);

        //when
        segmentTree.incrementBy(3, 0, 3);
        int foundMin = segmentTree.findMin(0, 3);

        //then
        //then
        assertThat(foundMin, is(2));
    }

    @Test
    public void updateRange_shouldWorkCorrectlyForDoubleUpdate() {
        //given
        var segmentTree = new SegmentTreeFindMin(array);

        //when
        segmentTree.incrementBy(3, 0, 3);
        segmentTree.incrementBy(1, 0, 3);
        int foundMin = segmentTree.findMin(0, 3);

        //then
        //then
        assertThat(foundMin, is(3));
    }

    @Test
    public void updateRange_shouldWorkCorrectlyForTripleUpdate1() {
        //given
        var segmentTree = new SegmentTreeFindMin(array);

        //when
        //{6,6,8,5,7,1,3,2};
        segmentTree.incrementBy(3, 0, 3);
        segmentTree.incrementBy(1, 0, 3);
        segmentTree.incrementBy(3, 0, 0);
        int foundMin = segmentTree.findMin(0, 3);

        //then
        //then
        assertThat(foundMin, is(5));
    }

    @Test
    public void updateRange_shouldWorkCorrectlyForTripleUpdate2() {
        //given
        var segmentTree = new SegmentTreeFindMin(array);

        //when
        //{6,6,8,5,7,1,3,2};
        segmentTree.incrementBy(3, 0, 3);
        segmentTree.incrementBy(1, 0, 3);
        segmentTree.incrementBy(3, 0, 0);
        int foundMin = segmentTree.findMin(3, 5);

        //then
        //then
        assertThat(foundMin, is(1));
    }
}
