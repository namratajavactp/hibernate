/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package set;

import java.util.HashSet;
import java.util.Set;

 
public class SetParent {

    private int id;

     
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }
 
    private Set setImages=new HashSet();

    public Set getSetImages() {
        return setImages;
    }

    public void setSetImages(Set setImages) {
        this.setImages = setImages;
    }

}
