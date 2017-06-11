/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.util.HashMap;
import math.Point2;

/**
 *
 * @author rollersimmer
 */
public class CityMap extends HashMap<Point2,CityList> {
    
    public static int TILE_SIZE=50;
    
    CityMap(CityList clBase){
        for(City c:clBase){
            Point2 p=new Point2(c.pos);
            p.divEqu(TILE_SIZE);
            if(this.containsKey(p)){
                this.get(p).add(c);
            } else {
                this.put(p,new CityList(c));
            }
        }
    }
}
