package com.revature.controller;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.ReimbursementService;
import io.javalin.Javalin;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ReimbursementControllerPrevious {

    private ReimbursementService reimbursementService = new ReimbursementService();

    public void mapEndPoints(Javalin app) {
        app.get("/previous-reimbursements", (ctx)->{
            HttpSession httpSession = ctx.req.getSession();

            User user = (User) httpSession.getAttribute("user");
            if (user != null){
                 List<Reimbursement> reimbursements = reimbursementService.getAllReimbursementForEmployee(user.getId());
                 ctx.json(reimbursements);

            }else{
                ctx.result("You are not logged in");
                ctx.status(401);
            }

        });


    }


}

