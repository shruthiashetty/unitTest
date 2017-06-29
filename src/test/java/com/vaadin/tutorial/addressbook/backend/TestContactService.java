package com.vaadin.tutorial.addressbook.backend;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestContactService {

	private ContactService contactService;
	
	private static final String VALID_DATA="contact{id=0, firstname=peter, lastname=moore, phone=+ 358 555 329, email=peter@moore.com}";
	private static final String IN_VALID_DATA="Contact{id=0, firstName=Thomas, lastName=Noor, phone=+ 358 555 329, email=thomas@noor.com, birthDate=Fri Jul 21 09:30:10 IST 1967}";
	private static final String EMPTY_DATA="";
	
	@Before
	public void setUp()
	{
		contactService=ContactService.createDemoService();
	}
	
	@Test
	public void testFindCustmrWithValidData()
	{
		String expectedData="[Contact{id=0, firstName=Peter, lastName=Moore, phone=+ 358 555 329, email=peter@moore.com}]";
		List<Contact> contactLst=contactService.findAll(VALID_DATA);
		assertTrue(!contactLst.isEmpty());
		assertTrue(contactLst.toString().contains(expectedData));
	}
	
	@Test
	public void testFindCustmrWithInValidData()
	{
		List<Contact> contactLst=contactService.findAll(IN_VALID_DATA);
		assertTrue(contactLst.isEmpty());
	}
	
	@Test
	public void testFindCustmrWithNullData()
	{
		List<Contact> contactLst=contactService.findAll(null);
		assertTrue(!contactLst.isEmpty());
	}
	
	@Test
	public void testFindCustmrWithEmptyData()
	{
		List<Contact> contactLst=contactService.findAll(EMPTY_DATA);
		assertTrue(!contactLst.isEmpty());
	}
}
