package tn.neopolis.ApplicationManager.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.neopolis.ApplicationManager.models.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer> {
}
