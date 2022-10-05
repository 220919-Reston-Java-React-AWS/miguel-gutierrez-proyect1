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
               boolean approval = rs.getBoolean("approvedordenied");
               int eId = rs.getInt("employee_id");
               int managerId = rs.getInt("manager_id");

               Reimbursement reimbursement = new Reimbursement(id, description, amount, status, approval, eId, managerId);

               reimbursements.add(reimbursement);

           }
           return reimbursements;
        }
    }
    public List<Reimbursement> getAllPendingReimbursements () throws SQLException {
        try (Connection connectionObject = ConnectionFactory.createConnection()){

            List<Reimbursement> reimbursements = new ArrayList<>();

            String sql = "SELECT * FROM reimbursements WHERE pendingorcompleted = false";

            Statement stmt = connectionObject.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String description = rs.getString("description");
                int amount = rs.getInt("amount");
                boolean status = rs.getBoolean("pendingorcompleted");
                boolean approval = rs.getBoolean("approvedordenied");
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
                boolean approval = rs.getBoolean("approvedordenied");
                int eId = rs.getInt("employee_id");
                int managerId = rs.getInt("manager_id");

                Reimbursement reimbursement = new Reimbursement(id, description, amount, status, approval, eId, managerId);

                reimbursements.add(reimbursement);

            }
            return reimbursements;
        }
    }
    public List<Reimbursement> getAllPendingReimbursementForEmployee (int employeeId) throws SQLException {
        try (Connection connectionObject = ConnectionFactory.createConnection()){

            List<Reimbursement> reimbursements = new ArrayList<>();

            String sql = "SELECT * FROM reimbursements WHERE pendingorcompleted = false";

            PreparedStatement pstm = connectionObject.prepareStatement(sql);

            pstm.setInt(1, employeeId);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String description = rs.getString("description");
                int amount = rs.getInt("amount");
                boolean status = rs.getBoolean("pendingorcompleted");
                boolean approval = rs.getBoolean("approvedordenied");
                int eId = rs.getInt("employee_id");
                int managerId = rs.getInt("manager_id");

                Reimbursement reimbursement = new Reimbursement(id, description, amount, status, approval, eId, managerId);

                reimbursements.add(reimbursement);

            }
            return reimbursements;
        }
    }



    public Reimbursement reimbursementUpdate (int reimbursementId, boolean pendingorcompleted , boolean approvedordenied, int managerId) throws SQLException{
        try (Connection connectionObj = ConnectionFactory.createConnection()){
            String sql = "UPDATE reimbursements SET pendingorcompleted = ?, approvedordenied = ?,manager_id =? WHERE id = ?;";

            PreparedStatement pstmt = connectionObj.prepareStatement(sql);
            pstmt.setBoolean(1, pendingorcompleted);
            pstmt.setBoolean(2, approvedordenied);
            pstmt.setInt(3, managerId);
            pstmt.setInt(4, reimbursementId);

            int numberOfRecordsUpdated = pstmt.executeUpdate();

        }
        return null;
    }

    public Reimbursement addingReimbursement (String description, int amount,boolean pendingorcompleted, boolean approvedordenied, int employeeId, int managerId) throws SQLException {
        try (Connection connectionObj = ConnectionFactory.createConnection()) {
            String sql = "insert into reimbursements (description, amount, pendingorcompleted, approvedordenied, employee_id, manager_id) values (?, ?, ?, ?, ?, ?);";

            PreparedStatement pstmt = connectionObj.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, description);
            pstmt.setInt(2, amount);
            pstmt.setBoolean(3, false);
            pstmt.setBoolean(4, false);
            pstmt.setInt(5, employeeId);
            pstmt.setInt(6, managerId);

            int numberOfRecordsAdded = pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);

            return new Reimbursement(id, description, amount, false, false, employeeId, managerId);
        }
    }

}
