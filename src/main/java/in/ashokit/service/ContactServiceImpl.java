package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Contact;
import in.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactRepository repository;

	public ContactServiceImpl(ContactRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean saveOrUpdateContact(Contact contact) {
		Contact savedObj = repository.save(contact);
		/*
		 * if (savedObj.getContactId() != null) { // #1 return true; } else { return
		 * false; }
		 */

		/* return (savedObj.getContactId()!=null ? true :false); */ // #2

		return savedObj.getContactId() != null;
	}

	@Override
	public List<Contact> getAllContacts() {
		/*
		 * List<Contact> findAll = repository.findAll(); return findAll;
		 */
		return repository.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = repository.findById(contactId);

		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteContactByid(Integer contactId) {
		boolean isDeleted = false;
		try {
			repository.deleteById(contactId);
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isDeleted;
	}

}
