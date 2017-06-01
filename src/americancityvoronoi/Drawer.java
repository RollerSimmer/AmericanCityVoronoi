/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import math.IntVector2;
import math.Point2;
import math.Point2List;
import myutil.MyRandom;

/**
 *
 * @author rollersimmer
 */
public class Drawer extends JComponent {
    public static final int LINE_CLOSENESS_THRESHOLD=3;
    private final int SQUARE_SHIFT=4;
    private final int SQUARE_SIZE=1<<SQUARE_SHIFT;
    private final int DIAGRAM_PIXEL_SIZE=3;
    
    private CityList cities;
    private Graphics g;
    private IntVector2 extents;
    private IntVector2 scaledExtents;
    private ClosestCityMap ccmap;
    
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
        if(extents.x==0||extents.y==0)
            img=null;
        else
            img=new BufferedImage(scaledExtents.x,scaledExtents.y,BufferedImage.TYPE_3BYTE_BGR);
        initClosestCityMap();        
        gridColor=Color.GRAY.brighter();
        geoList=NorthAmericanGeographicListFactory.create();
        geoList.scaleAll(DIAGRAM_PIXEL_SIZE);
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
        this.g = img.createGraphics();
        drawCityVoronoi();
        this.g.dispose();
        repaint();
    }    

    private void drawCityVoronoi() {
        if(cities.size()==0)
            return;
        drawVoronoiDiagramLines();
        drawGeographicShapes();
        drawCityNames();
        drawCityDots();
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
                if(y==60&&x==15){
                    System.out.print("");
                }
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
                        drawDiagramPixel(x,y,ccp.closestCity.color);
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
            drawCenteredText(c.name,namePos,c.color.darker());
        }
    }

    private void drawCityDots() {
        this.g.setFont(Font.getFont(Font.MONOSPACED));
        for(City c:cities){         
            IntVector2 dotPos=IntVector2.scale(c.pos,DIAGRAM_PIXEL_SIZE);
            g.setColor(c.color.somewhatBrighter());
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
}
