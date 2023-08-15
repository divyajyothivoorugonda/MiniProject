package com.divya.service;
import java.util.List;
import java.util.Optional;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divya.binding.Contact;
import com.divya.repository.ContactRepository;
import com.divya.service.ContactService;


//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository repo;

	@Override
	public String saveContact(Contact contact) {
		contact = repo.save(contact);
		if(contact.getContactId()!=null)
		{
			return "Contasct saved";
		}
		else
		{
			return "Contact failed to save";
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = repo.findById(contactId);
		if(findById.isPresent())
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		if(repo.existsById(contact.getContactId()))
		{
			repo.save(contact);
			return "Update Success";
		}else {
			return "No record found";
		}
	}

	@Override
	public String deleteContactById(Integer contactId) {
		if(repo.existsById(contactId))
		{
			repo.deleteById(contactId);
			return "Record deleted";
		}else {
			return "No Record Found";
		}
	}

}
