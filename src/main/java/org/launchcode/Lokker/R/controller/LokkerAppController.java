package org.launchcode.Lokker.R.controller;

import org.launchcode.Lokker.R.models.data.LokkersDao;
import org.launchcode.Lokker.R.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LokkerAppController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private LokkersDao lokkersDao;
    @RequestMapping(value = "")
    public String index(Model model) {return "Login";}














}
/*TODO Create more controllers @RequestMapping*/
