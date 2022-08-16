package tn.neopolis.ApplicationManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.neopolis.ApplicationManager.models.Privilege;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege,Integer> {

}
