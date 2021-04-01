package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Contact;

public interface ContactService {
	
	public boolean saveOrUpdateContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer contactId);
	
	public boolean deleteContactByid(Integer contactId);
}
