package services;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;

@Service
@RequestScope
@Getter
@Setter
@Slf4j
public class LoginService {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;
    private String username;
    private String password;

    @Autowired
    public LoginService(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @PostConstruct
    public void init() {
      log.info("Created.");
    }

    public boolean login() {
        loginCountService.increment();
        boolean result = "Asela".equals(username) && "password".equals(password);
        if(result) {
            loggedUserManagementService.setUsername(username);
        }
        return result;
    }
}
