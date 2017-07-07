/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.util.ArrayList;

/**
 *
 * @author rollersimmer
 */

public class IntegerList extends ArrayList<Integer> {

    public IntegerList(){
        super();
    }
    
    public IntegerList(int... valList){
        for(int val:valList){
            add(val);
        }
    }

    IntegerList(IntegerList ilCopy) {
        super();
        for(int val:ilCopy){
            add(val);
        }
    }

    public boolean isValidIndex(int i){
        return (i>=0&&i<size());
    }

    public boolean swap(int i,int j){
        if(!isValidIndex(i)||!isValidIndex(j))
            return false;
        int tmp=get(i);
        set(i,get(j));
        set(j,tmp);
        return true;
    }  

    @Override
    public String toString() {
        String result="";
        result+="(";
        for(int i=0;i<size();i++){
            int val=get(i);
            result+=Integer.toString(val);
            if(i<size()-1)
                result+=",";
        }
        result+=")";
        return result;
    }
}  