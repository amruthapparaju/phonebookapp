package com.miniproject.one.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.one.dto.ContactDTO;
import com.miniproject.one.entity.ContactEntity;
import com.miniproject.one.exception.PhoneBookApplicationExcepyion;
import com.miniproject.one.repo.ContactRepo;

@Service
public class ContactServiceimpl implements ContactService {

	@Autowired
	ContactRepo repo;

	@Override
	public boolean saveContact(ContactDTO dto) {

		boolean isSaved = false;
		ContactEntity entity =null;
		entity= new ContactEntity();

		BeanUtils.copyProperties(dto, entity);

		try {
			ContactEntity save = repo.save(entity);
			if (save.getContactId() != null)
				isSaved = true;

		} catch (Exception e) {
			throw new PhoneBookApplicationExcepyion("save failed");
		}
		return isSaved;

	}

	@Override
	public List<ContactDTO> GetAllContacts() {
		List<ContactDTO> Listdto = new ArrayList<ContactDTO>();
		List<ContactEntity> findAll=null;
		try {
			 findAll = repo.findAll();
				if (findAll != null)
				{
			findAll.forEach(dto1 -> {
				ContactDTO dto = new ContactDTO();

				BeanUtils.copyProperties(dto1, dto);
				Listdto.add(dto);
			});
				}
		} catch (Exception e) {
			throw new PhoneBookApplicationExcepyion("no contacts found");
		}

		return Listdto;
	}

	@Override
	public ContactDTO GetContactById(Integer no) {
		ContactDTO dto = null;
		Optional<ContactEntity> result = repo.findById(no);
			if (result.isPresent()) {
			ContactEntity contactEntity = result.get();
			dto = new ContactDTO();
			BeanUtils.copyProperties(contactEntity, dto);
			return dto;

		}
			else
			throw new PhoneBookApplicationExcepyion("Did not find employee id - " + no);
		}

	

	@Override
	public void DeleteContact(Integer no) {
		repo.deleteById(no);
	}

}
