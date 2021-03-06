/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ibcn.gso.labo3.commands;
import org.ibcn.gso.labo3.filters.Filter;
import org.ibcn.gso.labo3.filters.InvertFilter;
import org.ibcn.gso.labo3.util.Pixel;
import org.ibcn.gso.labo3.util.Region;

/**
 *
 * @author Benjamin
 */
public class InvertCommand implements Command {

    private final Pixel[][] pixels;
    private final Region region;
    
    public InvertCommand(Pixel[][] pixels, Region region) {
        this.pixels = pixels;
        this.region = region;
    }
    
    private final Filter filter = new InvertFilter();
    
    @Override
    public void execute() {
        filter.apply(pixels, region);
    }

    @Override
    public void undo() {
        filter.apply(pixels, region);
    }
    
}
