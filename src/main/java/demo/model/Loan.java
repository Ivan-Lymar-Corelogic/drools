package demo.model;

public class Loan {

    private Integer amount;
    private Boolean allowed;

    public Loan(Integer amount) {
        this.amount = amount;
    }

    public Boolean getAllowed() {
        return allowed;
    }

    public void setAllowed(Boolean allowed) {
        this.allowed = allowed;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
