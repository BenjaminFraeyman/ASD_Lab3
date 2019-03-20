/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ibcn.gso.labo3.filters;

import org.ibcn.gso.labo3.util.Pixel;
import org.ibcn.gso.labo3.util.Region;

/**
 *
 * @author Benjamin
 */
public class InvertFilter implements Filter{
    @Override
    public void apply(Pixel[][] pixels, Region region){
        // row : top to bottom
        for(int row = region.row; row < (region.row + region.height); row++){
            // column : left to right
            for (int column = region.col; column < (region.col + region.width); column++) {
                pixels[row][column].b = 255 - pixels[row][column].b;
                pixels[row][column].r = 255 - pixels[row][column].r;
                pixels[row][column].g = 255 - pixels[row][column].g;
            }
        }
    }
}
