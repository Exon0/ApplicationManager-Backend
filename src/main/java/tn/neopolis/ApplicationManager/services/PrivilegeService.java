package tn.neopolis.ApplicationManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.neopolis.ApplicationManager.exceptions.PrivilegeNotFoundException;
import tn.neopolis.ApplicationManager.models.Privilege;
import tn.neopolis.ApplicationManager.repositories.PrivilegeRepository;

import java.util.List;

@Service
public class PrivilegeService {
    @Autowired
    private PrivilegeRepository privilegeRepository;

    public List<Privilege> getAllPrivileges() {
        return privilegeRepository.findAll();
    }

    public Privilege getPrivilegeById(Integer id) throws PrivilegeNotFoundException {

        return privilegeRepository.findById(id).orElseThrow(() -> new PrivilegeNotFoundException("Privilege Not Found"));
    }

    public Privilege createPrivilege(Privilege privilege){
        return privilegeRepository.save(privilege);
    }

    public Privilege  updatePrivilege(Privilege privilege){
        return privilegeRepository.save(privilege);

    }
    public void deletePrivilegeById(Integer id){
        privilegeRepository.deleteById(id);
    }
    public void deleteAllPrivileges(){
        privilegeRepository.deleteAll();
    }
}
