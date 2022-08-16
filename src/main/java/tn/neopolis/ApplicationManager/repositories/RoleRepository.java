package tn.neopolis.ApplicationManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.neopolis.ApplicationManager.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
