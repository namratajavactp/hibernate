/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manytoonebidirectionalConfiguration;


public class Bid {
    private int bidid;
    private Item itemid;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getBidid() {
        return bidid;
    }

    public void setBidid(int bidid) {
        this.bidid = bidid;
    }

    public Item getItemid() {
        return itemid;
    }

    public void setItemid(Item itemid) {
        this.itemid = itemid;
    }

    @Override
    public String toString() {
        return bidid+" "+itemid+" "+ amount;
    }

    
}
