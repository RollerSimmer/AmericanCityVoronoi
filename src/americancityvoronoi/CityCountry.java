/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import myutil.IntBounds;
import myutil.MyColorList;
import myutil.MyDebug;
import myutil.MyRandom;

/**
 *
 * @author rollersimmer
 */
public class CityCountry extends ArrayList<CityRegion> {
    
    public static int minRegions=1;
    public static int maxRegions=2;
    public int targetAmtRegions;    
    public final CityList allCities;
    public CityList unusedCandidates;
    public int targetAmtCitiesPerRegion;
    public int id;
    
    private static int nextId=0;
    
    /**
     * constructor that sets up the candidates and other fields, but does not draft candidates nor does it initialize regions.
     * @param cl the master city list from which the unused candidate list will be built
     */    
    public CityCountry(CityList cl){
        super();
        this.id=nextId;
        ++nextId;
        this.allCities=cl;
        this.unusedCandidates=new CityList(cl);
        unusedCandidates.sortByPopulation();
        targetAmtRegions = (allCities.size()>0)? MyRandom.next(minRegions,maxRegions): 1;
        clearRegionAllegiancesForAllCandidates();
    }   

    CityCountry(CityCountry copy,CityList cl) {
        this(cl);
        targetAmtRegions=copy.targetAmtRegions;
        for(CityRegion rgn: copy) {
            this.add(new CityRegion(rgn,this));
        }
        initTargetAmtCitiesPerRegion();
     }

    CityCountry(CityCountry copy) {
        this(copy,copy.allCities);
     }

    @Override
    public boolean add(CityRegion rgn) {
        for(City c:rgn) {
            try {
                unusedCandidates.remove(c);
            } catch(NullPointerException ex){
                continue;
            }
        }
        return super.add(rgn); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * drafts all unused candidate cities to the different regions
     */
    public void draftAll() {
        int amtCities=allCities.size();
        int roundLimit=amtCities*2;
        int round=0;
        while(!unusedCandidates.isEmpty()){
            if(MyRandom.pctChance(1)){
                if(round>roundLimit){
//                  targetAmtCitiesPerRegion++;
                    break;
                }
            }
            draftOne();
            round++;
        }
    }
 
    /**
     * initializes all the regions to a random amount between min and max region amount
     */
    public void initAll() {
        while(size()<targetAmtRegions && !unusedCandidates.isEmpty()){
            addNewRegionFromUnusedCandidates();
        }
        initTargetAmtCitiesPerRegion();
    }

    /**
     * adds a new region using a city from the unused candidate list
     * @return true only if successful
     */
    private boolean addNewRegionFromUnusedCandidates() {
        if(unusedCandidates==null) 
            return false;        
        City c=unusedCandidates.popBellRandom();
        if(c==null)
            return false;
        CityRegion newRegion=new CityRegion(c,this);
        if(newRegion==null||!add(newRegion))
            return false;
        return true;
    }

    /**
     * clears the region allegiance from each candidate
     */
    private void clearRegionAllegiancesForAllCandidates() {
        for(City c:allCities){
            c.clearRegionAllegianceInCountry(this);
        }
    }

    /**
     * drafts a city to a single randomly-selected region 
     */
    private void draftOne() {
        if(this.isEmpty()||unusedCandidates.isEmpty()) 
            return;
        City draftCity=unusedCandidates.getBellRandom();
        if(draftCity==null)
            return;
        CityRegion rgn=findEligibleRegionClosestToCity(draftCity);
        if(rgn==null || rgn.size()+1>targetAmtCitiesPerRegion || !rgn.add(draftCity))
            return;
        unusedCandidates.remove(draftCity);
    }

    public void print() {
        System.out.print(toString());
    }

    MyColorList getRegionColorList() {
        MyColorList result=new MyColorList();
        for(CityRegion rgn:this){
            if(rgn==null||rgn.color==null)
                continue;
            result.add(rgn.color);
        }
        return result;
    }

    private CityRegion findEligibleRegionClosestToCity(City draftCity) {
        CityRegion result=null;
        if(draftCity==null || size()==0)
            return null;
        int closestDist=Integer.MAX_VALUE;
        for(CityRegion rgn:this){
            if(rgn==null||!rgn.isEligibleForCityConnection(draftCity,this.targetAmtCitiesPerRegion))
                continue;
            int dist=rgn.calcDistToCity(draftCity);
            if(dist<closestDist){
                closestDist=dist;
                result=rgn;
            }
        }        
        return result;
    }
    
    public int calcFitness() {
        myutil.IntBounds bounds=calcRegionSizeBounds();
        final int BOUND_SCALE=50;
        int result = (bounds.dev+bounds.span)*BOUND_SCALE*size();
        for(CityRegion rgn:this){
            int distTerm=rgn.calcAvgDistFromCenter();    
            result+=distTerm;
        }
        return result;
    }

    public IntBounds calcRegionSizeBounds() {
        ArrayList<Integer> szList=new ArrayList<>();
        for(CityRegion rgn:this)
            szList.add(rgn.size());
        IntBounds result=new IntBounds(szList);
        return result;
    }

    private void moveRandomCityBetweenRegions() {
        try{
            City randCity=this.allCities.getBellRandom();
            for(CityRegion rgn:this){
                if(rgn.contains(randCity)){
                    CityRegion swapRgn=rgn.getNeighboringRegion();
                    if(swapRgn==null)
                        return;
                    rgn.moveCityToOtherRegion(randCity,swapRgn);
                }
            }                                    
        } catch(NullPointerException ex){
            return;
        }
    }
    
    private void moveCityFromLargeRegionToNeighboringRegion() {
        try{
            CityRegion lr=this.findLarge();
            if(lr!=null)
                MyDebug.dummy=0;
            City c=lr.findEdgeCity();
            CityRegion fromRgn=c.getRegionAllegianceInCountry(this);
            if(fromRgn.doesRemovingCityBreakContiguity(c)||fromRgn.size()<=1)
                return;
            CityRegion toRgn=c.getRandomSmallerNeighboringRegionInCountry(this);
            fromRgn.moveCityToOtherRegion(c,toRgn);
        } catch(NullPointerException ex){
            return;
        }
        return;
    }

    private void moveCityToSmallRegionFromNeighboringRegion() {
        try{
            CityRegion lr=this.findSmall();
            if(lr!=null)
                MyDebug.dummy=0;
            City c=lr.findEdgeCity();
            CityRegion toRgn=c.getRegionAllegianceInCountry(this);
            CityRegion fromRgn=c.getRandomLargerNeighboringRegionInCountry(this);
            if(fromRgn.doesRemovingCityBreakContiguity(c)||fromRgn.size()<=1)
                return;
            fromRgn.moveCityToOtherRegion(c,toRgn);
        } catch(NullPointerException ex){
            return;
        }
        return;
    }

    void mutateMany() {
        final int MAX_MUTATIONS = 3;
        final int MAX_MUTATIONS_MINUS_ONE = MAX_MUTATIONS-1;
        int amtMutations=Math.abs(MyRandom.nextBell(-MAX_MUTATIONS_MINUS_ONE,MAX_MUTATIONS_MINUS_ONE))+1;
        for(int m=0;m<amtMutations;m++){
            sortLargestFirst();
            if(MyRandom.pctChance(0)){
                moveRandomCityBetweenRegions();
            } else if(MyRandom.pctChance(100)){
                moveCityFromLargeRegionToSmallRegion();                
            } else if(MyRandom.pctChance(0)){
                moveCityFromLargeRegionToNeighboringRegion();                
            } else{
                moveCityToSmallRegionFromNeighboringRegion();                
            }
        }              
        while(mergePunyNeighboringRegions());
        sortLargestFirst();
    }

    private CityRegion getRegionBesides(CityRegion rgn) {
        for(CityRegion other:this){
            if(!other.equals(rgn)){
                return other;
            }
        }
        return null;
    }

    private CityRegion findLarge() {
        if(this.size()==0)
            return null;
        this.sortLargestFirst();
        CityRegion result=get(MyRandom.next(0,size()/2));
        return result;        
    }
    
    private CityRegion findSmall() {
        if(this.size()==0)
            return null;
        this.sortLargestFirst();
        CityRegion result=get(MyRandom.next(size()/2,size()-1));
        return result;        
    }

    @Override
    public int hashCode(){
        return id;
    }

    private void sortLargestFirst() {
        Collections.sort(this,new CityRegionLargestSizeComparator());
    }

    private int calcAvgRegionSize() {
        int szSum=0;
        if(size()==0)
            return 0;
        try {
            for(CityRegion rgn: this){
                szSum+=rgn.size();
            }
        } catch(NullPointerException ex){
            //do nothing
        }
        return szSum/size();
    }

    private void initTargetAmtCitiesPerRegion() {
        if(size()==0)
            targetAmtCitiesPerRegion=this.allCities.size();
        else
            targetAmtCitiesPerRegion=(this.allCities.size()+(targetAmtRegions-1))/targetAmtRegions;
    }
    
    private static class CityRegionLargestSizeComparator implements Comparator<CityRegion>{

        @Override
        public int compare(CityRegion a, CityRegion b) {
            return b.size()-a.size();            
        }
    }

    private void mergeRegions(CityRegion a, CityRegion b) {
        try{
            CityRegion mergedRegion=CityRegion.merge(a,b);
            add(mergedRegion);
            remove(a);
            remove(b);
        }catch(NullPointerException ex){
            return;
        }
    }

    private void moveCityFromLargeRegionToSmallRegion() {
        try{
            CityRegion small=null;
            CityRegion large=null;
            final int MAX_STEP=4;
            for(int iLarge=0;iLarge<size()-1;iLarge+=MyRandom.next(1,MAX_STEP)){
                large=get(iLarge);
                for(int iSmall=size()-1;iSmall>iLarge;iSmall-=MyRandom.next(1,MAX_STEP)){
                    small=get(iSmall);
                    City c=CityRegion.findAnyCityConnectedToBothRegions(small,large);
                    if(c==null)
                        continue;
                    CityRegion fromRgn = c.getRegionAllegianceInCountry(this);
                    CityRegion toRgn = (fromRgn==small)? large: small;
                    if(!(fromRgn.size()>targetAmtCitiesPerRegion&&toRgn.size()<targetAmtCitiesPerRegion))
                        continue;
                    if(fromRgn.doesRemovingCityBreakContiguity(c)||fromRgn.size()<=1)
                        continue;
                    fromRgn.moveCityToOtherRegion(c,toRgn);
                    return;                    
                }
            }
        }catch(NullPointerException ex){
            return;
        }catch(ArrayIndexOutOfBoundsException ex){
            return;
        }
    }
    
    public boolean mergePunyNeighboringRegions(){
        try{
            sortLargestFirst();
            if(size()>=3){
                CityRegion largest=get(0);
                int maxSz=this.targetAmtCitiesPerRegion*3/2;
                int maxCombinedSz=maxSz;
                CityRegion smallest=null;
                CityRegion small=null;
                for(int iSmallest=size()-1;iSmallest>=2;iSmallest--){
                    smallest=get(iSmallest);
                    for(int iSmall=1;iSmall<iSmallest;iSmall++){
                        small=get(iSmall);
                        if(small.size()+smallest.size()<=maxSz){
                            if(CityRegion.areRegionsNeighbors(small,smallest)){
                                mergeRegions(small,smallest);
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }catch(NullPointerException ex){
            return false;
        }
    }
    
    public String toString(){
        String result="";
        result+="CityCountry:\n";
        result+=String.format("targetRegionSz=%d\nid=%d\nsize()=%d\nfitness=%d (balance)\n",targetAmtCitiesPerRegion,id,size(),this.calcFitness());
        for(CityRegion rgn: this){
            if(rgn==null)
                continue;
            result+=rgn.toString();
        }
        
        return result;
    }
}
