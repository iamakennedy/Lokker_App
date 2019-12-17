package org.launchcode.Lokker.R.controller;

import org.launchcode.Lokker.R.models.User;
import org.launchcode.Lokker.R.models.data.LokkersDao;
import org.launchcode.Lokker.R.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
//@SessionAttributes("user")
public class LokkerAppController {
//spring "magic" no need to create class to implement userDao interface; but rather spring will understan how to create a ocncrete implementation of the userDao for us. @autowired gives an instance of the class by the framework
    @Autowired
    private UserDao userDao;

    @Autowired
    private LokkersDao lokkersDao;

    @RequestMapping(value = "")
    public String index(Model model) {return "Login";}

    {

    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "Register");
        return "register";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user,
                      Errors errors) {

        model.addAttribute(user);

        if (!errors.hasErrors()) {
            userDao.save(user);
            return "home";
        }

        return "register";

    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("title", "login");
        return "login";
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(Model model, @RequestParam String email, @RequestParam String password)
    {
        User myFoundUser = userDao.findByEmail(email);
        if (password.equals(myFoundUser.getPassword())){
        // redirect to welcome page
        model.addAttribute("title", "login");
        // place html variables to match the above login controller
            return "home";
        }
        else {

             model.addAttribute("title", "login");
        return "login";
        //add an attribute with an error for instance in which there's an invalid login
        }
    }

   @RequestMapping(value = "home", method = RequestMethod.GET)
        public String home(Model model)
   {
        model.addAttribute("title", "home");
        return "home";
    }


}
/*TODO Create more controllers @RequestMapping*/
//