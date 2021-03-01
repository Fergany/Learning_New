URL: https://www.lynda.com/Spring-tutorials/Spring-Test-Driven-Development-JUnit/614314-2.html

Why TDD Matters?
"what's part of application need a unit test?,
the part u want it to work
what is coverage??
80%?? "

Test planning for @Service components


planning feature development, User Stroies.

Plan Ahead: Questions to Ask yourself:
- What features/components need test coverage most?
- What are the high priority test cases?
- What type of test is needed? Unit? Integration? Both?
// for controller
- What kinds of @controller are invloved: MVC, RESTful, or both?
Returned by MVC @controller
ViewModel object(s)
// for @Repository
- What type of persistence layer: relational, graph, or both?

Returned by REST @controller
JSON or XML

Integration Test:
Test interaction between units.

Unit Test:
Test a Single Unit.

Writing integration tests for @Service
=======================================
`	

we want to also instruct JUnit to just load the components that we care about most, and ignore the ones that we don't care about. 
by adding the webEnvironment attribute. And we're going to tell it exactly what kind of web environment we want loaded during our test, which for our purposes, it's none. This means none of our controller components will be loaded, which is exactly what we want.

For our simple example, there's not much gain there, because we don't have any or many controller components to begin with But in a real world scenario, this could become very useful when you really want to make sure that only what you need to load gets loaded during the test. 


package com.hanselnpetal.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.hanselnpetal.domain.CustomerContact;




// we are testing a Spring application
@RunWith(SpringRunner.class)
// let JUnit know that not only are we testing a Spring application, but this is a Spring Boot application
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
// as we will test Service only, so don't load the controllers


public class ContactsManagementServiceIntegrationTest {
	
	@Autowired
	private ContactsManagementService contactsManagementService;
	
	
	@Test
	public void testAddContactHappyPath() {
		
		// Create a contact
		CustomerContact aContact = new CustomerContact();
		aContact.setFirstName("Jenny");
		aContact.setLastName("Johnson");


		CustomerContact newCustomerContact = contactsManagementService.add(aContact);
		assertNotNull(newCustomerContact);
		assertNotNull();
		
		// Test adding the contact
		
		
		// Verify the addition
		//assertNotNull(newContact);
		//assertNotNull(newContact.getId());
		//assertEquals("Jenny", newContact.getFirstName());
		
	}
}


Write Unit Tests for Spring @Service Component:
=====================================

package com.hanselnpetal.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.hanselnpetal.data.repos.CustomerContactRepository;
import com.hanselnpetal.domain.CustomerContact;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
//  we don't want any controllers or servlet like components to load during our test.

public class ContactsManagementServiceUnitTest {
	
	@Mock
	private CustomerContactRepository customerContactRepository;
	
	@InjectMocks
	private ContactsManagementService contactsManagementService;
	
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddContactHappyPath() {
		
		// Create a contact
		CustomerContact aMockContact = new CustomerContact();
		aMockContact.setFirstName("Jenny");
		aMockContact.setLastName("Johnson");
		
		when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(aMockContact);
				
		// Save the contact
		CustomerContact newContact = contactsManagementService.add(null);
		
		
		// Verify the save
		assertEquals("Jenny", newContact.getFirstName());
	}
}


Write integration tests for @Controller
======================================

Write unit tests for @Controller
================================

Test planning for @Repository componenets:
- Only integration Test, no unit testing needed. 

