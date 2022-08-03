package com.celes.combinedProject.userRegistration.token;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@org.springframework.transaction.annotation.Transactional (readOnly = true)
public interface ConfirmationTokenDao extends CrudRepository<ConfirmationToken, Long>{
Optional<ConfirmationToken> findByToken(String token);

@Transactional
@Modifying
@Query("UPDATE ConfirmationToken c " +
        "SET c.confirmedAt = ?2 " +
        "WHERE c.token = ?1")
int updateConfirmedAt(String token,
                      LocalDateTime confirmedAt);

}
