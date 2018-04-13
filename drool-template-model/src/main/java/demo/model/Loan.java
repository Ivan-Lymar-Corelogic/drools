package demo.model;

import java.io.Serializable;

public class Loan implements Serializable{

    private Integer amount;
    private boolean allowed;
    private Integer id;
    private Integer allowedAmount;

    public Loan(Integer amount, Integer id) {
        this.amount = amount;
        this.id = id;
    }

    public boolean getAllowed() {
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAllowedAmount() {
        return allowedAmount;
    }

    public void setAllowedAmount(Integer allowedAmount) {
        this.allowedAmount = allowedAmount;
    }
}
