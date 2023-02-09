package edu.miu.cs.cs425.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = {"/eregistrar/public/login"})
public String displayLogin(){
        return "public/login";
}



}
