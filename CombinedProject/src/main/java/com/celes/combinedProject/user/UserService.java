package com.celes.combinedProject.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.celes.combinedProject.userRegistration.token.ConfirmationToken;
import com.celes.combinedProject.userRegistration.token.ConfirmationTokenService;

@Service
/* @AllArgsConstructor */
public class UserService implements UserDetailsService {
	private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
	
	private final UserDao userDao;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ConfirmationTokenService confirmationTokenService;
	


	public UserService(UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder,
			ConfirmationTokenService confirmationTokenService) {
		super();
		this.userDao = userDao;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.confirmationTokenService = confirmationTokenService;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userDao.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));

	}

	public String signUpUser(User user) {
		boolean userExists = userDao.findByEmail(user.getEmail()).isPresent();
		if (userExists) {
			throw new IllegalStateException("email already taken");

		}
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userDao.save(user);
	String token	=UUID.randomUUID().toString();
		ConfirmationToken confirmationToken=new ConfirmationToken(token,LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),LocalDateTime.now().plusHours(1), user);
		confirmationTokenService.saveConfirmationToken(confirmationToken); 
		return token;

	}

	

	public int enableUser(String email) {
		return userDao.enabled(email);		
	}
	
	

}
