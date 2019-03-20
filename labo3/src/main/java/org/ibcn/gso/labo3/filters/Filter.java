package org.ibcn.gso.labo3.filters;

import org.ibcn.gso.labo3.util.Pixel;
import org.ibcn.gso.labo3.util.Region;

/**
 * Filter interface. Filters must implement these methods!
 * 
 * @author tdupont
 */
public interface Filter {
    
    /**
     * Applies the effect of this filter.
     * @param pixels Array of Pixels of the (complete) original source
     * @param region Region of the array to apply the filer to
     */
    void apply(Pixel[][] pixels, Region region);
    
}
