/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myutil;

import americancityvoronoi.CityRegion;
import java.util.ArrayList;

/**
 *
 * @author rollersimmer
 */
public class IntBounds {
    /** maximum **/
    public int max;
    /** minimum **/
    public int min;
    /** average **/
    public int avg;
    /** deviation **/
    public int dev;
    /** span **/
    public int span;

    public IntBounds() {
        this.max=Integer.MIN_VALUE;
        this.min=Integer.MAX_VALUE;
        this.avg=0;
        this.dev=0;
    }    

    public IntBounds(ArrayList<Integer> valList) {
        this();
        if(valList==null||valList.size()==0)
            return;
        // find min,max,avg
        for(Integer val:valList) {
            avg+=val;
            min=Math.min(val,min);
            max=Math.max(val,max);
        }
        avg/=valList.size();
        // find dev and bal
        dev=0;
        for(Integer val:valList) {
            dev+=Math.abs(val-avg);
        }
        int listSz=valList.size();
        dev/=listSz;
        span=calcSpan();
    }

    public int calcSpan() {
        return Math.abs(max-min);
    }    
}
