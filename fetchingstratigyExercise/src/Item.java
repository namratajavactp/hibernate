/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Set;
 
public class Item {
    private int itemid;
    private String name;
    private Set bids;

    public Set getBids() {
        return bids;
    }

    public void setBids(Set bids) {
        this.bids = bids;
    }
    public void addBid(Bid bid){
        bid.setItemid(this);
        bids.add(bid);
    }
    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return itemid+" "+ name;
    }
}
