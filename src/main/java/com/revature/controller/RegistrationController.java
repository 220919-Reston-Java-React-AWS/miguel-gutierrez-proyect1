package com.revature.controller;

import com.revature.model.User;

import com.revature.service.RegisterService;
import io.javalin.Javalin;

import javax.servlet.http.HttpSession;

public class RegistrationController {


    private RegisterService registerService = new RegisterService();

    public void mapEndPoint(Javalin app) {

        app.post("/register", (ctx) -> {
            User credential = ctx.bodyAsClass(User.class);
            try {
                User user = registerService.register(credential.getUsername(), credential.getPassword(), credential.getFirstName(), credential.getLastName(), 1);
                //HttpSession session =ctx.req.getSession();
                //session.setAttribute("user", user);
               ctx.result("Welcome to the system");

            }catch (Exception e){
                ctx.result("Username already taken");
            }
        });
    }
}
