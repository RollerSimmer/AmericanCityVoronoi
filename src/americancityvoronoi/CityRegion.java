/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.util.ArrayList;
import math.IntVector2;
import math.Point2;
import myutil.MyColor;
import myutil.MyColorFactory;
import myutil.MyRandom;

/**
 *
 * @author rollersimmer
 */
public class CityRegion extends CityList {


    private Point2 coordSum;
    public Point2 centerPos;
    
    CityCountry parentCountry;
    
    public MyColor color;
    
    public CityRegion() {
        super();
        coordSum=new Point2(0,0);
        centerPos=new Point2(0,0);
        parentCountry=null;
        color=null;
    }
    
    public CityRegion(City initialCity){
        this();
        add(initialCity);
    }
    
    public CityRegion(City initialCity,CityCountry parentCountry){
        this();
        this.parentCountry=parentCountry;
        add(initialCity);
        int light1000ForRegions=250;
        this.color=MyColorFactory.createColorUniqueFromList(parentCountry.getRegionColorList(),light1000ForRegions);
    }
    
    /**
     * makes a copy of a CityRegion containing copies of both cities and regions
     * @param copy
     * @param parentCountry 
     */
    
    public CityRegion(CityRegion copy,CityCountry parentCountry){
        this();
        this.parentCountry=parentCountry;
        this.centerPos=copy.centerPos;
        this.coordSum=copy.coordSum;
        this.color=copy.color;
        for(City c:copy){
            c.setRegionAllegianceInCountry(this, this.parentCountry);            
            this.add(c);
        }            
    }
    
    public City expand(){
//        City expansionCity=findClosestCityNotInThisRegion();
        City expansionCity=findClosestUnclaimedCity();
        if(expansionCity==null||!add(expansionCity))
            return null;
        return expansionCity;
    }    
    
    @Override
    public boolean add(City c){
        c.setRegionAllegianceInCountry(this,parentCountry);
        boolean result = super.add(c);
        coordSum.inc(c.pos);
        updateCoordAvg();
        return result;
    }

    @Override
    public boolean remove(Object o) {
        if(City.class.isAssignableFrom(o.getClass())){
            City c=(City)o;
            c.clearRegionAllegianceInCountry(parentCountry);
        }
        return super.remove(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public City remove(int i) {
        if(i>=0&&i<size()){
            City c=get(i);
            c.clearRegionAllegianceInCountry(parentCountry);
        }
        return super.remove(i); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void updateCoordAvg() {
        if(size()<=0)
            return;
        centerPos=new Point2(coordSum);
        centerPos.divEqu(size());
    }

    private City findClosestUnclaimedCity() {
        CityRegion regionToInclude=null;
        return findClosestCityNotInRegion(regionToInclude, RegionLogic.IS_IN_REGION);
    }

    private City findClosestCityNotInThisRegion() {
        CityRegion regionToExclude=this;
        return findClosestCityNotInRegion(regionToExclude, RegionLogic.NOT_IN_REGION);
    }
    
    private City findClosestCityNotInRegion(CityRegion region, RegionLogic logic) {
        int closestDist=Integer.MAX_VALUE;
        City result=null;
        for(City c: this){
            if(c==null||c.neighbors==null||c.neighbors.closestNeighbors==null)
                continue;
            for(City n: c.neighbors.closestNeighbors.values()){
                if(n==null||!RegionLogic.logicOp(n.getRegionAllegianceInCountry(parentCountry),region,logic))
                    continue;
                int nDist=IntVector2.dist(centerPos,n.pos);
                if(nDist<closestDist){
                    closestDist=nDist;
                    result=n;
                }
            }
        }
        return result;
    }

    int calcDistToCity(City c) {
        int result=Integer.MAX_VALUE;
        if(c==null||this.centerPos==null)
            return result;
        result=IntVector2.dist(c.pos,centerPos);
        return result;
    }

    boolean isConnectedToCity(City c) {
        if(c==null)
            return false;
        if(c.getRegionAllegianceInCountry(parentCountry)==this)
            return true;
        for(City n:this){
            if(c.doesConnectToCity(n))
                return true;
        }
        return false;
    }

    boolean isEligibleForCityConnection(City c, int maxCitiesPerRegion) {
        if(!isConnectedToCity(c))
            return false;
        if(size()>=maxCitiesPerRegion)
            return false;
        return true;
    }
    
    boolean doesRemovingCityBreakContiguity(City c){
       
        if(!this.contains(c)||c==null||c.neighbors==null
        ||c.neighbors.closestNeighbors==null||c.neighbors.closestNeighbors.size()==0)
            return false;
        CityList dependentNeighborList=new CityList();
        for(City n:c.neighbors.closestNeighbors.values()){
            try{            
                if(City.doCitiesShareRegionAllegianceInCountry(c,n,parentCountry))
                    dependentNeighborList.add(n);            
            } catch(NullPointerException ex){
                continue;
            }
        }
        for(City other:this){
            try{
                for(City otherNbor: other.neighbors.closestNeighbors.values()){
                    if(City.doCitiesShareRegionAllegianceInCountry(other,otherNbor,parentCountry)
                    &&dependentNeighborList.contains(otherNbor))
                        dependentNeighborList.remove(otherNbor);
                }
            } catch(NullPointerException ex){
                continue;
            }
        }
        boolean result=dependentNeighborList.size()>0;
        return result;
    }

    void moveCityToOtherRegion(City c, CityRegion toRgn) {
        if(!this.contains(c)||!c.doesConnectToRegionInCountry(toRgn,toRgn.parentCountry))
            return;
        toRgn.add(c);
        this.remove(c);
    }

    City findEdgeCity() {
        int amtTries=0;
        int maxTries=size()*2;
        City result=null;
        while(result==null){
            result=getRandom();
            amtTries++;            
            if(result!=null&&!result.doesConnectToOutsideRegionInCountry(this.parentCountry)){
                result=null;
            } else if(amtTries>=maxTries){
                result=null;
                break;
            }                    
        }
        return result;
    }
    
    public String toString() {
        String result="";
        result+="CityRegion:{";
        result+=String.format("size=%d,countryId=%d,coordAvg=%s,coordSum=%s,cities={",size(),parentCountry.id,centerPos.toString(),coordSum.toString());
        int i=0;
        for(City c:this){
            result+=c.toShortString();
            if(i<size()-1)
                result+=",";
            ++i;            
        }
        result+="}\n";
        return result;
    }

    CityRegion getNeighboringRegion() {
        try{
            CityList allCities=parentCountry.allCities;
            if(allCities.size()==0)
                return null;
            int startIndex=MyRandom.next(0,allCities.size()-1);
            if(startIndex>=(allCities.size()-1)){
                startIndex=0;                    
            }
            int index=startIndex;
            City c=allCities.get(index);
            while(!c.doesConnectToRegionInCountry(this,parentCountry)){
                c=allCities.get(++index);
                if(index>=(allCities.size()-1)){
                    index=0;                    
                } else if(index==startIndex){
                    return null;
                }
            }
            return c.getRegionAllegianceInCountry(parentCountry);
        } catch(NullPointerException ex){
        }
        return null;            
    }

    int calcAvgDistFromCenter() {
        if(size()==0)
            return 0;
        int distSum=0;
        for(City c:this){
            int dist=IntVector2.dist(c.pos,this.centerPos);
            distSum+=dist;
        }
        int result=distSum/size();
        return result;
    }

    public boolean doesNeighborOtherRegion(CityRegion other) {
        try{
            for(City c:this){
                if(c.doesConnectToRegionInCountry(other,parentCountry))
                    return true;
            }
            for(City n:other){
                if(n.doesConnectToRegionInCountry(this,parentCountry))
                    return true;
            }
        } catch(NullPointerException ex){
            // do nothing
        }
        return false;
    }
    
    public static boolean areRegionsNeighbors(CityRegion a,CityRegion b){
        try{
            return a.doesNeighborOtherRegion(b)||b.doesNeighborOtherRegion(a);
        } catch(NullPointerException ex){
            return false;
        }
    }
    
    static CityRegion merge(CityRegion rgnA, CityRegion rgnB) {
        try{
            CityRegion result=new CityRegion(rgnA,rgnA.parentCountry);
            for(City c:rgnB){
                if(!result.contains(c))
                    result.add(c);
            }
            return result;
        } catch(NullPointerException ex){
            // do nothing
        }        
        return null;
    }
    
    static City findAnyCityConnectedToBothRegions(CityRegion small, CityRegion large) {
        try{
            CityCountry country=small.parentCountry;
            if(small.size()==0||large.size()==0)
                return null;
            if(country!=large.parentCountry)
                return null;
            CityList eligibleCities=new CityList();
            for(City c: small) {
                if(c.doesConnectToRegionInCountry(large,country)) {
                    eligibleCities.add(c);
                }
            }
            for(City c: large) {
                if(c.doesConnectToRegionInCountry(small,country)) {
                    eligibleCities.add(c);
                }
            }
            if(eligibleCities.size()>0){
                int iPick=MyRandom.next(0,eligibleCities.size()-1);
                return eligibleCities.get(iPick);
            }
            return null;
        } catch(NullPointerException ex) {
            return null;
        }
    }

}