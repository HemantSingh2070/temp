//package com.example.initialspring;
//
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class controll {
////    @GetMapping("/message")
////    public String message(){
////        return "Hello world";
////    }
//
//    @Autowired
//    NotesService service;
//
//    @PostMapping("/add/{username")
//    public String message(@RequestBody notes note,@PathVariable String username){
//        System.out.println(note.getContent());
//        service.addnotes(note);
//        user user = service.getuserById(username);
//        user.getnotesId().add(note.getId());
//        return note.getId().toString();
//    }
//
//    @GetMapping("/get")
//    public List<notes> getnotes(){
//        return service.getnotes();
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deletenotes(@PathVariable ObjectId id){
//        service.deletenotes(id);
//    }
//
//    @PostMapping("/create-user")
//    public void createuser(@RequestBody user user){
//        service.createuser(user);
//    }
//
//
//
//}
package com.example.initialspring;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controll {

    @Autowired
    NotesService service;

    @PostMapping("/add/{username}")
    public String addNote(@RequestBody notes note, @PathVariable String username) {
        System.out.println(note.getContent());
        service.addNote(note);

        user user = service.getUserById(username);
        if (user != null) {
            user.getnotesId().add(note.getId());
            service.createUser(user); // Save updated user with new note reference
        }

        return note.getId().toString();
    }

    @GetMapping("/get/{username}")
    public List<notes> getNotes(@PathVariable String username) {
        return service.getNotes(username);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNote(@PathVariable ObjectId id) {
        service.deleteNote(id);
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody user user) {
        service.createUser(user);
    }
}

