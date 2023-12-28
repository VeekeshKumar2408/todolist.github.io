package com.springboot.ToDoList.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {//Constructor Injection
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String goToLoginPage(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap){

        //Authentication
        //name - Veekesh
        //password - Dummy
        if (authenticationService.authenticate(name,password)){
            modelMap.put("name",name);
          //  modelMap.put("password",password);
            return "welcome";
        }
        modelMap.put("errorMessage","Invalid Credentials! Please try again :) ");
        return "login";
    }
}
