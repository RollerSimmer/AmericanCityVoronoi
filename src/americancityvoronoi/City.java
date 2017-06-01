/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import math.IntVector2;
import myutil.MyColorFactory;
import myutil.MyColor;

/**
 *
 * @author rollersimmer
 */
public class City {
    public static final int CITY_COLOR_LIGHT=800;  // out of 1000
    public String name;
    public IntVector2 pos;
    public int reach;
    public int pop100k;
    MyColor color;
    
    public City(String name,IntVector2 pos,int reach,int pop100k){
        this.name=name;
        this.pos=pos;
        this.reach=reach;
        this.pop100k=pop100k;
        
        color=MyColorFactory.createRandomly(CITY_COLOR_LIGHT);
    }    
    
    @Override
    public String toString(){
        String result=String.format("City: { name=\"%s\", pos=%s, reach=%d, pop100k=%d, color=%s }",
                        name,pos.toString(),reach,pop100k,color.toString());
        return result;
    }
}
