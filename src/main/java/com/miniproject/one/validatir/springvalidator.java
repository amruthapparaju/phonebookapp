package com.miniproject.one.validatir;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.miniproject.one.dto.ContactDTO;


@Component
public class springvalidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("springvalidator.supports()");
		return clazz.isAssignableFrom(ContactDTO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ContactDTO cstmr=null;
		cstmr=(ContactDTO)target;
		   //enable Serrver side form validations only when  client side form validations are not done
		 // if(cstmr.getCustflag().equalsIgnoreCase("no")) {
			   System.out.println("springvalidator.validate()--->server form validations are happening");
		      //server side form validations..
			   
			  System.out.println(cstmr.getContactName()+"==="+cstmr.getContactEmail()); 
			  
		      if(cstmr.getContactName()==null || cstmr.getContactName().equalsIgnoreCase("") || cstmr.getContactName().length()==0)
			     errors.rejectValue("contactName","contact.name.required");
		    System.out.println("springvalidator.validate()"+cstmr.getContactEmail());
		      if(cstmr.getContactEmail()==null || cstmr.getContactEmail().equalsIgnoreCase("") || cstmr.getContactEmail().length()==0)
				   errors.rejectValue("contactEmail","email.required");
			    System.out.println("springvalidator.validate()"+cstmr.getContactEmail());
			      if(cstmr.getContactNumber()==null)
			   errors.rejectValue("contactNumber","number.required");
			    System.out.println("springvalidator.validate()"+cstmr.getContactNumber());

		
	}


}