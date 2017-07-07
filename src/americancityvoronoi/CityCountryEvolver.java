/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import myutil.MyRandom;

/**
 *
 * @author rollersimmer
 */
public class CityCountryEvolver extends ArrayList<CityCountry> {
    
    public final int TARGET_POPULATION=4;
    public final int MAX_POPULATION=TARGET_POPULATION*4;    
    boolean isDirty;
    public static int AMT_GENS_TO_EVOLVE_COUNTRY=200;
    
    public CityCountryEvolver() {
        super();
        isDirty=true;
    }
    
    public CityCountryEvolver(CityCountry initialCountry) {
        while(initialCountry.mergePunyNeighboringRegions());
        while(size()<TARGET_POPULATION){
            add(new CityCountry(initialCountry,initialCountry.allCities));
        }        
    }    
    
    public void sortByBalance() {
        Collections.sort(this,new CityCountryFitnessComparator());
        isDirty=false;
    }

    private static class CityCountryFitnessComparator implements Comparator<CityCountry> {        
        @Override
        public int compare(CityCountry a, CityCountry b) {
            int aFitness=a.calcFitness();
            int bFitness=b.calcFitness();            
            int result=aFitness-bFitness;
            return result;
        }
    }
    
    private int getBestBalance() {
        CityCountry best=this.getBest();
        int result=best.calcFitness();
        return result;
    }
 
    public void spawnFromParent(){
        if(size()==0)
            return;
        int highIndex=size()-1;
        int pickIndex=Math.abs(MyRandom.nextBell(-highIndex,highIndex));
        CityCountry newCountry = new CityCountry(this.get(pickIndex));
        newCountry.mutateMany();
        this.add(newCountry);
    }

    @Override
    public boolean add(CityCountry e) {
        isDirty=true;
        return super.add(e); //To change body of generated methods, choose Tools | Templates.
    }
    
    public CityCountry getBest(){
        if(isDirty)
            sortByBalance();
        return get(0);
    }
    
    public void spawnAll(){
        while(size()<MAX_POPULATION)
            spawnFromParent();
    }
    
    private void cull() {
        if(size()==0)
            return;
        remove(size()-1);
    }

    public void cullAll(){
        while(size()>TARGET_POPULATION)
            cull();                        
    }
    
    public void evolveSingleGeneration(){
        spawnAll();
        if(isDirty)
            sortByBalance();
        cullAll();
    }
    
    public void evolveMultipleGenerations(int amtGens){
//        print();
        if(amtGens==0)
            return;
        int lastBal=getBestBalance();
        evolveSingleGeneration();
        int curBal=getBestBalance();
        int balDelta=curBal-lastBal;
        final int CHANGE_THRESHOLD = -CityCountry.FITNESS_SCALE/200 ;  //each generation must improve by at least this much
        int gen=1;
        int improvementFailureCount=0;
        boolean doFirstTwoMatch = (size()>1)? (get(0).calcFitness()==get(1).calcFitness()): (size()==1);
        while((curBal>0) && (balDelta<=CHANGE_THRESHOLD || !doFirstTwoMatch || balDelta==0)){
            lastBal=curBal;
            evolveSingleGeneration();
            curBal=getBestBalance();
            balDelta=curBal-lastBal;
            ++gen;
            if(gen>=amtGens)
                break;
            if(balDelta==0)
                improvementFailureCount++;
            doFirstTwoMatch = (size()>1)? (get(0).calcFitness()==get(1).calcFitness()): (true);
        }
        System.out.printf("Evolved country %d generations.  Failed to improve %d times.\n",gen,improvementFailureCount);
//        for(int g=0;g<amtGens;g++){
//            evolveSingleGeneration();  
//            print();
//        }
        print();
    }
    
    public void evolveMultipleGenerations(){
        evolveMultipleGenerations(AMT_GENS_TO_EVOLVE_COUNTRY);
    }
    
    
    @Override
    public String toString(){
        String result="CityCountryEvolver:\n";
        for(int i=0;i<size();i++){
            try{
                CityCountry country=this.get(i);
                result+=String.format("[%d]: %s\n",i,country.toString());
            } catch(NullPointerException ex){
                continue;
            }
        }
        return result;
    }
    
    public void print(){
        System.out.println(toString());
    }
    
}
