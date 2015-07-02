/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idbag;

import java.util.ArrayList;
import java.util.Collection;

 
public class BagParent {

    private int id;

    
    public int getId() {
        return id;
    }

     
    public void setId(int id) {
        this.id = id;
    }
////
    private Collection bagImages=new ArrayList();

    public Collection getBagImages() {
        return bagImages;
    }

    public void setBagImages(Collection bagImages) {
        this.bagImages = bagImages;
    }

    

    

}
