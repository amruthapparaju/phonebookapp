package com.miniproject.one.service;

import java.util.List;

import com.miniproject.one.dto.ContactDTO;

public interface ContactService {
	
	boolean saveContact(ContactDTO dto);
	List<ContactDTO> GetAllContacts();
	ContactDTO GetContactById(Integer no);
	//boolean UpdateContact(ContactDTO dto);
	void DeleteContact(Integer no);


}
