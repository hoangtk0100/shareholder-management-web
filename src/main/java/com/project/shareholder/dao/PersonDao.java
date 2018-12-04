package com.project.shareholder.dao;

import com.project.shareholder.common.CommonHibernateInterface;
import com.project.shareholder.exception.DatabaseException;
import com.project.shareholder.model.Person;

import java.io.Serializable;
import java.util.UUID;

public interface PersonDao extends CommonHibernateInterface<Serializable, Person> {
    // Retrieve person by id
    Person retrieveById(UUID id) throws DatabaseException;

    // Retrieve person by phone number
    Person retrieveByPhoneNumber(String phoneNumber) throws DatabaseException;

    // Retrieve person by username
    Person retrieveByUsername(String username) throws DatabaseException;
}