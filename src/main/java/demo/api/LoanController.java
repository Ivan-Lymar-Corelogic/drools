package demo.api;

import demo.model.Loan;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@RestController
public class LoanController {

    @Autowired
    private KieContainer kieContainer;

    @RequestMapping("/{id}")
    public Loan index(@PathVariable(name = "id") String id) {

        Loan loan = new Loan();
        loan.setClientId(id);

        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.insert(loan);
        kieSession.fireAllRules();
        kieSession.dispose();
        return loan;

    }

}
