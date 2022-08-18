package tn.neopolis.ApplicationManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import tn.neopolis.ApplicationManager.models.User;



@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String username);
}
