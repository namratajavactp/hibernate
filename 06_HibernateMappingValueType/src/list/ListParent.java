/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

 
public class ListParent {

    private int id;

     
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }
 
    private List listImages=new ArrayList();

    public List getListImages() {
        return listImages;
    }

    public void setListImages(List listImages) {
        this.listImages = listImages;
    }
    
    
}
