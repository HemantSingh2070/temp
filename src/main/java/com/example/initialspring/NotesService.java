//package com.example.initialspring;
//
//
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//@Service
//public class NotesService {
//
//    @Autowired
//    NotesRepository repo;
//
//    public void addnotes(notes note){
//        repo.save(note);
//    }
//
//    public List<notes> getnotes(String username){
//        user user = getuserById(username);
//        List<notes> list=new ArrayList<>();
//        for(ObjectId id:user.getnotesId()){
//            list.add
//        }
//        return
//    }
//
//    public void deletenotes(ObjectId id){
//        repo.deleteById(id.toString());
//    }
//
//    public user getuserById(String username) {
//        return userrepo.findById
//    }
//
//    public void createuser(user user)
//}
package com.example.initialspring;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    @Autowired
    NotesRepository notesRepo;
    getnotesId
    @Autowired
    UserRepository userRepo;

    public void addNote(notes note) {
        notesRepo.save(note);
    }

    public List<notes> getNotes(String username) {
        user user = getUserById(username);
        List<notes> list = new ArrayList<>();
        for (ObjectId id : user.()) {
            Optional<notes> noteOpt = notesRepo.findById(id.toString());
            noteOpt.ifPresent(list::add);
        }
        return list;
    }

    public void deleteNote(ObjectId id) {
        notesRepo.deleteById(id.toString());
    }

    public user getUserById(String username) {
        return userRepo.findById(username).orElse(null);
    }

    public void createUser(user user) {
        userRepo.save(user);
    }
}

