package com.miniproject.one.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.one.dto.ContactDTO;
import com.miniproject.one.entity.ContactEntity;
import com.miniproject.one.repo.ContactRepo;

@Service
public class ContactServiceimpl implements ContactService {

	
	@Autowired
	ContactRepo repo;
	@Override
	public boolean saveContact(ContactDTO dto) {
		ContactEntity entity = new ContactEntity();

		BeanUtils.copyProperties(dto, entity);

		ContactEntity save = repo.save(entity);
		
		System.out.println("ContactServiceimpl.saveContact()"+save);
		return save != null;

	}

	@Override
	public List<ContactDTO> GetAllContacts() {
		List<ContactDTO> Listdto = new ArrayList<ContactDTO>();
		List<ContactEntity> findAll = repo.findAll();
		findAll.forEach(dto1 -> {
			ContactDTO dto = new ContactDTO();

			BeanUtils.copyProperties(dto1, dto);
			Listdto.add(dto);
		});

		return Listdto;
	}

	@Override
	public ContactDTO GetContactById(Integer no) {
		System.out.println("ContactServiceimpl.GetContactById()"+no);
		ContactDTO dto = null;
		Optional<ContactEntity> result = repo.findById(no);
		if (result.isPresent()) {
			ContactEntity contactEntity = result.get();
			dto = new ContactDTO();
			BeanUtils.copyProperties(contactEntity, dto);
			return dto;

		}

		return null;
	}

	@Override
	public void DeleteContact(Integer no) {
		repo.deleteById(no);
	}

}
