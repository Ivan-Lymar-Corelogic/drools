package demo.api;

import demo.model.Loan;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @Autowired
    private KieContainer kieContainer;

    @RequestMapping("/{amount}")
    public Loan index(@PathVariable(name = "amount") String amount) {

        Loan loan = new Loan(Integer.valueOf(amount));

        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.insert(loan);
        kieSession.fireAllRules();
        kieSession.dispose();
        return loan;
    }
}
