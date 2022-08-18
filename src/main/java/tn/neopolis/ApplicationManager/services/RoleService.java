package tn.neopolis.ApplicationManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.neopolis.ApplicationManager.Exceptions.RoleNotFoundException;
import tn.neopolis.ApplicationManager.models.Role;
import tn.neopolis.ApplicationManager.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Integer id) throws RoleNotFoundException {

        return roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role Not Found"));
    }

    public Role createRole(Role role){
        return roleRepository.save(role);
    }

    public Role  updateRole(Role role){
        return roleRepository.save(role);

    }
    public void deleteRoleById(Integer id){
        roleRepository.deleteById(id);
    }
    public void deleteAllRoles(){
        roleRepository.deleteAll();
    }
}
