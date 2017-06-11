/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myutil;

/**
 *
 * @author rollersimmer
 */
public class IntegerRange {
    
    public static int minMax(int val,int lo,int hi){
        int result=val;
        result=Math.min(val,hi);
        result=Math.max(result,lo);
        return result;
    }
}
