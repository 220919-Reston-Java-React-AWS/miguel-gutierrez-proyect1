package com.revature.model;


import java.util.Objects;

//fields in DB
//id, description, amount, pendingorcompleted, approvedordenied, employee_id, manager_id
public class Reimbursement {

    private int id;
    private String description;
    private int amount;
    private boolean status;

    private boolean approval;
    private int userId;
    private int managerId;


    public Reimbursement() {

    }

    public Reimbursement(int id, String description, int amount, boolean status, boolean approval, int userId, int managerId) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.approval = approval;
        this.userId = userId;
        this.managerId = managerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return id == that.id && amount == that.amount && status == that.status && approval == that.approval && userId == that.userId && managerId == that.managerId && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, amount, status, approval, userId, managerId);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                ", approval=" + approval +
                ", userId=" + userId +
                ", managerId=" + managerId +
                '}';
    }
}
