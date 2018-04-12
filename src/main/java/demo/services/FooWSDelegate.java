package demo.services;

import demo.model.Loan;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class FooWSDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution arg0) {
        ((Loan)arg0.getVariable("loan")).setAllowedAmount(3000);
    }
}
