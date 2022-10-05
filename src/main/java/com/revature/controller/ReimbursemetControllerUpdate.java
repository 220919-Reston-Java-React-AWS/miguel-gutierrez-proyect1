package com.revature.controller;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.ReimbursementService;
import io.javalin.Javalin;

import javax.servlet.http.HttpSession;

public class ReimbursemetControllerUpdate {

    private ReimbursementService reimbursementService = new ReimbursementService();


    public void mapEndPoint(Javalin app){
        app.patch("/update-reimbursement", (ctx)->{
           Reimbursement credential = ctx.bodyAsClass(Reimbursement.class);
           try {
               HttpSession httpSession = ctx.req.getSession();

               User user = (User) httpSession.getAttribute("user");
               if (user != null) {
                   if (user.getRoleId() == 2) {
                       Reimbursement reimbursement = reimbursementService.reimbursementUpdate(credential.getId(), credential.isPendingorcompleted(), credential.isApproval(), credential.getManagerId());
                       ctx.result("Reimbursement updated");
                   } else {
                       ctx.result("You are logged in but you are not a manager");
                       ctx.status(401);

                   }
               }else{
                       ctx.result("You are not logged in");
                       ctx.status(401);
                   }

           }catch (Exception e) {
               ctx.result("Please check you insert the correct description");
           }
        });


    }
}
