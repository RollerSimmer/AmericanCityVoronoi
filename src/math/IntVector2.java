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
    public static boolean IS_DEFAULT_DIST_OCTAGON_OTHERWISE=true;

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
    
    public void mulEqu(int factor){
        x*=factor;
        y*=factor;
    }
    
    public Point2 mul(int factor){
        Point2 result=new Point2(this);
        result.mulEqu(factor);
        return result;
    }
    
    public int defaultMag() {
        if(IS_DEFAULT_DIST_TAXI)
            return taxiMag();
        else if(IS_DEFAULT_DIST_OCTAGON_OTHERWISE)
            return octagonMag();
        else
            return pythagoreanMag();
    }
        
    public static int defaultDist(IntVector2 a,IntVector2 b){
        IntVector2 displacement=IntVector2.sub(a,b);
        return displacement.defaultMag();
    }
    
    /**
     * 
     * @return the estimated magnitude of the integer vector
     */
    
    public int pythagoreanMag(){
        int resultSquared=x*x + y*y;
        int result=0;
        try{
            result=MyMath.intSqrt(resultSquared);
        }catch(Exception ex){
            System.err.println(ex.toString());
        }
        return result;
    }

    public int octagonMag(){
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

    public static int dotProduct(IntVector2 a, IntVector2 b, IntScale vectorScale) {
        int dot=a.x*b.x + a.y*b.y;
        int result = IntScale.scaleBy(dot,vectorScale);
        return result;
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
                int magnitude=a.pythagoreanMag();
                System.out.printf("xPrime=%d,yPrime=%d,mag=%d\t%d\t%d\t%d\n",xPrime,yPrime,magnitude,xPrime,yPrime,magnitude);
            }
        }
    }

    
}
