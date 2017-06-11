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
public class CityConnection {
    City a;
    City b;

    CityConnection(City a, City b) {
        this.a=a;
        this.b=b;
    }

    @Override
    public boolean equals(Object o) {
        try{
            if(CityConnection.class.isAssignableFrom(o.getClass())){
                CityConnection other=(CityConnection)o;
                return    (a==other.a && b==other.b) 
                       || (a==other.b && b==other.a);
            }
        }catch(NullPointerException ex){
        }
        return false;
    }

    @Override
    public String toString() {
        return "CityConnection{" + "a=\"" + a.name + "\", b=\"" + b.name + "\"}";
    }
}
