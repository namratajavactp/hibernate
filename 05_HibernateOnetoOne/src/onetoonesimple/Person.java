/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package onetoonesimple;
public class Person {
        private long personId;
        private String name;
        private long phone;
        private Address address;
        
        public long getPersonId() {
			return personId;
		}

		public void setPersonId(long personId) {
			this.personId = personId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getPhone() {
			return phone;
		}

		public void setPhone(long phone) {
			this.phone = phone;
		}

		

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
              this.address=address;
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return personId+" "+name+" "+phone;
	}

  }
    
 
        

