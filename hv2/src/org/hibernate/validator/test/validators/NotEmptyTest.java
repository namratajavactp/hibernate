package org.hibernate.validator.test.validators;

import junit.framework.TestCase;
import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;


public class NotEmptyTest extends TestCase {
	
	public void testBigInteger() throws Exception {
		Car car=new Car();
		ClassValidator<Car> classValidator = new ClassValidator<Car>( Car.class );
		InvalidValue[] invalidValues = classValidator.getInvalidValues( car );
		System.out.println(invalidValues.length);
		
		assertEquals( 2, invalidValues.length );
		car.name = "";
		invalidValues = classValidator.getInvalidValues( car );
		System.out.println(invalidValues.length);
		assertEquals( 2, invalidValues.length );
		car.name = "350Z";
		invalidValues = classValidator.getInvalidValues( car );
		System.out.println(invalidValues.length);
		assertEquals( 1, invalidValues.length );
		car.insurances = new String[0];
		invalidValues = classValidator.getInvalidValues( car );
		System.out.println(invalidValues.length);
		assertEquals( 1, invalidValues.length );
		car.insurances = new String[1];
		invalidValues = classValidator.getInvalidValues( car );
		System.out.println(invalidValues.length);
		assertEquals( 0, invalidValues.length );
	}
}
