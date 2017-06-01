/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import java.util.Comparator;

/**
 *
 * @author rollersimmer
 */
public class CityPopulationComparator implements Comparator<City> {

    @Override
    public int compare(City a, City b) {
        if(a==null&&b==null) return 0;
        if(a==null&&b!=null) return -1;
        if(a!=null&&b==null) return 1;
        return b.pop100k-a.pop100k;
    }
    
}
