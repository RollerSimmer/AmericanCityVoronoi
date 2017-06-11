/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myutil;

import java.util.Random;

/**
 * A custom random integer generator class
 * @author RollerSimmer
 */
public class MyRandom 
    {
    private static MyRandom instance=null;

    Random rand;
    
    protected MyRandom()
        {
        rand=new Random();
        }
    
    public static MyRandom getinstance()
        {
        if(instance==null)
            instance=new MyRandom();
        return instance;        
        }
    
    /**
     * Generate a random integer value in a range
     * @param lo the minimum of the range set
     * @param hi the maximum of the range set
     * @return the random value
     */
    public static int next(int lo, int hi)
        {
        if(hi<lo) return next(hi,lo);
        int n=getinstance().rand.nextInt(hi-lo+1)+lo;
        return n;
        }

    /**
     * 
     * @param chancePct the percent chance that this will return true
     * @return true or false randomly based on the percent chance
     */
    public static boolean pctChance(int chancePct) {
        return (next(1,100)<=chancePct);
    }

    /**
     * Generate a normally-distributed random integer value in a range
     * @param lo the minimum of the range set
     * @param hi the maximum of the range set
     * @param amtBellSamples the number of random samples to average
     * @return the random value
     */
    public static int nextBell(int lo, int hi, int amtBellSamples) {
        int sum=0;
        for(int i=0;i<amtBellSamples;i++){
            sum+=next(lo,hi);            
        }
        int result=sum/amtBellSamples;
        return result;
    }

    public static int nextBell(int lo, int hi) {
        final int DEFAULT_AMT_BELL_SAMPLES=3;
        return nextBell(lo,hi,DEFAULT_AMT_BELL_SAMPLES);
    }

    /**
     * Generate a random letter
     * @return either an uppercase or lowercase letter
     */
    public static char nextLetterOrSpace()
        {
        char nls;
        if(next(1,6)==1)
            nls=' ';
        else
            nls = next(0,1)==1? (char)next((int)'A',(int)'Z')
                              : (char)next((int)'a',(int)'z');
        return nls;
        }

    }
