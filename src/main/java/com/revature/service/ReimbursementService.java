package com.revature.service;

import com.revature.model.Reimbursement;
import com.revature.repository.ReimbursementRepository;

import java.sql.SQLException;
import java.util.List;

public class ReimbursementService {

    private ReimbursementRepository reimbursementRepository = new ReimbursementRepository();

    public List<Reimbursement> getAllreimbursements() throws SQLException {
        return reimbursementRepository.getAllReimbursement();

    }
    public List<Reimbursement> getAllReimbursementForEmployee(int employeeId) throws SQLException {
        return reimbursementRepository.getAllReimbursementForEmployee(employeeId);

    }

    public Reimbursement addingReimbursement(String description, int amount,boolean pendingorcompleted, boolean approvedordenied, int employeeId, int managerId) throws SQLException{

        return reimbursementRepository.addingReimbursement(description, amount, pendingorcompleted, approvedordenied, employeeId, managerId);

    }
}
