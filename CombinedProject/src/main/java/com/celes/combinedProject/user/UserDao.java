package com.celes.combinedProject.user;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
@org.springframework.transaction.annotation.Transactional(readOnly = true)
public interface UserDao extends CrudRepository<User, Long>{
	Optional<User>findByEmail(String email);

	
	@Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enabled(String email);


}
