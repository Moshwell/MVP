package com.project.MVP;

import org.springframework.data.repository.CrudRepository;

import com.project.MVP.CompteCourant;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
public interface CompteCourantRepository extends CrudRepository<CompteCourant, Integer> {

}
