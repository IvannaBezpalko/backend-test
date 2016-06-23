package com.prototype.controllers;

//import com.fasterxml.jackson.core.JsonFactory;
//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prototype.dao.Role;
import com.prototype.dao.User;
import com.prototype.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


import java.util.HashMap;
import java.util.Set;

/**
 * Created by Ivanna on 25.05.2016.
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllUsers() throws JsonProcessingException {
        List<User> users = userService.findAll();
        return mapper.writeValueAsString(users);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(@RequestParam(value = "id",required = false,
            defaultValue = "0") Integer id)throws JsonProcessingException {
        User user = userService.findById(id);
        return mapper.writeValueAsString(user);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    private String createUser(@RequestParam(value = "name",required = true,
            defaultValue = "") String name, @RequestParam(value = "passWord",required = true,
            defaultValue = "") String passWord, @RequestParam(value = "isActive",required = false,
            defaultValue = "1") Boolean isActive) throws JsonProcessingException {
        User user = new User(name, passWord, isActive);
        userService.persist(user);
        return mapper.writeValueAsString(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    private ResponseEntity<User> update(@RequestBody User user) {
        if (user != null) {
            userService.update(user);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    private ResponseEntity<User> delete(@RequestBody User user) {
        if (user != null) {
            userService.delete(user);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @RequestMapping(value = "/user/{id}/roles", method = RequestMethod.GET)
//    public String getUserRoles(@RequestParam(value = "id",required = false,
//            defaultValue = "0") Integer id)throws JsonProcessingException {
//        Set<Role> roles = userService.getRoles(id);
//        return mapper.writeValueAsString(roles);
//    }
}
