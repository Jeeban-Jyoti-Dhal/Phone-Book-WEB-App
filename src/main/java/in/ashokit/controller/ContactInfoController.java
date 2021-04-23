package in.ashokit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.constraints.AppConstant;
import in.ashokit.entity.Contact;
import in.ashokit.properties.AppProperties;
import in.ashokit.service.ContactService;

@Controller
public class ContactInfoController {

	private ContactService service;
	private AppProperties props;

	public ContactInfoController(ContactService service, AppProperties props) {
		this.service = service;
		this.props = props;
	}

	@GetMapping("/load-form")
	public String loadForm(Model model) {
		Contact contactObj = new Contact();
		model.addAttribute(AppConstant.CONTACT, contactObj);
		return AppConstant.CONTACT;
	}

	@PostMapping("/saveContact")
	public String handleSubmitButton(Contact contact, Model model) {
		System.out.println(contact);
		Integer cId = contact.getContactId();
		boolean isSaved = service.saveOrUpdateContact(contact);
		Map<String, String> messages = props.getMessages();
		if (isSaved) {
			if (cId == null) {
				model.addAttribute("succMsg", messages.get("contactSavedSucc"));
			} else {
				model.addAttribute("updateSucc", messages.get("contactUpdateSucc"));
			}
		} else {
			model.addAttribute("failMsg", messages.get("contactSaveFail"));
		}
		return AppConstant.CONTACT;
	}

	@GetMapping("/view-contacts")
	public String handleViewContactHyperlink(Model model) {
		List<Contact> allContacts = service.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return "display-allcontacts";
	}
}
