package com.scm.backend;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RepositoryEventHandler(Contact.class)
public class ContactEventHandler {

    @HandleBeforeCreate
    public void beforeSave(Contact contact)
    {
        contact.setId(UUID.randomUUID().toString());
    }

}
