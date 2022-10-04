package com.revature;

import com.revature.controller.AuthController;
import com.revature.controller.ReimbursementController;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.repository.ReimbursementRepository;
import com.revature.repository.UserRepository;
import io.javalin.Javalin;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Javalin app = Javalin.create();

        AuthController ac = new AuthController();
        ac.mapEndPoint(app);

        ReimbursementController reimbursementController = new ReimbursementController();
        reimbursementController.mapEndPoints(app);


        app.start(8080);

    }
}