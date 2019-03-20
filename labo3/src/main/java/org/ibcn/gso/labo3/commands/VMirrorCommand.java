/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ibcn.gso.labo3.commands;
import org.ibcn.gso.labo3.filters.Filter;
import org.ibcn.gso.labo3.util.Pixel;
import org.ibcn.gso.labo3.util.Region;
import org.ibcn.gso.labo3.filters.VMirrorFilter;

/**
 *
 * @author Benjamin
 */
public class VMirrorCommand implements Command{
    private final Pixel[][] pixels;
    private final Region region;
    
    public VMirrorCommand(Pixel[][] pixels, Region region) {
        this.pixels = pixels;
        this.region = region;
    }

    private final Filter filter = new VMirrorFilter();
    
    @Override
    public void execute() {
        filter.apply(pixels, region);
    }

    @Override
    public void undo() {
        filter.apply(pixels, region);
    }
    
}
