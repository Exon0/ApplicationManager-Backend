package tn.neopolis.ApplicationManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.neopolis.ApplicationManager.exceptions.ApplicationNotFoundException;
import tn.neopolis.ApplicationManager.models.Application;
import tn.neopolis.ApplicationManager.services.ApplicationService;

import java.util.List;


@Controller
@RestController
@RequestMapping(value = "/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping(value = "")
    public List<Application> getAllApplications(){
        List<Application> allApplications = applicationService.getAllApplications();
        return allApplications;
    }

    @GetMapping(value = "/{id}")
    public Application getApplicationById(@PathVariable Integer id) throws ApplicationNotFoundException {
        Application applicationById = applicationService.getApplicationById(id);
        return applicationById;
    }

    @PostMapping(value = "")
    public Application createApplication(@RequestBody Application application){
        return applicationService.createApplication(application);
    }
    @PutMapping(value = "")
    public Application updateApplication(@RequestBody  Application application){
        return applicationService.updateApplication(application);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteApplication(@PathVariable Integer id){
        applicationService.deleteApplication(id);
    }
}
