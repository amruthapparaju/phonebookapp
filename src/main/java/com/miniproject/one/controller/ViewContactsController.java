package com.miniproject.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miniproject.one.dto.ContactDTO;
import com.miniproject.one.service.ContactService;

@Controller
public class ViewContactsController {
	
	@Autowired
	private ContactService serv;

	@GetMapping(value = "/editcontact")
	public String editContact(@RequestParam("contactId") Integer contactId,  Model model)
	{
		ContactDTO getContactById = serv.GetContactById(contactId);
		System.out.println(getContactById);
		model.addAttribute("Contactcmd",getContactById);
		
		//System.out.println("ViewContactsController.editContact()111111111111111");
		return "contactinfo";

	}

	/*
	 * @PostMapping public String updateContact(ContactDTO c, Model model) { return
	 * null;
	 * 
	 * }
	 */	@GetMapping("/deletecontact")
	public String deleteContact(@RequestParam("contactId") int contactId )
	{
		 serv.DeleteContact(contactId);
		 
			return "redirect:/viewContacts";

	}

}
 