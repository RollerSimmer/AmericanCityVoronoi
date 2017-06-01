/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

/**
 *
 * @author rollersimmer
 */
public class ClosestCityQueueEntry {
    public ClosestCityPair ccp;
    public City candidate;

    public ClosestCityQueueEntry(ClosestCityPair ccp, City candidate) {
        this.ccp = ccp;
        this.candidate = candidate;
    }
}
