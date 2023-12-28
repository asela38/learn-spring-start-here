package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    ApplicationContext context;
    @RequestMapping("/home")
    public String home() {
        return "home.html";
    }

    @RequestMapping("/home2")
    public String home2(@RequestParam(required = false) String color,
                        @RequestParam(required = false) String name,
                        Model model) {
        model.addAttribute("username",StringUtils.isEmpty(name) ? "Asela": name);
        model.addAttribute("color", StringUtils.isEmpty(color) ? "red" : color);
        return "home2.html";
    }

    @RequestMapping("/home3/{color}")
    public String home3(@PathVariable String color,
                        @RequestParam(required = false) String name,
                        Model model) {
        model.addAttribute("username",StringUtils.isEmpty(name) ? "Asela": name);
        model.addAttribute("color", StringUtils.isEmpty(color) ? "red" : color);
        return "home2.html";
    }
}
