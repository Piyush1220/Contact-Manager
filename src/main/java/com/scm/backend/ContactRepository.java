package com.scm.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "contacts", collectionResourceRel = "contact")
public interface ContactRepository extends JpaRepository<Contact,String> {

    // /contacts/search/email ? email= abc@gmail.com

   @RestResource(path = "by-email",rel = "by-email")
   Contact findByEmail(@Param("email") String email);

   //findphone is long url so we used custom url path=by-phone is url,parameter is phone
    @RestResource(path = "by-phone",rel = "by-phone")
    Contact findByPhoneNumber(@Param("phone") String phoneNumber);

    @RestResource(path = "by-name")
    List<Contact> findByNameContainingIgnoreCase(@Param("name") String name);


}
