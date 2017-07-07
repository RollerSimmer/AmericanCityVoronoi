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
    
    public static IntVector2 getVector(Direction dir){
        switch(dir){
            case north:   
                return new IntVector2(0,1);
            case northeast:
                return new IntVector2(1,1);
            case southeast:
                return new IntVector2(1,-1);
            case south:
                return new IntVector2(0,-1);
            case southwest:
                return new IntVector2(-1,-1);
            case west:
                return new IntVector2(-1,0);
            case northwest:
                return new IntVector2(-1,1);
            case east   :
            default: 
                return new IntVector2(1,0);
        }
    }

    
    public static IntScale getVectorScale(Direction dir){
        switch(dir){
            case northeast:
            case southeast:
            case southwest:
            case northwest:
                return new IntScale(181,8);
            case north:   
            case east   :
            case south:
            case west:
            default:
                return new IntScale(1,0);
        }
    }
}
