package com.example.ContactAppWebFlux.Controller;

import com.example.ContactAppWebFlux.Service.ContactService;
import com.example.ContactAppWebFlux.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public Mono<Contact> submitContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Contact> streamContacts() {
        return contactService.streamContacts();
    }
}
