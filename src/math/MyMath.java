package math;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rollersimmer
 */
public class MyMath {
    
 

    // function partition(list, left, right, pivotIndex)
    //     pivotValue := list[pivotIndex]
    //     swap list[pivotIndex] and list[right]  // Move pivot to end
    //     storeIndex := left
    //     for i from left to right-1
    //         if list[i] < pivotValue
    //             swap list[storeIndex] and list[i]
    //             increment storeIndex
    //     swap list[right] and list[storeIndex]  // Move pivot to its final place
    //     return storeIndex

    public static int partition(IntegerList il,int left,int right,int pivotIndex){
        int pivotValue=il.get(pivotIndex);
        il.swap(pivotIndex,right);  // move pivot to end
        int storeIndex=left;
        for(int i=left;i<right;i++){
            if(il.get(i)<pivotValue){
                il.swap(storeIndex,i);
                storeIndex++;
            }            
        }
        il.swap(right,storeIndex);
        return storeIndex;
    }
    
    // function select(list, left, right, k)
    //     loop
    //         if left = right
    //             return list[left]
    //         pivotIndex := ...     // select pivotIndex between left and right
    //         pivotIndex := partition(list, left, right, pivotIndex)
    //         if k = pivotIndex
    //             return list[k]
    //         else if k < pivotIndex
    //             right := pivotIndex - 1
    //         else
    //             left := pivotIndex + 1
    
    public static int median(IntegerList ilOriginal){
        IntegerList il=new IntegerList(ilOriginal);
        if(il.size()==0)
            return 0;
        int left=0;
        int right=il.size()-1;
        int k=il.size()/2;
        int pivotIndex;
        boolean done=false;
        while(!done){
            if(left==right)
                return il.get(left);
            pivotIndex=(left+right)/2;
            pivotIndex=partition(il,left,right,pivotIndex);    
            if(k==pivotIndex){
                return il.get(k);
            } else if(k<pivotIndex){
                right = pivotIndex-1;                
            } else {
                left=pivotIndex+1;
            }
        }
        try{
            return il.get(il.size()/2);
        }catch(NullPointerException ex){
            return 0;
        }
    }    

    public static int intSqrt(int n) throws Exception {
        if(n<0)
            throw(new Exception("There is no real square root of a negative number."));
        if(n==1||n==0)
            return n;
        int guess=1;
        int guessSquared;
        int guessMinusOneSquared;
        int amtGuesses=0;
        boolean isDoneGuessing=false;
        final int MAX_GUESSES=10;
        while(!isDoneGuessing){
            guess=(guess+n/guess)>>1;
            guessSquared=guess*guess;
            guessMinusOneSquared=(guess-1)*(guess-1);
            ++amtGuesses;            
            isDoneGuessing = amtGuesses>MAX_GUESSES || (guessSquared>=n&&guessMinusOneSquared<n);
        }
        int result=guess;
        return result;
    }
    
    public static void main(String[] args){
        int root,n;
        for(n=0;n<100;n++){
            try{
                root=MyMath.intSqrt(n);
            } catch(Exception ex){
                root=0;
            }
            System.out.printf("intSqrt(%d)=%d,rootSquared=%d\n",n,root,root*root);
        }
    }
}
