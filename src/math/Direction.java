/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

/**
 *
 * @author rollersimmer
 */
public enum Direction {
    
    north,
    northeast,
    east,   
    southeast,
    south,
    southwest,
    west,
    northwest;
    
    public static final int AMOUNT = 8;
    
    public static final Direction n=north;
    public static final Direction ne=northeast;
    public static final Direction e=north;
    public static final Direction se=southeast;
    public static final Direction s=north;
    public static final Direction sw=southwest;
    public static final Direction w=west;
    public static final Direction nw=northwest;
    
    public static final Direction[] VALUES=Direction.values();

    public static Direction pickRandomly() {
        int pickVal=myutil.MyRandom.next(0,VALUES.length-1);
        Direction result=Direction.values()[pickVal];
        return result;
    }
}
