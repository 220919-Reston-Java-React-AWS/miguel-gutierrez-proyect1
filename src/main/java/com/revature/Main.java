package com.revature;

import com.revature.controller.*;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.repository.ReimbursementRepository;
import com.revature.repository.UserRepository;
import com.revature.service.RegisterService;
import io.javalin.Javalin;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Javalin app = Javalin.create();

        RegistrationController rc = new RegistrationController();
        rc.mapEndPoint(app);

        AuthController ac = new AuthController();
        ac.mapEndPoint(app);

        ReimbursementControllerAdding rca= new ReimbursementControllerAdding();
        rca.mapEndPoint(app);

        ReimbursementControllerPrevious rcp = new ReimbursementControllerPrevious();
        rcp.mapEndPoints(app);



        ReimbursementController reimbursementController = new ReimbursementController();
        reimbursementController.mapEndPoints(app);


        app.start(8080);

    }
}