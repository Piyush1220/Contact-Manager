package com.scm.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;
//import java.util.logging.Logger;

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    //this class create User Id auto
    //Id is created in String because we use String ID

    private Logger log = LoggerFactory.getLogger(UserEventHandler.class);

    @HandleBeforeCreate
    public void handleBeforeCreate(User user)
    {
        //this is create the user id auto
        log.info("going to create user");
        user.setId(UUID.randomUUID().toString());
    }
}
