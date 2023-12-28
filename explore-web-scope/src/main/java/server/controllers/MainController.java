package server.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.LoggedUserManagementService;
import services.LoginCountService;

@Controller
@Slf4j
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    @Autowired
    public MainController(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/main")
    public String home(
            @RequestParam(required = false) String logout,
            Model model
    ) {
        if(logout != null) {
            loggedUserManagementService.setUsername(null);
        }
        log.info("Controller: {} | Service: {}", this, loggedUserManagementService);
        String username = loggedUserManagementService.getUsername();
        model.addAttribute("username", username);
        model.addAttribute("loginCount", loginCountService.getCount());

        return username == null ? "redirect:/" : "server.main.html";
    }

}
