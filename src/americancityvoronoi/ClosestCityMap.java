/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.util.ArrayList;
import java.util.Stack;
import math.IntVector2;
import math.PointNav2;

/**
 *
 * @author rollersimmer
 */
public class ClosestCityMap extends ArrayList<ClosestCityPair>{
    IntVector2 bounds;
    
    int totalModifications;
    
    public ClosestCityMap(IntVector2 bounds){
        super();
        init(bounds);        
    }

    private void init(IntVector2 bounds) {
        this.clear();
        this.bounds=bounds;
        for(int y=0;y<bounds.y;y++){
            for(int x=0;x<bounds.x;x++){
                IntVector2 pt=new IntVector2(x,y);
                this.put(pt,new ClosestCityPair(pt));
            }
        }
    }
    
    public void fillUsingCityList(CityList cl){
        CityList clCopy=new CityList(cl);
        City c=null;
        totalModifications=0;
        while(!clCopy.isEmpty()){
            c=clCopy.popFront();
            fillUsingCity(c);
        }
        System.out.printf("One-at-a-time closest-pair filling did the job using %d map modifications.\n",totalModifications);
        System.out.printf("There are %d pixel entries on the closest pair map.\n",size());
    }

    private void fillUsingCity(City c) {
        if(c==null)
            return;
        clearVisitedMap();        
        System.out.printf("filling voronoi map using the city %s\n",c.name);
        Stack<PointNav2> pointStack=new Stack<>();
        pointStack.push(new PointNav2(c.pos));
        PointNav2 pt,u,d,l,r;
        boolean wasTileChanged=false;
        int amtTilesChanged=0;
        while(!pointStack.isEmpty()){
            pt=pointStack.pop();
            if(!isPointInBounds(pt)||wasPointVisited(pt))
                continue;
            registerVisitAtPoint(pt);
            wasTileChanged=fillAtPoint(pt,c);
            if(!wasTileChanged)
                continue;     
            amtTilesChanged++;
            totalModifications++;
            u=pt.getUp();
            d=pt.getDown();
            l=pt.getLeft();
            r=pt.getRight();            
            if(isPointInBounds(u)&&!wasPointVisited(u))
                pointStack.push(u);
            if(isPointInBounds(d)&&!wasPointVisited(d))
                pointStack.push(d);
            if(isPointInBounds(l)&&!wasPointVisited(l))
                pointStack.push(l);            
            if(isPointInBounds(r)&&!wasPointVisited(r))
                pointStack.push(r);
        }
        if(amtTilesChanged==0)        {
            System.out.printf("No Voronoi diagram tiles were changed by %s - that's a problem.\n",c.name);
        }
    }    

    void fillSimultaneouslyUsingCityList(CityList cl) {
        ClosestCityQueue pairQueue=new ClosestCityQueue();        
        ClosestCityQueueEntry e;
        PointNav2 pt,up,dp,lp,rp;
        boolean wasModified=false;
        pairQueue.insertAllCitiesFromList(cl,this);
        totalModifications=0;
        while(!pairQueue.isEmpty()){
            e=pairQueue.poll();
            if(e==null||e.ccp==null||e.candidate==null||e.ccp.doesContain(e.candidate))
                continue;
            wasModified=e.ccp.suggestCandidate(e.candidate);
            if(!wasModified)
                continue;
            totalModifications++;
            pt=new PointNav2(e.ccp.compPoint);
            up=pt.getUp();
            dp=pt.getDown();
            lp=pt.getLeft();
            rp=pt.getRight();
            pairQueue.suggestNewEntry(this,up,e);
            pairQueue.suggestNewEntry(this,dp,e);
            pairQueue.suggestNewEntry(this,lp,e);
            pairQueue.suggestNewEntry(this,rp,e);
        }        
        System.out.printf("Simultaneous closest-pair filling did the job using %d map modifications.\n",totalModifications);
        System.out.printf("There are %d pixel entries on the closest pair map.\n",size());
    }

    private void clearVisitedMap() {
        for(ClosestCityPair ccp: this){
            if(ccp!=null && ccp.wasVisited())
                ccp.clearVisitedFlag();
        }        
    }

    public boolean isPointInBounds(IntVector2 pt) {
        if(pt==null) 
            return false;
        return pt.x>=0 && pt.y>=0 && pt.x<bounds.x && pt.y<bounds.y;
    }

    private boolean wasPointVisited(IntVector2 pt) {
        if(!isPointInBounds(pt)) return true;
        ClosestCityPair ccp=this.get(pt);
        if(ccp==null) return true;
        return ccp.wasVisited();
    }

    private boolean fillAtPoint(IntVector2 pt, City c) {
        if(!isPointInBounds(pt)) 
            return false;
        ClosestCityPair ccp=this.get(pt);
        if(ccp==null) 
            return false;
        boolean result = ccp.suggestCandidate(c);
        return result;
    }
    
    public String toString(){
        String result="ClosestCityMap:\n";
        String formatString="key %d: Point %s maps to %s\n";
        int iKey=0;
        for(ClosestCityPair pair: this){
            if(pair==null) 
                continue;
            IntVector2 pt=pair.compPoint;
            String part=String.format(formatString,iKey,pt.toString(),get(pt).toString());
//            if(iKey<size()-1)
//                part+="\n";
            System.out.print(part);
            result+=part;
            iKey++;
        }
        
        return result;
    }

    void printAll() {
        System.out.print(toString()+"\n");
    }

    private void put(IntVector2 pt, ClosestCityPair closestCityPair) {
        if(!isPointInBounds(pt)) 
            return;
        int index=calcIndexToPoint(pt);
        growToAtLeast(index+1);
        try{
            this.set(index, closestCityPair);
        }catch(IndexOutOfBoundsException ex){
            System.out.print("Exception caught.\n");
        }
    }

    private int calcIndexToPoint(IntVector2 pt) {
        int result=pt.x+pt.y*bounds.x;
        return result;
    }
    
    public ClosestCityPair get(IntVector2 pt){
        if(!isPointInBounds(pt)) 
            return null;
        int index=calcIndexToPoint(pt);
        ClosestCityPair result;
        try{
            result=get(index);            
        } catch(IndexOutOfBoundsException ex){
            result=null;
        }
        return result;
    }
    
    public void growToAtLeast(int targetSize){
        while(targetSize>size())
            this.add(null);
    }

    private void registerVisitAtPoint(PointNav2 pt) {
        ClosestCityPair ccp=get(pt);
        if(ccp==null) 
            return;
        ccp.registerVisit();
    }


}

