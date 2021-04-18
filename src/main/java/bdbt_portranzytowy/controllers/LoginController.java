package bdbt_portranzytowy.controllers;

import bdbt_portranzytowy.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login/")
public class LoginController {


    @RequestMapping(value = "/")
    public String login(Model model){
        return "loginPage";
    }

    @RequestMapping(value="option", method=RequestMethod.POST)
    public String option(@RequestParam(value="action") String action) {

        System.out.println("I am in option!");

        if (action.equals("signIn")) {
            System.out.println("Signning in!");
            return "redirect:/login/signIn";
        }
        else if (action.equals("register")) {
            System.out.println("Registering!");
            return "redirect:/login/register";
        }
        return "loginPage";
    }

    @RequestMapping(value="signIn")
    public String signIn(Model model){
        model.addAttribute("login", new Login());
        return "signInPage";
    }

    @RequestMapping(value="signInRequest", method= RequestMethod.POST)
    public String signInRequest(@ModelAttribute("user") Login user){
        System.out.println(user);
        if(user.getname().equals("siema") && user.getPassword().equals("123"))
            return "redirect:/towary/";
        else
            return "redirect:/login/";
    }

    @RequestMapping(value="register")
    public String register(Model model){
        return "registerPage";
    }
}
