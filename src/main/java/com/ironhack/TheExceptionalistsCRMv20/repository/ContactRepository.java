package com.ironhack.TheExceptionalistsCRMv20.repository;

import com.ironhack.TheExceptionalistsCRMv20.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
