package com.prototype.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prototype.dao.Role;
import com.prototype.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ivanna on 27.05.2016.
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllRoles() throws JsonProcessingException {
        List roles = roleService.findAll();
        return mapper.writeValueAsString(roles);
    }

     @RequestMapping(value = "/role", method = RequestMethod.GET)
    private String getRole(@RequestParam(value = "id",required = false,
            defaultValue = "0") Integer id) throws JsonProcessingException {
        Role role = roleService.findById(id);
         return mapper.writeValueAsString(role);
    }

     @RequestMapping(value = "/create", method = RequestMethod.GET)
    private String createRole(@RequestParam(value = "name",required = true,
            defaultValue = "") String name) throws JsonProcessingException {
        Role role = new Role(name);
        roleService.persist(role);
        return mapper.writeValueAsString(role);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    private ResponseEntity<Role> update(@RequestBody Role role) {
        if (role != null) {
            role.setName("Changed!");
            roleService.update(role);
        }

        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    private ResponseEntity<Role> delete(@RequestBody Role role) {
        if (role != null) {
            roleService.delete(role);
        }

        return new ResponseEntity<>(role, HttpStatus.OK);
    }
}
