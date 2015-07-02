/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hql;
public class Address
{
    private long addressId;
    private int doorNo;
    private String streetName;
    private String city;
    private String state;
    
    public Address(int doorno,String streetname,String city,String state)
    {
    	 this.doorNo=doorno;
    	 this.streetName=streetname;
    	 this.city=city;
    	 this.state=state;
     }
   
    public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

    public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	    
}
