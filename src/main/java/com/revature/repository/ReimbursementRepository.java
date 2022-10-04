package com.revature.repository;


import com.revature.model.Reimbursement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementRepository {

    public List<Reimbursement> getAllReimbursement () throws SQLException {
        try (Connection connectionObject = ConnectionFactory.createConnection()){

            List<Reimbursement> reimbursements = new ArrayList<>();

            String sql = "SELECT * FROM reimbursements";

           Statement stmt = connectionObject.createStatement();
           ResultSet rs = stmt.executeQuery(sql);

           while (rs.next()){
               int id = rs.getInt("id");
               String description = rs.getString("description");
               int amount = rs.getInt("amount");
               boolean status = rs.getBoolean("pendingorcompleted");
               boolean approval = rs.getBoolean("aprovedordenied");
               int eId = rs.getInt("employee_id");
               int managerId = rs.getInt("manager_id");

               Reimbursement reimbursement = new Reimbursement(id, description, amount, status, approval, eId, managerId);

               reimbursements.add(reimbursement);

           }
           return reimbursements;
        }
    }
    public List<Reimbursement> getAllReimbursementForEmployee (int employeeId) throws SQLException {
        try (Connection connectionObject = ConnectionFactory.createConnection()){

            List<Reimbursement> reimbursements = new ArrayList<>();

            String sql = "SELECT * FROM reimbursements WHERE employee_id = ?";

            PreparedStatement pstm = connectionObject.prepareStatement(sql);

            pstm.setInt(1, employeeId);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String description = rs.getString("description");
                int amount = rs.getInt("amount");
                boolean status = rs.getBoolean("pendingorcompleted");
                boolean approval = rs.getBoolean("aprovedordenied");
                int eId = rs.getInt("employee_id");
                int managerId = rs.getInt("manager_id");

                Reimbursement reimbursement = new Reimbursement(id, description, amount, status, approval, eId, managerId);

                reimbursements.add(reimbursement);

            }
            return reimbursements;
        }
    }

    public void reimbursementUpdate (int reimbursementId, boolean aprovedordenied, int managerId) throws SQLException{
        try (Connection connectionObj = ConnectionFactory.createConnection()){
            String sql = "UPDATE reimbursements SET aprovedordenied = ?,manager_id =? WHERE id = ?;";

            PreparedStatement pstmt = connectionObj.prepareStatement(sql);
            pstmt.setBoolean(1, aprovedordenied);
            pstmt.setInt(2, managerId);
            pstmt.setInt(3, reimbursementId);

            int numberOfRecordsUpdated = pstmt.executeUpdate();

        }
    }


}
