package app.lottery.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView showForm(Model model) {
        model.addAttribute("userMail", new User());
        return new ModelAndView("user_form", "userMail", new User());
    }
        
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView submit(@Valid @ModelAttribute("userMail")User userMail, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            //return "error";
        }
        model.addAttribute("", userMail.getUserMail());

        return new ModelAndView("ticket-view");
    }

}