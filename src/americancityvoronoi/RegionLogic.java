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
enum RegionLogic {
    IS_IN_REGION,
    NOT_IN_REGION;

    static boolean logicOp(CityRegion region, CityRegion regionToCompare, RegionLogic logic) {
        switch(logic){
            case IS_IN_REGION:
                return region==regionToCompare;
            case NOT_IN_REGION:
                return region!=regionToCompare;
        }
        return false;
    }
}
