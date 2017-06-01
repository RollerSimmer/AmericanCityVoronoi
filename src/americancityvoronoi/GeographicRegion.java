/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.awt.Color;
import math.Point2List;
import myutil.MyColor;

/**
 *
 * @author rollersimmer
 */
public class GeographicRegion {
    Point2List boundary;
    Color fillColor;
    Color strokeColor;
    
    public GeographicRegion() {  
        boundary=new Point2List();
        fillColor=new Color(128);
        strokeColor=new Color(255);        
    }
    
    public GeographicRegion(Color fillColor,Color strokeColor,Point2List boundary){
        this();
        this.fillColor=fillColor;
        this.strokeColor=strokeColor;
        this.boundary=boundary;
    }
    
    public GeographicRegion(Color fillColor,Color strokeColor,int... coords){
        this(fillColor,strokeColor,new Point2List(coords));
    }    
    
    public GeographicRegion(Color fillColor,int... coords){
        this(fillColor,fillColor.darker(),coords);
        MyColor newStrokeColor=new MyColor(strokeColor);
        strokeColor=newStrokeColor.scaleAlpha(3,1);
    }    
    
    public void scaleAll(int scalingFactor){
        boundary.scaleAll(scalingFactor);
    }      
}
