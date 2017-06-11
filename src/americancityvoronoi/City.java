/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.util.HashMap;
import math.Direction;
import math.Point2;
import myutil.MyColorFactory;
import myutil.MyColor;
import myutil.MyColorList;

/**
 *
 * @author rollersimmer
 */
public class City {
    public static final int CITY_COLOR_LIGHT=800;  // out of 1000

    static boolean doCitiesShareRegionAllegianceInCountry(City a, City b, CityCountry country) {
        try{
            if(a.getRegionAllegianceInCountry(country)==null)
                return false;
            if(a.getRegionAllegianceInCountry(country)==b.getRegionAllegianceInCountry(country))
                return true;
        }catch(NullPointerException ex){
        }
        return false;
    }

    public String name;
    public Point2 pos;
    public int reach;
    public int pop100k;
    MyColor color;
    CityNeighborList neighbors;
    HashMap<CityCountry,CityRegion> regionAllegiances;
    boolean hasBeenDrawnInActiveRegion;
    
    public City(String name,Point2 pos,int reach,int pop100k){
        this.name=name;
        this.pos=pos;
        this.reach=reach;
        this.pop100k=pop100k;
        this.neighbors=null;
        this.regionAllegiances=new HashMap<>();
        this.hasBeenDrawnInActiveRegion=false;
        
        color=MyColorFactory.createRandomly(CITY_COLOR_LIGHT);
    }    
    
    public static int dist(City a, City b) {
        return Point2.dist(a.pos,b.pos);
    }

    public void findAndSetNeighbors(CityMap cm){
        neighbors=new CityNeighborList(this,cm);
    }

    private MyColorList makeNeighborColorList() {
        MyColorList result=new MyColorList();
        if(this.neighbors==null||this.neighbors.closestNeighbors==null)
            return result;
        for(City n:this.neighbors.closestNeighbors.values()){
            result.add(n.color);
        }
        return result;
    }
    
    public void makeColorUniqueFromNeighbors(){
        MyColorList cl=makeNeighborColorList();
        if(MyColor.isTooCloseToAnotherInList(this.color,cl)){
            this.color=MyColorFactory.createColorUniqueFromList(cl,750);
        }
    }
    
    @Override
    public String toString(){
        String nborStr="{}";
        if(neighbors!=null)
            nborStr=neighbors.toString();
        String result=String.format("City: { name=\"%s\", pos=%s, reach=%d, pop100k=%d, color=%s, nbors=%s }",
                        name,pos.toString(),reach,pop100k,color.toString(),nborStr);
        return result;
    }
    
    public String toShortString() {
        return String.format("\"%s\"@%s",name,pos);
    }

    public void clearRegionAllegianceInCountry(CityCountry country) {
        this.regionAllegiances.remove(country);
    }

    public boolean doesConnectToCity(City nbr) {
        if(nbr!=null&&nbr.neighbors!=null&&nbr.neighbors.closestNeighbors!=null){
            for(City c:nbr.neighbors.closestNeighbors.values()){
                if(c==this)
                    return true;
            }
        } 
        if(neighbors!=null&&neighbors.closestNeighbors!=null){
            for(City n:neighbors.closestNeighbors.values()){
                if(n==nbr)
                    return true;
            }
        }
        return false;
    }

    public boolean doesConnectToRegionInCountry(CityRegion rgn,CityCountry country) {
        try{
            for(City n: this.neighbors.closestNeighbors.values()){
                if(n.getRegionAllegianceInCountry(country)==rgn||rgn.contains(n))
                    return true;
            }            
        } catch(NullPointerException ex){
            return false;
        }           
        return false;
    }

    public void setRegionAllegianceInCountry(CityRegion rgn, CityCountry country) {
        if(country==null)
            regionAllegiances.put(country,rgn);
        else
            regionAllegiances.put(country,rgn);
    }

    public CityRegion getRegionAllegianceInCountry(CityCountry country) {
        if(regionAllegiances.containsKey(country)){
            return regionAllegiances.get(country);
        } else{
            return null;
        }            
    }

    boolean doesConnectToOutsideRegionInCountry(CityCountry country) {
        try{
            CityRegion homeRegion=getRegionAllegianceInCountry(country);
            for(CityRegion rgn:country){
                if(rgn==homeRegion)
                    continue;
                if(this.doesConnectToRegionInCountry(rgn,country)){
                    return true;
                }
            }
            return false;
        } catch (NullPointerException ex){
            return false;
        }
    }

    City getRandomCityInNeighboringRegion(CityCountry country) {
        try{
            int amtTries=0;
            final int MAX_TRIES=25;
            City result=null;
            while(result==null && amtTries<MAX_TRIES) {
                result=pickRandomNeighbor();
                if(doIShareRegionInCountryWithCity(country,result))
                    result=null;                    
                amtTries++;
            }
            return result;
        } catch(NullPointerException ex){
            return null;
        }
    }
    
    CityRegion getRandomNeighboringRegionInCountry(CityCountry country){
        try{
            City n=getRandomCityInNeighboringRegion(country);            
            CityRegion result=n.getRegionAllegianceInCountry(country);
            return result;
        } catch(NullPointerException ex){
            return null;
        }
    }

    private City pickRandomNeighbor() {
        try{
            Direction dir=Direction.pickRandomly();
            City result=this.neighbors.closestNeighbors.get(dir);
            return result;            
        } catch(NullPointerException ex){
            return null;            
        }
    }

    private boolean doIShareRegionInCountryWithCity(CityCountry country,City other) {
        try{
            return getRegionAllegianceInCountry(country)==other.getRegionAllegianceInCountry(country);
        } catch(NullPointerException ex){
            return false;
        }
    }
    
    private static int MAX_GET_RANDOM_NEIGHBOR_TRIES=5;

    CityRegion getRandomLargerNeighboringRegionInCountry(CityCountry country) {
        try{
            int amtTries=0;
            CityRegion result=null;
            CityRegion myRegion=getRegionAllegianceInCountry(country);
            while(result==null&&amtTries<MAX_GET_RANDOM_NEIGHBOR_TRIES){
                result=getRandomNeighboringRegionInCountry(country);
                if(result!=null&&result.size()<=myRegion.size()){
                    result=null;
                }
                amtTries++;
            }
            return result;
        }catch(NullPointerException ex){
            //do nothing
        }
        return null;
    }

    CityRegion getRandomSmallerNeighboringRegionInCountry(CityCountry country) {
        try{
            int amtTries=0;
            CityRegion result=null;
            CityRegion myRegion=getRegionAllegianceInCountry(country);
            while(result==null&&amtTries<MAX_GET_RANDOM_NEIGHBOR_TRIES){
                result=getRandomNeighboringRegionInCountry(country);
                if(result!=null&&result.size()>=myRegion.size()){
                    result=null;
                }
                amtTries++;
            }
            return result;
        }catch(NullPointerException ex){
            //do nothing
        }
        return null;
    }
}
