/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package onetomanyBD;

import java.util.List;
import java.util.Set;

public class Person 
{
        private long personId;
        private String name;
        private long phone;
        private  Set<Address> addresses;
        
      	
		public Set<Address> getAddresses() {
			return addresses;
		}

		public void setAddresses(Set<Address> addresses) {
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
    
 
        

