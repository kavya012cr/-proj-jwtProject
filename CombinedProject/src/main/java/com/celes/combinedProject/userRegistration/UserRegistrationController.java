package com.celes.combinedProject.userRegistration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class UserRegistrationController {
	private RegistrationService registrationService;
	
	@PostMapping("/registration")
	public String register(@RequestBody RegistrationRequest request) {
		return registrationService.register(request);
		
	}
	public UserRegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
	 
	
}
