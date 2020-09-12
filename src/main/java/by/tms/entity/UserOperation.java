package by.tms.entity;

import java.util.Date;

public class UserOperation {
    private long userId;
    private Date date = new Date();
    private double num1;
    private double num2;
    private String operation;
    private double result;

    public UserOperation(long userId, double num1, double num2, String operation, double result) {
        this.userId = userId;
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
    }

    public UserOperation(long userId, Date date, double num1, double num2, String operation, double result) {
        this.userId = userId;
        this.date = date;
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.result = result;
    }

    public UserOperation() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
