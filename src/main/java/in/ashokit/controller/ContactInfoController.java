package in.ashokit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.Contact;
import in.ashokit.service.ContactService;

@Controller
public class ContactInfoController {

	private ContactService service;

	public ContactInfoController(ContactService service) {
		this.service = service;
	}

	@GetMapping("/load-form")
	public String loadForm(Model model) {
		Contact contactObj = new Contact();
		model.addAttribute("contact", contactObj);
		return "contact";
	}

	@PostMapping("/saveContact")
	public String handleSubmitButton(Contact contact, Model model) {
		System.out.println(contact);
		boolean isSaved = service.saveOrUpdateContact(contact);
		if (isSaved) {
			model.addAttribute("succMsg", "Contact Saved");
		} else {
			model.addAttribute("failMsg", "Failed to Save the record");
		}
		return "contact";
	}

	@GetMapping("/view-contacts")
	public String handleViewContactHyperlink(Model model) {
		List<Contact> allContacts = service.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return "display-allcontacts";
	}
}
