/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myutil;

import java.awt.Color;

/**
 *
 * @author rollersimmer
 */
public class MyColor extends Color {

    public static Color makeTransparent(Color c, int num,int denom) {
        MyColor result=new MyColor(c);
        result.scaleAlpha(num,denom);
        return result;
    }
    
    public static int MIN_CLOSENESS = 25;
    
    public static boolean areColorsTooClose(MyColor c, MyColor other) {
        int taxiDist=MyColor.calcTaxiDist(c,other);
        boolean result=taxiDist>MIN_CLOSENESS;
        return result;
    }

    public static int calcTaxiDist(MyColor c, MyColor other) {
        int result=0;
        result+=Math.abs(c.getRed()-other.getRed());
        result+=Math.abs(c.getGreen()-other.getGreen());
        result+=Math.abs(c.getBlue()-other.getBlue());
        result+=Math.abs(c.getAlpha()-other.getAlpha());
        return result;
    }
    public MyColor(Color c){
        super(c.getRed(),c.getGreen(),c.getBlue(),c.getAlpha());
    }
    
    public MyColor(int r, int g, int b) {
        super(r, g, b);
    }

    public MyColor(int r, int g, int b, int a) {
        super(r,g,b,a);
    }
    
    public static MyColor avg(Color ca,Color cb){
        int r=(ca.getRed()+cb.getRed())/2;
        int g=(ca.getGreen()+cb.getGreen())/2;
        int b=(ca.getBlue()+cb.getBlue())/2;
        return new MyColor(r,g,b);
    }    
    
    public MyColor brighter(){
        Color b=super.brighter();
        return new MyColor(b.getRed(),b.getGreen(),b.getRed(),b.getAlpha());
    }
    
    public MyColor somewhatBrighter(){
        MyColor b=new MyColor(brighter());
        MyColor result=MyColor.avg(b,this);
        return result;
    }    

    public Color scaleAlpha(int num, int denom) {
        int a=getAlpha();
        a*=num;
        a+=Math.max(denom-1,0);
        a/=denom;
        a=Math.min(a,255);
        return new Color(getRed(),getGreen(),getBlue(),a);        
    }
    
    public static boolean isTooCloseToAnotherInList(MyColor c, MyColorList colors){
        boolean result=false;
        int dist=calcDistFromListMembers(c,colors);
        result=dist<MIN_CLOSENESS;
        return result;
    }
    
    public static int calcDistFromListMembers(MyColor c, MyColorList colors) {
        int result=Integer.MAX_VALUE;
        for(MyColor other:colors){
            int dist=MyColor.calcTaxiDist(c,other);
            if(dist<result)
                result=dist;
        }
        return result;
    }
    
    @Override
    public String toString(){
        String result="(";
        result+=Integer.toString(getRed());
        result+=",";
        result+=Integer.toString(getGreen());
        result+=",";
        result+=Integer.toString(getBlue());
        result+=",";
        result+=Integer.toString(getAlpha());
        result+=")";
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if(!MyColor.class.isAssignableFrom(o.getClass()))
            return false;
        MyColor c=(MyColor)o;
        if(c.getRed()!=getRed())
            return false;
        if(c.getGreen()!=getGreen())
            return false;
        if(c.getBlue()!=getBlue())
            return false;
        if(c.getAlpha()!=getAlpha())
            return false;
        return true;
    }

    
    
}
