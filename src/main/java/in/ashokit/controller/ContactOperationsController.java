package in.ashokit.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.ashokit.entity.Contact;
import in.ashokit.properties.AppProperties;
import in.ashokit.service.ContactService;

@Controller
public class ContactOperationsController {
	private ContactService service;
	private AppProperties props;

	public ContactOperationsController(ContactService service, AppProperties props) {
		this.service = service;
		this.props = props;
	}

	@GetMapping("/edit")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
		Contact contactObj = service.getContactById(contactId);
		model.addAttribute("contact", contactObj);
		return "contact";
	}

	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid") Integer contactId, RedirectAttributes attributes) {
		boolean isDelete = service.deleteContactByid(contactId);
		Map<String, String> messages = props.getMessages();
		if (isDelete) {
			attributes.addFlashAttribute("deletesucc", messages.get("contactDeleteSucc"));
		} else {
			attributes.addFlashAttribute("deletefail", messages.get("contactDeleteFail"));
		}
		return "redirect:view-contacts";
	}
}
