package com.bhoopathy.portfolio.service;

import com.bhoopathy.portfolio.dto.Dtos.*;
import com.bhoopathy.portfolio.model.Contact;
import com.bhoopathy.portfolio.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public ApiResponse submitContact(ContactRequest req) {
        if (req.getName() == null || req.getEmail() == null || req.getMessage() == null) {
            return new ApiResponse(false, "Name, email and message are required.");
        }

        Contact contact = Contact.builder()
                .name(req.getName())
                .email(req.getEmail())
                .subject(req.getSubject())
                .message(req.getMessage())
                .build();

        contactRepository.save(contact);
        return new ApiResponse(true, "Message received! Bhoopathy will get back to you soon.");
    }
}
