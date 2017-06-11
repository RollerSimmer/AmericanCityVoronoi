/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myutil;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author rollersimmer
 */
public class MyColorList extends ArrayList<MyColor> {
    public MyColorList(){
        super();
    }

    void sortBySeparationFromTargetList(MyColorList cl) {
        MyColorSeparationComparator comparator=new MyColorSeparationComparator(cl);
        Collections.sort(this,comparator);
    }

    void cullTo(int targetSize) {
        while(size()>targetSize){
            removeLast();
        }
    }

    private int calcSpawnParentIndex() {
        int lastIndex=size()-1;
        int amtBellSamples=3;
        int result=MyRandom.nextBell(-lastIndex,lastIndex,amtBellSamples);
        result=Math.abs(result);
        return result;
    }

    void spawnDerivativeColors(int amtDerivatives) {
        for(int i=0;i<amtDerivatives;i++){
            spawnSingleDerivativeColor();
        }
    }

    MyColor getFirst() {
        MyColor result=null;
        if(size()>0){
            return get(0);
        }
        return result;
    }

    private void removeLast() {
        if(size()>0){
            remove(size()-1);
        }
    }

    private void spawnSingleDerivativeColor() {
        if(size()==0) {
            int avgLight1000=500;
            add(MyColorFactory.createRandomly(avgLight1000));
            return;
        }
        int parentIndex=calcSpawnParentIndex();
        MyColor spawn=MyColorFactory.createDerivative(get(parentIndex), true);
        add(spawn);
    }
    
    @Override
    public String toString(){
        String result="ColorList:{";
        int i=0;
        for(MyColor c: this){
            result+=c.toString();
            i++;
            if(i<size())
                result+=",";
        }
        result+="}";
        return result;        
    }
}
