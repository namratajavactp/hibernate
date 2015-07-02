/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

import java.util.HashMap;
import java.util.Map;

 
public class MapParent {

    private int id;

    
    public int getId() {
        return id;
    }

     
    public void setId(int id) {
        this.id = id;
    }
 
    private Map mapImages=new HashMap();

    public Map getMapImages() {
        return mapImages;
    }

    public void setMapImages(Map mapImages) {
        this.mapImages = mapImages;
    }


}
