package com.revature.controller;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.ReimbursementService;
import io.javalin.Javalin;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ReimbursementController {

    private ReimbursementService reimbursementService = new ReimbursementService();

    public void mapEndPoints(Javalin app) {
        app.get("/reimbursements", (ctx)->{
            HttpSession httpSession = ctx.req.getSession();

            User user = (User) httpSession.getAttribute("user");
            if (user != null){
                if (user.getRoleId() == 2){
                    List<Reimbursement> reimbursements = reimbursementService.getAllreimbursements();

                    ctx.json(reimbursements);
                }else{
                    ctx.result("You are logged in but you are not a manager");
                    ctx.status(401);
                }
            }else{
                ctx.result("You are not logged in");
                ctx.status(401);
            }

        });
    }
}
