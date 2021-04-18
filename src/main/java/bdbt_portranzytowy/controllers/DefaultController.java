package bdbt_portranzytowy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @RequestMapping(value = "/")
    public String defaultView(Model model){
        return "redirect:/login/";
    }

}
