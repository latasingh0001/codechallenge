package utilities;

import com.github.javafaker.Faker;

public class fakerdata {
		
	//Locale locale = new Locale("en-AU");
		Faker faker = new Faker();

		String fakename = faker.name().fullName(); 
		String fakefirstName = faker.name().firstName(); 
		String fakelastName = faker.name().lastName(); 
		String fakephonenumber = faker.phoneNumber().cellPhone();
		String fakeemail = faker.internet().emailAddress();
		String fakewebsite = faker.internet().url();
		String fakecompanyname = faker.company().name();
		String fakemessage = faker.lorem().sentence(); 
	}
