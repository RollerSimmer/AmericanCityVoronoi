/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import math.IntVector2;

/**
 *
 * @author rollersimmer
 */
public class ClosestCityPair {

    IntVector2 compPoint;
    public City closestCity;
    public City nextClosestCity;
    boolean visitedFlag;
    
    ClosestCityPair(IntVector2 compPoint){
        this.compPoint=compPoint;
        this.nextClosestCity=null;
        this.closestCity=null;
        this.visitedFlag=false;
    }
    
    public void clearVisitedFlag(){
        visitedFlag=false;
    }
    
    public void registerVisit(){
        visitedFlag=true;
    }
    
    public boolean wasVisited(){
        return visitedFlag;        
    }
    
    public boolean suggestCandidate(City candidateCity){
        boolean result=false;
        fixNullCities();        
        if(candidateCity==closestCity){
            result=false;
        } else if(candidateCity==nextClosestCity){
            result=false;
        } else 
        if(CityVoronoiComparer.isPointMoreReachable(candidateCity,closestCity,compPoint)){
            replaceClosestCityWith(candidateCity);
            result=true;            
        } else if(CityVoronoiComparer.isPointMoreReachable(candidateCity,nextClosestCity,compPoint)){
            replaceNextClosestCityWith(candidateCity);
            result=true;            
        }
        if(closestCity==nextClosestCity)
            System.out.print("");
        return result;
    }    

    private void replaceNextClosestCityWith(City replacementCity) {
        nextClosestCity=replacementCity;        
    }

    private void replaceClosestCityWith(City replacementCity) {
        replaceNextClosestCityWith(closestCity);
        closestCity=replacementCity;
    }
    
    private void fixNullCities() {
        if(closestCity==null&&nextClosestCity==null) {
            //do nothing
        } else if(closestCity==nextClosestCity) {
            nextClosestCity=null;            
        } else if(closestCity==null&&nextClosestCity!=null) {
            closestCity=nextClosestCity;
            nextClosestCity=null;
        }   
    }

    int calcClosenessDiff() {
        if(closestCity==null||nextClosestCity==null||compPoint==null){
            return Integer.MAX_VALUE;
        } else {
            if(closestCity==nextClosestCity)
                System.out.print("");
            int result=CityVoronoiComparer.compareClosenessToPoint(closestCity,nextClosestCity,compPoint);
            return result;
        }            
    }
    
    boolean doesContain(City candidate) {
        return closestCity==candidate||nextClosestCity==candidate;
    }   
    
    @Override
    public String toString(){
        String cptStr=compPoint==null?"NULL":compPoint.toString();
        String nccStr=nextClosestCity==null?"NULL":String.format("\"%s\"@%s (distance=%d)",
                                                        nextClosestCity.name,
                                                        nextClosestCity.pos.toString(),                                                      
                                                        IntVector2.defaultDist(compPoint,nextClosestCity.pos));
        String ccStr=closestCity==null?"NULL":String.format("\"%s\"@%s (distance=%d)",
                                                        closestCity.name,
                                                        closestCity.pos.toString(),                                                      
                                                        IntVector2.defaultDist(compPoint,closestCity.pos));
        String result=String.format("ClosestCityPair: {%s, compPoint=%s, closest:%s, nextClosest:%s}",
                            (visitedFlag?"visited":"unvisited"),
                            cptStr,ccStr,nccStr);
        return result;
    }

}

