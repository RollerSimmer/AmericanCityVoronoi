/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myutil;

import java.util.Comparator;

/**
 *
 * @author rollersimmer
 */
class MyColorSeparationComparator implements Comparator<MyColor> {
    
    public MyColorList colorList;

    MyColorSeparationComparator(MyColorList colorList) {
        this.colorList=colorList;
    }
    
    @Override
    public int compare(MyColor a, MyColor b) {
        int aCloseness=MyColor.calcDistFromListMembers(a,colorList);
        int bCloseness=MyColor.calcDistFromListMembers(b,colorList);
        return bCloseness-aCloseness;
    }    
}
