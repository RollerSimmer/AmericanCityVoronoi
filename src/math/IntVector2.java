/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rollersimmer
 */
public class IntVector2 {

    public static boolean IS_DEFAULT_DIST_TAXI=false;
    
    public int x;
    public int y;

    public IntVector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public IntVector2() {
        this.x=0;
        this.y=0;
    }

    public IntVector2(IntVector2 copy ){
        this.x=copy.x;
        this.y=copy.y;
    }
    
    public IntVector2 inc(IntVector2 other){
        x+=other.x;
        y+=other.y;
        return this;
    }
    
    public static IntVector2 add(IntVector2 a,IntVector2 b){
        return a.add(b);
    }
    
    public IntVector2 add(IntVector2 other){
        IntVector2 result=new IntVector2(this);
        result.inc(other);
        return result;
    }

    public IntVector2 dec(IntVector2 other){
        x-=other.x;
        y-=other.y;
        return this;
    }
    
    public IntVector2 sub(IntVector2 other){
        IntVector2 result=new IntVector2(this);
        result.dec(other);
        return result;
    }
    
    public static IntVector2 sub(IntVector2 a,IntVector2 b){
        return a.sub(b);
    }

    public Point2 div(int divisor) {
        Point2 result=new Point2(this);
        result.divEqu(divisor);
        return result;
    }
    
    /**
     * 
     * @return the estimated magnitude of the integer vector
     */

    public int mag(){
        int result=0;
        int ax=Math.abs(x);
        int ay=Math.abs(y);
        int M,m,mPart;
        if(ax>ay) { M=ax;m=ay; }
        else      { M=ay;m=ax; }
        result+=M;             
        mPart=(m<<7)+(m<<9);     // multiply by (512+128=640) (31.3% of 2048)
        mPart=mPart>>11;         // divide by 2048
        result+=mPart;
        return result;
    } 

//    public int mag(){
//        int result=0;
//        int ax=Math.abs(x);
//        int ay=Math.abs(y);
//        int M,m,mPart;
//        if(ax>ay) { M=ax;m=ay; }
//        else      { M=ay;m=ax; }
//        result+=M;             
//        mPart=m<<8;            // multiply by 256 (12.5% of 2048)
//        if((m<<1)<M){
//            // do nothing for now
//        }else{
//            mPart+=(m<<9);     // multiply by (512+256=768) (37.5% of 2048)
//        }
//        mPart=mPart>>11;         // divide by 2048
//        result+=mPart;
//        return result;
//    } 

    public int taxiMag() {
        int result=0;
        int ax=Math.abs(x);
        int ay=Math.abs(y);
        result=ax+ay;
        return result;
    }
    
    /**
     * 
     * @param a one point
     * @param b another point
     * @return the estimated distance between the two points
     */
    public static int dist(IntVector2 a,IntVector2 b){
        IntVector2 diff=IntVector2.sub(a,b);
        return diff.mag();
    }
    
    public static int taxiDist(IntVector2 a,IntVector2 b){
        IntVector2 diff=IntVector2.sub(a,b);
        return diff.taxiMag();
    }    
    
    public static int defaultDist(IntVector2 a,IntVector2 b){
        if(IS_DEFAULT_DIST_TAXI)
            return taxiDist(a,b);
        else
            return dist(a,b);
    }
    

    public void divEqu(int divisor) {
        x/=divisor;
        y/=divisor;
    }
    
    public void scale(int scaleFactor){
        x*=scaleFactor;
        y*=scaleFactor;
    }   
        
    public IntVector2 scaleCopy(int scaleFactor){
        IntVector2 result=new IntVector2(this);
        result.scale(scaleFactor);
        return result;
    }    

    public static IntVector2 scale(IntVector2 pos, int scaleFactor) {
        return pos.scaleCopy(scaleFactor);
    }
    
    @Override
    public String toString(){
        String result=String.format("(%d,%d)",x,y);
        return result;
    }
    
    public static void main(String args[]){
        int scalingFactor=100;
        for(int x=0;x<=10;x++){            
            for(int y=0;y<=10;y++){
                int xPrime=x*scalingFactor;
                int yPrime=y*scalingFactor;
                IntVector2 a=new IntVector2(xPrime,yPrime);
                int magnitude=a.mag();
                System.out.printf("xPrime=%d,yPrime=%d,mag=%d\t%d\t%d\t%d\n",xPrime,yPrime,magnitude,xPrime,yPrime,magnitude);
            }
        }
    }
}
