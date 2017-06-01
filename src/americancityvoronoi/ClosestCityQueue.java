/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.util.concurrent.LinkedBlockingQueue;
import math.PointNav2;

/**
 *
 * @author rollersimmer
 */
public class ClosestCityQueue extends LinkedBlockingQueue<ClosestCityQueueEntry> {

    void insertAllCitiesFromList(CityList cl, ClosestCityMap ccm) {
        ClosestCityPair ccp;
        for(City c:cl){
            ccp=ccm.get(c.pos);
            if(ccp==null)
                continue;
            this.add(new ClosestCityQueueEntry(ccp,c));
        }
    }

    void suggestNewEntry(ClosestCityMap ccm, PointNav2 newPt, ClosestCityQueueEntry curEntry) {
        ClosestCityQueueEntry newEntry;
        if(ccm.isPointInBounds(newPt)){
            newEntry=new ClosestCityQueueEntry(ccm.get(newPt),curEntry.candidate);
            if(!newEntry.ccp.doesContain(curEntry.candidate)){
                this.add(newEntry);
            }            
        }
    }
    
}
