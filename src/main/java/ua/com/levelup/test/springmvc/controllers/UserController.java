package ua.com.levelup.test.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ua.com.levelup.test.springmvc.model.User;
import ua.com.levelup.test.springmvc.repo.UserRepo;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "users api", description = "Controller for operations in users-table")
public class UserController {

    @Autowired
    private UserRepo userRepo;


    @ApiOperation(value = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping
    public List<User> findAll(){
        return (List<User>) userRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get user by id", response = User.class)
    public User findOne(@PathVariable("id") @ApiParam(value = "id of user", required = true, type = "long") Long id) {
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
