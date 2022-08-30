package tn.neopolis.ApplicationManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.neopolis.ApplicationManager.exceptions.ApplicationNotFoundException;
import tn.neopolis.ApplicationManager.models.Application;
import tn.neopolis.ApplicationManager.repositories.ApplicationRepository;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getAllApplications(){
        return applicationRepository.findAll();
    }

    public Application getApplicationById(Integer id) throws ApplicationNotFoundException {
        return applicationRepository.findById(id).orElseThrow(()-> new ApplicationNotFoundException("Application not found"));
    }

    public Application createApplication(Application application){
        return applicationRepository.save(application);
    }

    public Application updateApplication(Application application){
        return applicationRepository.save(application);
    }

    public void deleteApplication(Integer id){
         applicationRepository.deleteById(id);
    }
}
