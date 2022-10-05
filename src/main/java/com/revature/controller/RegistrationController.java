package com.revature.controller;

import com.revature.model.User;

import io.javalin.Javalin;

import javax.servlet.http.HttpSession;

public class RegistrationControler {




    public void mapEndPoint(Javalin app){

        app.post("/register", (ctx)->{
        User credential = ctx.bodyAsClass(User.class);

    });
}
