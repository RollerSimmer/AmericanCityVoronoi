/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import math.IntVector2;
import math.Point2;
import math.Point2List;
import myutil.MyColor;
import myutil.MyRandom;

/**
 *
 * @author rollersimmer
 */
public class Drawer extends JComponent {
    public static final int LINE_CLOSENESS_THRESHOLD=3;
    public static boolean SHOULD_SHOW_NEIGHBOR_CONNECTIONS=false;
    private final int SQUARE_SHIFT=4;
    private final int SQUARE_SIZE=1<<SQUARE_SHIFT;
    private final int DIAGRAM_PIXEL_SIZE=3;
    
    private CityList cities;
    private Graphics g;
    private IntVector2 extents;
    private IntVector2 scaledExtents;
    private ClosestCityMap ccmap;
    private CityMap cityMap;
    private CityCountry country;    
    private CityCountryEvolver evolver;
    
    private GeographyList geoList;
      
    Color gridColor;
    
    private BufferedImage img;
    
    
    public Drawer(CityList cities){
        super();
        init(cities);
    }
    
    public Drawer(){
        this(new CityList());
    }

    public void init(CityList cities) {
        this.cities=cities; 
        resizeCanvas();
        if(extents.x==0||extents.y==0){
            img=null;
            System.out.println("img was set to null because one extent was zero.");
        } else{
            img=new BufferedImage(scaledExtents.x,scaledExtents.y,BufferedImage.TYPE_3BYTE_BGR);
            System.out.printf("img was initialized with extents (%d,%d).\n",scaledExtents.x,scaledExtents.y);
        }
        initClosestCityMap();        
        gridColor=Color.GRAY.brighter();
        geoList=NorthAmericanGeographicListFactory.create();
        geoList.scaleAll(DIAGRAM_PIXEL_SIZE);
        initCityNeighbors();
        if(Drawer.SHOULD_SHOW_NEIGHBOR_CONNECTIONS)
            initCountry();
    }
    
    private void drawCenteredText(String text,IntVector2 pos,Color color){
        FontMetrics fm=g.getFontMetrics();
        int halfWidth=fm.stringWidth(text)/2;
        int halfHeight=fm.getHeight()/2;
        g.setColor(color);        
        g.drawString(text,pos.x-halfWidth,pos.y-halfHeight);
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img,0,0,null);
    }    
    
    // draw painting
    public void updatePaint(){
        try{
            this.g = img.createGraphics();
            drawMap();
            this.g.dispose();
            repaint();
        }catch(NullPointerException ex){
            System.out.println("Canvas was not updated");
        }
    }    

    private void drawMap() {
        if(cities.size()==0)
            return;
        drawVoronoiDiagramLines();
        drawGeographicShapes();
        drawRegionConnections();
        drawConnections();
        drawCityDots();
        drawCityNames();
    }

    private void resizeCanvas() {
        calcExtents();        
        scaledExtents=IntVector2.scale(extents,DIAGRAM_PIXEL_SIZE);
        Dimension dim=new Dimension(scaledExtents.x,scaledExtents.y);        
        this.setPreferredSize(dim);
        System.out.printf("Drawing canvas was resized to %s\n",extents.toString());
    }

    /**
     * draws lines for voronoi diagram around cities
     */
    private void drawVoronoiDiagramLines() {
        for(int y=0;y<extents.y;y++){
            for(int x=0;x<extents.x;x++){
                IntVector2 pos=new IntVector2(x,y);
                ClosestCityPair ccp=this.ccmap.get(pos);
                if(ccp==null||ccp.closestCity==null)
                    drawDiagramPixel(x,y,Color.WHITE);
                else{
//                    int closenessDifference=ccp.calcClosenessDiff();
//                    if(closenessDifference<=LINE_CLOSENESS_THRESHOLD){
////                        System.out.printf("VoronoiDiagram: Drew black pixel at %s - %s\n",pos.toString(),ccp.toString());
//                        drawDiagramPixel(x,y,Color.BLACK);                        
//                    } else
                        drawDiagramPixel(x,y,ccp.closestCity.primary);
                }
            }            
        }
    }

    /**
     * places the names of cities at the location of the cities on the map
     */
    private void drawCityNames() {
        this.g.setFont(Font.getFont(Font.MONOSPACED));
        for(City c:cities){         
            IntVector2 namePos=IntVector2.scale(c.pos,DIAGRAM_PIXEL_SIZE);
            drawCenteredText(c.name,namePos,MyColor.makeTransparent(c.secondary,3,100));
        }
    }

    private void drawCityDots() {
        this.g.setFont(Font.getFont(Font.MONOSPACED));
        for(City c:cities){         
            IntVector2 dotPos=IntVector2.scale(c.pos,DIAGRAM_PIXEL_SIZE);
            g.setColor(c.secondary);
            g.fillRect(dotPos.x-2,dotPos.y-2,4,4);
        }
    }

    private void calcExtents() {
        extents=new IntVector2(0,0);
        IntVector2 maxs=cities.getMaxs();
        int x=maxs.x;
        int y=maxs.y;
        int xPrime=(x>>SQUARE_SHIFT)<<SQUARE_SHIFT;
        int yPrime=(y>>SQUARE_SHIFT)<<SQUARE_SHIFT;
        if(xPrime<x) 
            xPrime+=SQUARE_SIZE;
        if(yPrime<y) 
            yPrime+=SQUARE_SIZE;
        if(xPrime>extents.x) 
            extents.x=xPrime;
        if(yPrime>extents.y) 
            extents.y=yPrime;            
    }

    private void initClosestCityMap() {
        ccmap=new ClosestCityMap(this.extents);
//        ccmap.fillUsingCityList(cities);
        ccmap.fillSimultaneouslyUsingCityList(cities);
//        ccmap.printAll();
    }

    private void drawDiagramPixel(int x, int y, Color c) {
        IntVector2 tl=new IntVector2(x,y);
        tl.scale(DIAGRAM_PIXEL_SIZE);
        int l=tl.x;
        int t=tl.y;
        g.setColor(c);
        g.fillRect(l,t,DIAGRAM_PIXEL_SIZE,DIAGRAM_PIXEL_SIZE);
//        g.setColor(gridColor);
//        g.drawRect(l,t,DIAGRAM_PIXEL_SIZE-1,DIAGRAM_PIXEL_SIZE-1);
    };
    
    public void saveImage() {
        DateFormat df = new SimpleDateFormat("yyyy_MM_dd_yyyy_HH_mm_ss");
        Date today = Calendar.getInstance().getTime();        
        String dateStr = df.format(today);
        String filename=String.format("output/map_%s.png",dateStr);
        try {            
            ImageIO.write(img,"PNG",new File(filename));
            System.out.printf("Saved image to %s.\n",filename);
        } catch (java.io.IOException ex) {
            System.out.printf("IO Exception occured when trying to save image to %s.\n",filename);
        }
    }    
    
    public void drawOutlinedPolygon(Point2List points,Color fillColor,Color strokeColor){
        int amtPoints=points.size();
        if(amtPoints==0)
            return;
        int[] xPoints=new int[amtPoints];
        int[] yPoints=new int[amtPoints];
        for(int i=0;i<amtPoints;i++){
            IntVector2 pt=points.get(i);
            xPoints[i]=pt.x;
            yPoints[i]=pt.y;
        }
        Polygon p=new Polygon(xPoints,yPoints,amtPoints);        
        g.setColor(fillColor);
        g.fillPolygon(p);
        g.setColor(strokeColor);
        g.drawPolygon(p);
    }
    

    public void drawGeographicShapes() {
        for(GeographicRegion gr:geoList){
            drawOutlinedPolygon(gr.boundary,gr.fillColor,gr.strokeColor);
        }
    }

    private void initCityNeighbors() {
        this.cityMap=new CityMap(cities);
        for(City c:cities){
            c.findAndSetNeighbors(cityMap);
        }
        cities.makeCityColorsUnique();
    }

    private void drawCityConnection(City a, City b) {
        IntVector2 ap=IntVector2.scale(a.pos,DIAGRAM_PIXEL_SIZE);
        IntVector2 bp=IntVector2.scale(b.pos,DIAGRAM_PIXEL_SIZE);
        if(Graphics2D.class.isAssignableFrom(g.getClass())){
            Color aColor=new Color(255,255,255,255);            
            Color bColor=new Color(255,255,255,64);            
            ((Graphics2D)g).setPaint(new GradientPaint(ap.x,ap.y,aColor,bp.x,bp.y,bColor));                        
        }
        else
            g.setColor(Color.WHITE);
        g.drawLine(ap.x,ap.y,bp.x,bp.y);
    }

    private void drawRegionCityConnection(CityRegion rgn, City a, City b) {
        if(a.getRegionAllegianceInCountry(country)!=rgn||b.getRegionAllegianceInCountry(country)!=rgn)
            return;
        IntVector2 ap=IntVector2.scale(a.pos,DIAGRAM_PIXEL_SIZE);
        IntVector2 bp=IntVector2.scale(b.pos,DIAGRAM_PIXEL_SIZE);
        Stroke oldStroke=null;
        if(Graphics2D.class.isAssignableFrom(g.getClass())){
            oldStroke=((Graphics2D)g).getStroke();
            ((Graphics2D)g).setStroke(new BasicStroke(10));
        }
        g.setColor(rgn.color);
        g.drawLine(ap.x,ap.y,bp.x,bp.y);
        if(oldStroke!=null){
            ((Graphics2D)g).setStroke(oldStroke);
        }
    }

    private void drawConnections() {
        System.out.println(cityMap.toString());
        if(!Drawer.SHOULD_SHOW_NEIGHBOR_CONNECTIONS)
            return;
        for(City c:cities){
            if(c==null||c.neighbors==null||c.neighbors.closestNeighbors==null) 
                continue;
            for(City n:c.neighbors.closestNeighbors.values()){
                drawCityConnection(c,n);
            }
        }
    }

    private void initCountry() {
        int amtCities=cities.size();
        CityCountry.minRegions = (amtCities>0)? amtCities/6: 1;
        CityCountry.maxRegions = CityCountry.minRegions*1;
        country=new CityCountry(this.cities);
        country.initAll();
        country.draftAll();
        evolver=new CityCountryEvolver(country);
        evolver.evolveMultipleGenerations();
        country=evolver.getBest();
        System.out.printf("Best country after %d generations of evolution:\n",CityCountryEvolver.AMT_GENS_TO_EVOLVE_COUNTRY);        
        country.print(); 
        System.out.println();
    }

    private void drawRegionConnections() {  
        if(!Drawer.SHOULD_SHOW_NEIGHBOR_CONNECTIONS)
            return;
        Stack<City> cityStack=new Stack<>();
        cities.clearRegionDrawnFlags();
        for(CityRegion rgn: country){
            if(rgn.isEmpty())
                continue;
            for(City c: rgn){
                if(c==null)
                    continue;
                cityStack.push(c);
            }            
            while(!cityStack.isEmpty()){
                City c=cityStack.pop();
                if(c==null||c.neighbors==null||c.neighbors.closestNeighbors==null)
                    continue;
                ArrayList<CityConnection> connections=new ArrayList<>();
                for(City n:c.neighbors.closestNeighbors.values()){
                    if(n==null)
                        continue;
                    //if neighbor has the same region as current, draw a line and push that vetted neighbor
                    
                    CityConnection curConnection=new CityConnection(c,n);
                    CityConnection curConnectionReverse=new CityConnection(n,c);
                    boolean shouldDraw=!connections.contains(curConnection);
//                    if(n.getRegionAllegianceInCountry(country)==rgn&&!(n.hasBeenDrawnInActiveRegion&&c.hasBeenDrawnInActiveRegion)){
                    if(n.getRegionAllegianceInCountry(country)==rgn&&shouldDraw){
                        connections.add(curConnection);
                        drawRegionCityConnection(rgn,c,n);
                        c.hasBeenDrawnInActiveRegion=true;
                        if(!n.hasBeenDrawnInActiveRegion){
                            n.hasBeenDrawnInActiveRegion=true;
                            cityStack.push(n);                        
                        }
                    }
                }
            }
        }
    }
}
