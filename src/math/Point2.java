/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.util.HashMap;

/**
 *
 * @author rollersimmer
 */
public class Point2 extends IntVector2 {
    
    public static final Point2 ZERO=new Point2(0,0);    
    
    public Point2(int x,int y){ super(x,y); }   
    
    public Point2(){ super(); }

    public Point2(Point2 copy) { super(copy.x,copy.y);  }

    public Point2(IntVector2 iv) { super(iv); }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!IntVector2.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final IntVector2 other = (IntVector2) obj;
        return x==other.x && y==other.y;
    }

    @Override
    public int hashCode(){
        return ((y&0xffff)<<16)|x&0xffff;
    }
    
    public static void main(String[] args){
        Point2 a=new Point2(0,0);        
        Point2 b=new Point2(0,0);        
        boolean aeb=a.equals(b);
        int aHash=a.hashCode();
        int bHash=b.hashCode();
        HashMap<Point2,Integer> map=new HashMap<>();
        map.put(a,1);
        if(!map.containsKey(b))
            map.put(b,2);
        
        System.out.println("Done");
    }    

}
