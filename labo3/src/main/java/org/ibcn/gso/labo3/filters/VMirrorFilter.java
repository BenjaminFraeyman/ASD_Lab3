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
public class VMirrorFilter implements Filter{
    @Override
    public void apply(Pixel[][] pixels, Region region){
        int mirroredRow = region.row + region.height - 1;
        
        for(int row = region.row; row < mirroredRow; row++){
            for (int column = region.col; column < (region.col + region.width); column++) {
                int tempRedValue = pixels[row][column].r;
                int tempGreenValue = pixels[row][column].g;
                int tempBlueValue = pixels[row][column].b;
                
                pixels[row][column].b = pixels[mirroredRow][column].b;
                pixels[row][column].r = pixels[mirroredRow][column].r;
                pixels[row][column].g = pixels[mirroredRow][column].g;
                
                pixels[mirroredRow][column].b = tempBlueValue;
                pixels[mirroredRow][column].r = tempRedValue;
                pixels[mirroredRow][column].g = tempGreenValue;
            }
            mirroredRow--;
        }
    }  
}
