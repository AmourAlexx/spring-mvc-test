package ua.com.levelup.test.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.levelup.test.springmvc.model.User;
import ua.com.levelup.test.springmvc.repo.UserRepo;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll(){
        return (List<User>) userRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findOne(@PathVariable("id") Long id) {
        return userRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody User resource) {
        return userRepo.save(resource).getId();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody User resource) {
        resource.setId(id);
        userRepo.save(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        userRepo.deleteById(id);
    }

}
