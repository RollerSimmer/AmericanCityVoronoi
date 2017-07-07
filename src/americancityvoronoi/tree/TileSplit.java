/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi.tree;

import americancityvoronoi.City;
import americancityvoronoi.CityList;
import java.util.ArrayList;
import java.util.Stack;
import math.Direction;
import math.IntegerList;

/**
 *
 * @author rollersimmer
 */
public class TileSplit {

    public enum SplitWay {
        NORTH_AND_SOUTH,
        EAST_AND_WEST;
    }
    
    TileSplit a;
    TileSplit b;
    
    CityList cities;
    
    Direction dir;
    
    int splitCoord;
    SplitWay way;
    
    public TileSplit(){
        a=null;
        b=null;
        this.cities=new CityList();
    }
    
    public TileSplit(Direction dir){
        this();
        this.dir=dir;
    }

    public TileSplit(Direction direction, CityList allCities) {
        this(direction);
        this.cities=new CityList(allCities);
    }
    
    public void split() {
        findSplitWay();
        a=new TileSplit(way==SplitWay.EAST_AND_WEST? Direction.east: Direction.north);
        b=new TileSplit(way==SplitWay.EAST_AND_WEST? Direction.west: Direction.south);
        findSplitCoord();
        for(City c: cities){
            int cityCoord=(way==SplitWay.EAST_AND_WEST? c.pos.x: c.pos.y);
            if(cityCoord<splitCoord){
                a.add(c);
            } else{
                b.add(c);
            }
        }
        cities=null;        
    }
    
    public void add(City c){
        cities.add(c);
    }
    
    public void branchAll(int amtCitiesPerTile) {
        if(this.cities.size()>amtCitiesPerTile){
            split();
            branchChildren(amtCitiesPerTile);
        }
    }

    public void branchChildren(int amtCitiesPerTile){
        try{
            if(a!=null)
                a.branchAll(amtCitiesPerTile);
            if(b!=null)
                b.branchAll(amtCitiesPerTile);
        } catch(NullPointerException ex){
            return;
        }
    }
    
    public int getSplitCoord(){
        return this.splitCoord;
    }
    
    public String getSplitCoordName(){
        switch(way){
            case NORTH_AND_SOUTH:
                return "splitY";            
            case EAST_AND_WEST: 
            default:
                return "splitX";
        }
    }

    public String toString(int indentLvl){
        final String tabStr="  ";
        String indentStr="";
        if(indentLvl>0)
            indentStr+="";        
        for(int l=0;l<indentLvl;l++) 
            indentStr+=tabStr;
        TileSplitList children=getChildren();
        String result="";
        if(indentLvl==0)
            result+="CityTree: root=";
        result+=indentStr+dir.toString()+":\n";        
        if(cities!=null&&cities.size()>0){  
            cities.sortByPopulation();
            result+=indentStr+tabStr+cities.toSingleLineString();            
            result+="\n";
        } else{
            result+=String.format("%s%s%s=%s\n",indentStr,tabStr,getSplitCoordName(),Integer.toString(getSplitCoord()));        
        }        
        int nextIndentLvl=indentLvl+1;
        for(TileSplit child:children){
            if(child!=null)
                result+=child.toString(nextIndentLvl);
        }
        return result;
    }
    
    public void print(){
        System.out.println(toString(0));
    }    
    
    public TileSplitList getChildren(){
        TileSplitList result=new TileSplitList();
        if(a!=null)
            result.add(a);
        if(b!=null)
            result.add(b);
        return result;
    }

    private void findSplitWay() {
        int minX=Integer.MAX_VALUE;
        int maxX=Integer.MIN_VALUE;
        int minY=Integer.MAX_VALUE;
        int maxY=Integer.MIN_VALUE;
        way=SplitWay.NORTH_AND_SOUTH; // default
        if(cities==null)
            return;
        for(City c: cities){
            if(c.pos.x<minX)
                minX=c.pos.x;
            if(c.pos.x>maxX)
                maxX=c.pos.x;
            if(c.pos.y<minY)
                minY=c.pos.y;
            if(c.pos.y>maxY)
                maxY=c.pos.y;
        }
        int width=0,height=0;
        if(minX<Integer.MAX_VALUE && maxX>Integer.MIN_VALUE)
            width=maxX-minX;
        if(minY<Integer.MAX_VALUE && maxY>Integer.MIN_VALUE)
            height=maxY-minY;
        if(width>height)
            way=SplitWay.EAST_AND_WEST;
        else //default
            way=SplitWay.NORTH_AND_SOUTH;
    }

    private void findSplitCoord() {
        IntegerList il=makeCoordList();
        if(il.size()==0){
            splitCoord=0;
            return;
        }
        splitCoord=math.MyMath.median(il);
        return;
    }

    public IntegerList makeCoordList() {
        IntegerList result=new IntegerList();
        for(City c:cities){
            result.add(way==SplitWay.EAST_AND_WEST? c.pos.x: c.pos.y);
        }
        return result;
    }   

    public ArrayList<CityList> getAllCityLists() {
        ArrayList<CityList> result=new ArrayList<>();
        Stack<TileSplit> tsStack=new Stack<>();
        tsStack.push(this);
        while(!tsStack.empty()){
            TileSplit top=tsStack.pop();            
            if(top.cities!=null && top.cities.size()>0)
                result.add(top.cities);
            if(top.a!=null)
                tsStack.push(top.a);
            if(top.b!=null)
                tsStack.push(top.b);            
        }
        return result;
    }
}
