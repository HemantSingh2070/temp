package com.example.initialspring;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends MongoRepository<notes,String> {

}
