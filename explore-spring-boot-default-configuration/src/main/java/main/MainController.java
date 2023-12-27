package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    ApplicationContext context;
    @RequestMapping("/home")
    public String home() {
        return "home.html";
    }

    @RequestMapping("/home2")
    public String home2(Model model) {
        model.addAttribute("username", "Asela");
        model.addAttribute("color", "red");
        return "home2.html";
    }
}
