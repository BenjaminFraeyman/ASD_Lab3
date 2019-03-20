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
public class HMirrorFilter implements Filter{
    @Override
    public void apply(Pixel[][] pixels, Region region){
        int mirroredColumn = region.col + region.width - 1;
        
        for(int row = region.row;row < (region.row + region.height); row++){
            for (int column = region.col; column < mirroredColumn; column++) {
                int tempRedValue = pixels[row][column].r;
                int tempGreenValue = pixels[row][column].g;
                int tempBlueValue = pixels[row][column].b;
                
                pixels[row][column].b = pixels[row][mirroredColumn].b;
                pixels[row][column].r = pixels[row][mirroredColumn].r;
                pixels[row][column].g = pixels[row][mirroredColumn].g;
                
                pixels[row][mirroredColumn].b = tempBlueValue;
                pixels[row][mirroredColumn].r = tempRedValue;
                pixels[row][mirroredColumn].g = tempGreenValue;

                mirroredColumn--;
            }
            mirroredColumn = region.col + region.width - 1;
        }
    }  
}