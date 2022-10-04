package com.revature.controller;

import com.revature.model.User;
import com.revature.service.AuthService;
import io.javalin.Javalin;

import javax.servlet.http.HttpSession;

public class AuthController {

    private AuthService authService = new AuthService();

    public void mapEndPoint(Javalin app){
        app.post("/login", (ctx)->{
            User credential = ctx.bodyAsClass(User.class);
            User user = authService.login(credential.getUsername(), credential.getPassword());

            // creating a Httpsession object

            HttpSession session =  ctx.req.getSession();
            session.setAttribute("user", user);

        });

        app.get("/currentuser", (ctx)->{
            HttpSession session = ctx.req.getSession();
            User user = (User) session.getAttribute("user");
            if (user !=null){
            ctx.json(user);
        }else{
              ctx.result("User is not logged in");
              ctx.status(400);
            }

            });

        app.post("/logout", (ctx)->{
            ctx.req.getSession().invalidate(); // invalidate an active Httpsession
        });

    }
}
