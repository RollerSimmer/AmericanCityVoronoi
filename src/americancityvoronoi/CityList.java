/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.util.ArrayList;
import java.util.Collections;
import math.IntVector2;

/**
 *
 * @author rollersimmer
 */
public class CityList extends ArrayList<City> {
    
    private static final CityPopulationComparator POP_COMP=new CityPopulationComparator();
    
    private IntVector2 mins;
    private IntVector2 maxs;

    public IntVector2 getMins() {
        return mins;
    }

    public IntVector2 getMaxs() {
        return maxs;
    }
    
    CityList(){
        maxs=new IntVector2(Integer.MIN_VALUE,Integer.MIN_VALUE);
        mins=new IntVector2(Integer.MAX_VALUE,Integer.MAX_VALUE);        
    }
    
    CityList(CityList copy){
        this();
        for(City c:copy){
            this.add(c);
        }
    }
    
    @Override
    public boolean add(City c){
        if(this.contains(c))
            return false;
        boolean result=super.add(c);
        updateMinMaxAfterCityAddition(c);        
        return result;
    }
    
    public boolean remove(City c){
        if(!this.contains(c))
            return false;
        updateMinMaxAfterCityRemoval(c);        
        boolean result=super.remove(c);
        return result;
    }

    private void updateMinMaxAfterCityAddition(City c) {
        if(c.pos.x>maxs.x) 
            maxs.x=c.pos.x;
        if(c.pos.y>maxs.y) 
            maxs.y=c.pos.y;
        if(c.pos.x<mins.x) 
            mins.x=c.pos.x;
        if(c.pos.y<mins.y) 
            mins.y=c.pos.y;
    }

    private void updateMinMaxAfterCityRemoval(City c) {
        if(c.pos.x==maxs.x||c.pos.y==maxs.y||c.pos.x==mins.x||c.pos.y==mins.y)
            findMinMaxInEntireList();            
    }

    private void findMinMaxInEntireList() {
        for(City c:this){
            updateMinMaxAfterCityAddition(c);
        }
    }
  
    public City popFront(){
        if(size()==0) 
            return null;
        City result=get(0);
        this.remove(0);
        return result;
    }

    void print() {
        System.out.print(this.toString());
    }
    
    void sortByPopulation(){
        Collections.sort(this,POP_COMP);
    }   
        
    @Override
    public String toString(){
        String result="";
        result+="CityList:\n";
        int i=0;
        for(City c:this){
            result+=c.toString();
            result+="\n";
        }
        return result;
    }    
}
