/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.util.ArrayList;
import java.util.HashMap;
import math.Direction;
import math.IntVector2;
import math.Point2;
import math.Point2List;

/**
 *
 * @author rollersimmer
 */
class CityNeighborList {
    
    public City thisCity;
    public HashMap<math.Direction,City> closestNeighbors;    
    
    public static int MAX_NEIGHBOR_DIST=5;
    
    public static boolean SHOULD_USE_DIAGONAL_DIRECTIONS = true;
    
    public CityMap cm;
    
    int amtNeighborsFound;

    public CityNeighborList() {
        closestNeighbors=null;
        cm=null;
    }
    
    public CityNeighborList(City c){
        this();
        thisCity=c;        
    }
    
    CityNeighborList(City c,CityMap cm){
        this(c);
        this.cm=cm;
        findAndSetNeighbors(c);
    }    

    CityNeighborList(CityNeighborList copy) {
        this();
        cm=copy.cm;
        amtNeighborsFound=copy.amtNeighborsFound;
        closestNeighbors=new HashMap<>();
        for(Direction dir:copy.closestNeighbors.keySet()){
            closestNeighbors.put(dir,copy.closestNeighbors.get(dir));
        }        
    }

    private void findAndSetNeighbors(City c) {
        closestNeighbors=new HashMap<>();
        Point2 p=c.pos.div(CityMap.TILE_SIZE);
        amtNeighborsFound=0;
        int dist=0;        
        math.Point2List pointList=null;
        while(dist<MAX_NEIGHBOR_DIST&&amtNeighborsFound<Direction.AMOUNT){            
            pointList=makeNeighborPointList(p,dist);
            for(Point2 np:pointList){
                if(cm.containsKey(np)){
                    findClosestNeighborsInTile(cm.get(np));
                }
            }
            dist++;
        }
    }

    private Point2List makeNeighborPointList(Point2 pt, int dist) {
        Point2List result=new Point2List();
        int x=pt.x;
        int y=pt.y;        
        int l=x-dist;
        int r=x+dist;
        int t=y-dist;
        int b=y+dist;
        for(int nx=l;nx<=r;nx++)
            result.add(new Point2(nx,t));
        for(int ny=t+1;ny<=b-1;ny++){
            result.add(new Point2(l,ny));
            result.add(new Point2(r,ny));
        }
        for(int nx=l;nx<=r;nx++)
            result.add(new Point2(nx,b));
        return result;
    }

    private void findClosestNeighborsInTile(CityList citiesInTile) {
        for(City c:citiesInTile){
            suggestClosestNeighbor(c);
        }
        recountNeighbors();
    }

    private void suggestClosestNeighbor(City c) {
        if(c==null)
            return;
        if(c.pos==null)
            return;
        Direction dir=figureDirectionFromMeToCity(c);
        if(!this.closestNeighbors.containsKey(dir)){
            if(c!=thisCity)
                this.closestNeighbors.put(dir,c);
        } else {
            City closestCity=closestNeighbors.get(dir);
            int closestDist=City.dist(closestCity,thisCity);
            int testDist=City.dist(c,thisCity);
            if(testDist<closestDist){
                closestNeighbors.put(dir,c);
            }
        }
    }

    private void recountNeighbors() {
        this.amtNeighborsFound=this.closestNeighbors.size();
    }

    private Direction simplyFigureDirectionFromMeToCity(City c) {
        IntVector2 disp=c.pos.sub(thisCity.pos);
        Direction result=Direction.east; // default direction
        int adx=Math.abs(disp.x);
        int ady=Math.abs(disp.y);
        Direction vertDir=(disp.y>0)?Direction.north:Direction.south;
        Direction horzDir=(disp.x>0)?Direction.east:Direction.west;
        Direction domDir=(ady>adx)?vertDir:horzDir;
        result=domDir;
        return result;
    }

    private Direction figureDirectionFromMeToCity(City c) {
        if(!SHOULD_USE_DIAGONAL_DIRECTIONS)
            return  simplyFigureDirectionFromMeToCity(c);
        IntVector2 disp=c.pos.sub(thisCity.pos);
        Direction result=Direction.east; // default direction
        int adx=Math.abs(disp.x);
        int ady=Math.abs(disp.y);
        boolean isVertical=ady>2*adx;
        boolean isHorizontal=adx>2*ady;
        boolean isDiagonal=!isVertical && !isHorizontal;
        Direction vertDir=(disp.y>0)?Direction.north:Direction.south;
        Direction horzDir=(disp.x>0)?Direction.east:Direction.west;
        Direction domDir=(ady>adx)?vertDir:horzDir;
        if(isDiagonal){
            if(vertDir==Direction.north){
                result=(horzDir==Direction.east)?Direction.northeast:Direction.northwest;
            } else {
                result=(horzDir==Direction.east)?Direction.southeast:Direction.southwest;
            }
        } else {
            result=domDir;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        try{
            if(o==null)
                return this==null;
            if(CityNeighborList.class.isAssignableFrom(o.getClass())){
                CityNeighborList other=(CityNeighborList)o;
                if( other.amtNeighborsFound!=amtNeighborsFound || !other.cm.equals(cm)
                || !other.thisCity.equals(thisCity) || !other.closestNeighbors.equals(closestNeighbors) )
                    return false;
                return true;                                    
            }
            return false;
        } catch(NullPointerException ex){
            return false;
        }
    }
    
    public String toString(){
        String result="{";
        int amtDirs=0;
        for(Direction ndir:this.closestNeighbors.keySet()){
            result+=ndir.toString();
            City nc=this.closestNeighbors.get(ndir);
            result+=String.format("=>\"%s\"@%s",nc.name,nc.pos.toString());
            if(amtDirs<this.closestNeighbors.size()-1)
                result+=",";
            amtDirs++;
        }
        result+="}";
        return result;
    }

}
