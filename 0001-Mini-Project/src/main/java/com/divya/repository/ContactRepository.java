package com.divya.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.divya.binding.Contact;


public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
