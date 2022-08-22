package tn.neopolis.ApplicationManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.neopolis.ApplicationManager.Exceptions.RoleNotFoundException;
import tn.neopolis.ApplicationManager.models.Role;
import tn.neopolis.ApplicationManager.services.RoleService;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/role")
public class RoleController{

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "")
    public List<Role> getUsers(){
        List<Role> roles = roleService.getAllRoles();
        return roles ;
    }

    @GetMapping(value = "/{id}")
    public Role getUserById(@PathVariable Integer id) throws RoleNotFoundException {
        return roleService.getRoleById(id);
    }

    @PostMapping(value = "")
    public Role addRole(@RequestBody Role role){
        Role role1 = roleService.createRole(role);
        return role1;
    }
    @PutMapping(value = "")
    public Role updateRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRole(@PathVariable Integer id){
        roleService. deleteRoleById(id);
    }

    @DeleteMapping(value ="")
    public void deleteRole(){
        roleService.deleteAllRoles();
    }

}