package com.miniproject.one.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.miniproject.one.dto.ContactDTO;
import com.miniproject.one.service.ContactService;
import com.miniproject.one.validatir.springvalidator;

@Controller	 
public class LoginController {
	@Autowired
	private ContactService service;
	@Autowired
	private springvalidator validator;
	
	@GetMapping(value = { "/", "/login.htm" } )
	public String showForm( @ModelAttribute("Contactcmd") ContactDTO cmd) {
		ContactDTO  details = new ContactDTO();
		//model.addAttribute("Contactcmd", details);
//System.out.println("LoginController.showForm()111111111111111");
		return "contactinfo";
	}

	@PostMapping("/login.htm") // post back request..
	public String handleSubmitBtn( @ModelAttribute("Contactcmd") ContactDTO cmd,RedirectAttributes attribures,BindingResult br) {
		//System.out.println("LoginController.handleSubmitBtn()22222222222222222222222222222");
		
		/*
		 * if(validator.supports(ContactDTO.class)) {
		 * 
		 * validator.validate(cmd, br); return "contactinfo"; }
		 */

		boolean resultMsg = service.saveContact(cmd);
		if (resultMsg)
			// model.addAttribute("successmsg","contacts saved");
			attribures.addFlashAttribute("succMag", "Contact Register Successfully");
		else
			attribures.addFlashAttribute("errMag", "Contact Not Registred");

		//map.put("resultMsg", resultMsg);
		return "redirect:/success";
	}
	@GetMapping("/success")
	public String ContactSaved( @ModelAttribute("Contactcmd") ContactDTO cmd) {
		return "contactinfo";
	}

	@GetMapping("/viewContacts")
	String handleViewContactsLink(Model model) {

		List<ContactDTO> getAllContacts = service.GetAllContacts();

		model.addAttribute("contacts", getAllContacts);
		return "viewContacts";
	}

	

}
