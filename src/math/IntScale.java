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
public class IntScale {
    /** 
     * numerator - values get multiplied by this first
     */
    public int num;
    /**
     * denominator - multiplied values get divided by this second
     */
    public int denomShift;
    
    public IntScale(int num,int denomShift){
        this.num=num;
        this.denomShift=denomShift;
    }
    
    /**
     * 
     * @param val the value to scale
     * @param scale the scaling factor
     * @return the scaled value
     */
    
    public static int scaleBy(int val,IntScale scale){
        if(scale.num==(1<<scale.denomShift))
            return val;
        int result=(val*scale.num)>>scale.denomShift;
        return result;
    }
}
