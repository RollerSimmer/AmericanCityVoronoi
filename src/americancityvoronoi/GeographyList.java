/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.util.ArrayList;

/**
 *
 * @author rollersimmer
 */
public class GeographyList extends ArrayList<GeographicRegion> {
    
    public GeographyList() { super(); }
    
    public void scaleAll(int scalingFactor){
        for(GeographicRegion r:this){
            r.scaleAll(scalingFactor);
        }
    }      
}

