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
}
