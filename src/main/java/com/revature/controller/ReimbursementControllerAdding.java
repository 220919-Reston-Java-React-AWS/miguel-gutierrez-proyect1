package com.revature.controller;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.ReimbursementService;
import io.javalin.Javalin;

import javax.servlet.http.HttpSession;


public class ReimbursementControllerAdding {

    private ReimbursementService reimbursementService = new ReimbursementService();

    public void mapEndPoint(Javalin app) {
        app.post("/addingreimbursement", (ctx)->{
            Reimbursement credential = ctx.bodyAsClass(Reimbursement.class);
            try{
                HttpSession httpSession = ctx.req.getSession();

                User user  = (User) httpSession.getAttribute("user");
                if (user != null) {
                    if (user.getRoleId() == 1) {
                        if (credential.getDescription()== ""){
                            ctx.result("Please check you insert the correct description");
                        }else{
                        Reimbursement reimbursement = reimbursementService.addingReimbursement(credential.getDescription(), credential.getAmount(), credential.isPendingorcompleted(), credential.isApproval(), user.getId(), credential.getManagerId());
                        ctx.result("New reimbursement added");
                        }
                    }else {
                        ctx.result("You are logged in but you are not a employee");
                        ctx.status(401);
                    }
                }else{
                    ctx.result("You are not logged in");
                    ctx.status(401);
                }

            }catch (Exception e){
                ctx.result("Please check you insert the correct description");
            }

            });
        }
    }

