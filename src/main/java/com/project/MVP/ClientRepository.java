package com.project.MVP;

import org.springframework.data.repository.CrudRepository;

import com.project.MVP.Client;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ClientRepository extends CrudRepository<Client, Integer> {

}
