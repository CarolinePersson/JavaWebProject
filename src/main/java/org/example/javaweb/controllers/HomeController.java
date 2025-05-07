package org.example.javaweb.controllers;

import org.example.javaweb.model.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends BaseController  {
    @Autowired
    DogRepository dogRepository;

    @GetMapping(path="/")
    String empty(Model model)
    {
        model.addAttribute("activeFunction", "home");
        model.addAttribute("dogs", dogRepository.findAll());
        return "dogs";
    }
    @GetMapping(path="/list")
    public String list(Model model)
    {
        model.addAttribute("activeFunction", "home");

        model.addAttribute("dogs", dogRepository.findAll());
       String user = getLoggedInEmail();
       model.addAttribute("user", user);
        return "list";
    }
    @GetMapping("/scheduleadmin")
    public String scheduleAdminPage(Model model) {
        String user = getLoggedInEmail(); // från BaseController
        model.addAttribute("user", user);
        return "scheduleadmin";
    }

}
