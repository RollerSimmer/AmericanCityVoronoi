/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import static americancityvoronoi.NorthAmericanCityListFactory.MAX_POP_THRESHOLD;
import static americancityvoronoi.NorthAmericanCityListFactory.MIN_POP_THRESHOLD;
import static americancityvoronoi.NorthAmericanCityListFactory.SHOULD_ADD_ALL_CITIES;
import static americancityvoronoi.NorthAmericanCityListFactory.SHOULD_REMOVE_SMALL_CITIES;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import math.Point2;
import myutil.MyColor;

/**
 *
 * @author rollersimmer
 */
public class LocationLoader {

    private static CityList result=null;

    private static void loadAllLocations(String fileName) {
        try{
            BufferedReader fr=new BufferedReader(new FileReader(fileName));
            while(fr.ready()) {
                String rawLine=fr.readLine();
                int commentLoc=rawLine.indexOf("#");
                String line = commentLoc!=-1? rawLine.substring(0,commentLoc): rawLine;
                addLocationFromLine(line);
            }
        } catch (IOException ex) {
            
        }
    }

    private static void addLocationFromLine(String line) {
        //                         0    1    2    3    4    5    6    7    8    9    10
        //                         name|posx|posy|rch |pop |r   |g   |b   |r   |g   |b   
        if(line.isEmpty())
            return;
        Pattern p=Pattern.compile("(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)\\|(.*)");
        Matcher m=p.matcher(line);
        if(!m.matches())
            return;
        int i=1;
        try{
            String name=m.group(i++);
            int x=Integer.parseInt(m.group(i++));
            int y=Integer.parseInt(m.group(i++));
            int reach=Integer.parseInt(m.group(i++));
            int pop=Integer.parseInt(m.group(i++));
            int rPrm=Integer.parseInt(m.group(i++));
            int gPrm=Integer.parseInt(m.group(i++));
            int bPrm=Integer.parseInt(m.group(i++));
            int rSec=Integer.parseInt(m.group(i++));
            int gSec=Integer.parseInt(m.group(i++));
            int bSec=Integer.parseInt(m.group(i++));
            MyColor primary=new MyColor(rPrm,gPrm,bPrm,255);
            MyColor secondary=new MyColor(rSec,gSec,bSec,255);
            
            City newCity=new City(name,new Point2(x,y),reach,pop,primary,secondary);
            result.add(newCity);        
        } catch(IllegalStateException ex){
            return;
        }
    }
    
    private static void removeSmallAndLargeCities() {
        CityList removeList=new CityList();
        for(City c: result) {
            if(c.pop100k<MIN_POP_THRESHOLD||c.pop100k>MAX_POP_THRESHOLD)
                removeList.add(c);
        }
        for(City rc: removeList) {
            result.remove(rc);            
        }
    }
    
    private static void sortCitiesByPopulation() {
        result.sortByPopulation();
    }

    public static CityList createFromFile(String fileName){
        result=new CityList();
        loadAllLocations(fileName);
        if(SHOULD_REMOVE_SMALL_CITIES)
            removeSmallAndLargeCities();
        sortCitiesByPopulation();     
        return result;
    }

}
