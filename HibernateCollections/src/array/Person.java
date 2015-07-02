/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package array;

import java.util.List;


public class Person 
{
        private long personId;
        private String name;
        private long phone;
        private  Address[] addresses;
        
      
		public Address[] getAddresses() {
			return addresses;
		}

		public void setAddresses(Address[] addresses) {
			this.addresses = addresses;
		}

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

		

   
  }
    
 
        

