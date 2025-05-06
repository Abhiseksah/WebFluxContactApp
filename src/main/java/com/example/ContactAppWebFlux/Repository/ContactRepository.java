package com.example.ContactAppWebFlux.Repository;

import com.example.ContactAppWebFlux.model.Contact;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends ReactiveCrudRepository<Contact,Long> {

}
