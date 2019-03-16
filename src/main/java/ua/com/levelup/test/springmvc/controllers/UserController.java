package ua.com.levelup.test.springmvc.controllers;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.com.levelup.test.springmvc.model.User;
import ua.com.levelup.test.springmvc.repo.UserRepo;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class UserController {

    @Autowired
    private UserRepo userRepo;


    @GetMapping
    @ApiOperation(value = "View a list of available users",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public List<User> findAll(){
        return (List<User>) userRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Search a User with an ID",response = User.class)
    public User findOne(@PathVariable("id") Long id) {
        return userRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Add a product")
    public Long create(@RequestBody User resource) {
        return userRepo.save(resource).getId();
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody User resource) {
        resource.setId(id);
        userRepo.save(resource);
    }

    /**
     * Удаляет пользователя с указанным ид
     * @param id - уникальный номер записи
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        userRepo.deleteById(id);
    }


}
