package org.ibcn.gso.labo3.util;

/**
 * Class to easily represent a region on an image to apply a filter to.
 *
 * @author tdupont
 */
public class Region {
    /* row index */
    public int row;
    /* column index */
    public int col;
    /* width of the region */
    public int width;
    /* height of the region */
    public int height;

    public Region(int row, int col, int width, int height) {
        this.row = row;
        this.col = col;
        this.width = width;
        this.height = height;
    }
}
