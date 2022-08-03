package com.celes.combinedProject.userRegistration.token;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenService {

private final ConfirmationTokenDao confirmationTokenDao;
	
	public ConfirmationTokenService(ConfirmationTokenDao confirmationTokenDao) {
	this.confirmationTokenDao = confirmationTokenDao;
}

	public void saveConfirmationToken(ConfirmationToken confirmationToken) {
		confirmationTokenDao.save(confirmationToken);
		
	}

	public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenDao.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationTokenDao.updateConfirmedAt(token, LocalDateTime.now());
    }	
}
