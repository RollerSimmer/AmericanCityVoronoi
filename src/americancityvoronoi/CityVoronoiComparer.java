/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this temp``late file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import math.IntVector2;

/**
 *
 * @author rollersimmer
 */
public class CityVoronoiComparer {
    
    public static boolean SHOULD_REACH_PLAY_A_FACTOR=false;    
    
    /**
     * 
     * @param a one city
     * @param b another city
     * @param pt the point to which the two cities are compared for closeness to that point
     * @return if a reaches the point more easily than b, a positive value; if both reach with equal ease, zero; else, a negative value
     */
    public static int compareClosenessToPoint(City a,City b,IntVector2 pt){
        final int precisionScale=10;
        int aDist=IntVector2.defaultDist(a.pos.mul(precisionScale),pt.mul(precisionScale));
        int bDist=IntVector2.defaultDist(b.pos.mul(precisionScale),pt.mul(precisionScale));
        int result=Integer.MAX_VALUE;
        if(SHOULD_REACH_PLAY_A_FACTOR) {
            int adjustedADist=aDist*b.reach;
            int adjustedBDist=bDist*a.reach;        
            result=adjustedBDist-adjustedADist;
        } else {        
            result=bDist-aDist;
        }
        return result;
    }    

    static boolean isPointMoreReachable(City candidate, City other, IntVector2 compPoint) {
        if(candidate==null) 
            return false;
        if(other==null && candidate!=null)
            return true;
        int closenessComparison = compareClosenessToPoint(candidate,other,compPoint);
        boolean result=closenessComparison>0;
        return result;        
    }
}
