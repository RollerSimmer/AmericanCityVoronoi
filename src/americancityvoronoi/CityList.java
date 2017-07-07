/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.util.ArrayList;
import java.util.Collections;
import math.IntVector2;
import myutil.MyRandom;

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
    
    public CityList(){
        maxs=new IntVector2(Integer.MIN_VALUE,Integer.MIN_VALUE);
        mins=new IntVector2(Integer.MAX_VALUE,Integer.MAX_VALUE);        
    }

    public CityList(City initialCity) {
        this();
        if(initialCity!=null)
            this.add(initialCity);
    }
    
    public CityList(CityList copy){
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

    public void print() {
        System.out.print(this.toString());
    }
    
    public void sortByPopulation(){
        Collections.sort(this,POP_COMP);
    }   
    
    public void makeCityColorsUnique(){
        int amtPasses=3;
        for(int pass=0;pass<amtPasses;pass++){
            for(City c:this){
                c.makeColorUniqueFromNeighbors();
            }
        }
    }
        
    @Override
    public String toString(){
        String result="";
        result+="CityList:\n";
        result+=String.format("listSize=%d\n",size());
        int i=0;
        for(City c:this){
            result+=c.toString();
            result+="\n";
        }
        return result;
    }    
    
    public String toSingleLineString(){
        String result="(";
        for(int i=0;i<size();i++){
            result+=get(i).toShortString();
            if(i+1<size())
                result+=",";
        }
        result+=")";
        return result;
    }

    private int calcRandomIndex() {
        int hi=size()-1;
        int lo=0;
        int result = MyRandom.next(lo,hi);
        return result;
    }

    private int calcBellRandomIndex() {
        int hi=size()-1;
        int lo=-hi;
        int amtSamples=3;
        int result = Math.abs(MyRandom.nextBell(lo,hi,amtSamples));
        return result;
    }

    City getRandom() {
        if(size()==0)
            return null;
        int pickIndex=calcRandomIndex();
        City result=get(pickIndex);
        return result;
    }

    City getBellRandom() {
        if(size()==0)
            return null;
        int pickIndex=calcBellRandomIndex();
        City result=get(pickIndex);
        return result;
    }

    City popBellRandom() {
        if(size()==0)
            return null;
        int pickIndex=calcBellRandomIndex();
        City result=get(pickIndex);
        remove(pickIndex);
        return result;
    }

    void clearRegionDrawnFlags() {
        for(City c: this){
            if(c==null) continue;
            c.hasBeenDrawnInActiveRegion=false;
        }
    }
    
    int countDrawnCities(){
        int result=0;
        for(City c:this){
            if(c.hasBeenDrawnInActiveRegion)
                result++;
        }
        return result;
    }

    City popAt(int index) {
        City result=null;
        if( index>=0 && index<size() ){
            result=get(index);
            remove(index);
        }
        return result;
    }

    City findLargest() {
        City result=null;
        int highPop=Integer.MIN_VALUE;
        for(City c:this){
            if(c.pop100k>highPop){
                highPop=c.pop100k;
                result=c;
            }
        }
        return result;
    }
}
