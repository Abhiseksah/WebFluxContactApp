package com.example.ContactAppWebFlux.Service;

import com.example.ContactAppWebFlux.Repository.ContactRepository;
import com.example.ContactAppWebFlux.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    private final Sinks.Many<Contact> sink = Sinks.many().multicast().onBackpressureBuffer();

    public Mono<Contact> saveContact(Contact contact) {
        return contactRepository.save(contact)
                .doOnNext(sink::tryEmitNext);
    }

    public Flux<Contact> streamContacts() {
        return sink.asFlux();
    }
}
