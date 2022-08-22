package tn.neopolis.ApplicationManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.neopolis.ApplicationManager.exceptions.PrivilegeNotFoundException;
import tn.neopolis.ApplicationManager.models.Privilege;
import tn.neopolis.ApplicationManager.services.PrivilegeService;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/privilege")
public class PrivilegeController {
    @Autowired
    private PrivilegeService privilegeService;

    @GetMapping(value = "")
    public List<Privilege> getPrivileges(){
        List<Privilege> privilege = privilegeService.getAllPrivileges();
        return privilege ;
    }

    @GetMapping(value = "/{id}")
    public Privilege getPrivilegeById(@PathVariable Integer id) throws PrivilegeNotFoundException {
        return privilegeService.getPrivilegeById(id);
    }

    @PostMapping(value = "")
    public Privilege addPrivilege(@RequestBody Privilege privilege){
        Privilege privilege1 = privilegeService.createPrivilege(privilege);
        return privilege1;
    }
    @PutMapping(value = "")
    public Privilege updatePrivilege(@RequestBody Privilege privilege){
        return privilegeService.updatePrivilege(privilege);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePrivilege(@PathVariable Integer id){
        privilegeService. deletePrivilegeById(id);
    }

    @DeleteMapping(value ="")
    public void deleteAllPrivileges(){
        privilegeService.deleteAllPrivileges();
    }

}
