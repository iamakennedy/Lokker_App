package org.launchcode.Lokker.R.controller;

import org.hibernate.type.TrueFalseType;
import org.launchcode.Lokker.R.models.Cities;
import org.launchcode.Lokker.R.models.Gym;
import org.launchcode.Lokker.R.models.User;
import org.launchcode.Lokker.R.models.data.CitiesDao;
import org.launchcode.Lokker.R.models.data.GymDao;
import org.launchcode.Lokker.R.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
//@SessionAttributes("user")
public class LokkerAppController {
    //spring "magic" no need to create class to implement userDao interface; but rather spring will understan how to create a ocncrete implementation of the userDao for us. @autowired gives an instance of the class by the framework
    @Autowired
    private UserDao userDao;

    @Autowired
    private CitiesDao citiesDao;

    @Autowired
    private GymDao gymDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        return "Login";
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
    public String login(Model model, @RequestParam String email, @RequestParam String password) {
        User myFoundUser = userDao.findByEmail(email);
        if ( myFoundUser != null &&  password.equals(myFoundUser.getPassword())) {
            // redirect to welcome page
            model.addAttribute("title", "login");
            // place html variables to match the above login controller
            return "home";
        } else {

            model.addAttribute("title", "login");
            return "login";
            //add an attribute with an error for instance in which there's an invalid login
        }
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("title", "home");
        return "home";
    }

    @RequestMapping(value = "location", method = RequestMethod.GET)
    public String location(Model model, @RequestParam Integer cityid) {
        //do query and get locations with cityid equals

        Cities mycity = citiesDao.findById(cityid).get();
        List<Gym> locations =mycity.getGyms();
        model.addAttribute("locations", locations);
        model.addAttribute("title", "Gyms Locations in City: " + mycity.getName());
        return "location";
    }

    @RequestMapping(value = "gymdetails", method = RequestMethod.GET)
    public String gymdetails(Model model, @RequestParam Integer id) {
        Gym mylocker = gymDao.findById(id).get();
        model.addAttribute("title", "Gym Lokker Details");
        model.addAttribute("lokker", mylocker);
        return "gymdetails";

    }

    @RequestMapping(value = "gymconfirmation", method = RequestMethod.GET)
    public String gymconfirmation(Model model, @RequestParam Integer id) {
        Gym mylocker = gymDao.findById(id).get();
        mylocker.setBooked(Boolean.TRUE);
        gymDao.save(mylocker);

        model.addAttribute("title", "Gym Lokker Confirmation");
        model.addAttribute("lokker", mylocker);
        return "gymconfirm";

    }


}
/////////////////////////////////////////////////please help///////////////////////////////////////////////////////
//    @RequestMapping(value = "gymdetails", method = RequestMethod.GET)
//    public String gymdetails(Model model, @RequestParam int locId) {
//        Gym mygym = gymDao.findbyId(locId).get();
//        List<Gym> gyms = mygym.getId();
//        model.addAttribute("title", "Your Gym Location Lokker is:" + mygym.getName());
//        return "gymdetails";
//
//    }
//
//    @RequestMapping(value = "gymdetails", method = RequestMethod.POST)
//    public String processgymdetails(@RequestParam int locId, @RequestParam String locName,@RequestParam String locAddress) {
//        Gym gym = gymDao.findbyId(locId);
//        gym.setName(locName);
//        gym.setAddress(locAddress);
//        gymDao.save(gym);
//        return "redirect:home";






/*TODO Create more controllers @RequestMapping*/
