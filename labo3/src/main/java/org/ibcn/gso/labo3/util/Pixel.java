package org.ibcn.gso.labo3.util;

/**
 * Simple utility class that stores the RGB values of a pixel.
 *
 * @author tdupont
 */
public class Pixel {
    /* Red channel */
    public int r;
    /* Green channel */
    public int g;
    /* Blue channel */
    public int b;

    public Pixel(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
