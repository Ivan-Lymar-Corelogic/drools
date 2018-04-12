package demo.api;

import demo.model.Loan;
import java.util.HashMap;
import java.util.Map;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @Autowired
    private RuntimeService runtimeService;

    @RequestMapping("/{provider}/{id}/{amount}")
    public Loan index(@PathVariable(name = "id") Integer id,
                      @PathVariable(name = "provider") Integer provider,
                      @PathVariable(name = "amount") Integer amount) {
        Loan loan = new Loan(amount, id);

        Map<String, Object> variableMap = new HashMap<>();
        variableMap.put("loan", loan);
        variableMap.put("provider", provider);

        runtimeService.startProcessInstanceByKey("myProcess", variableMap);

        return loan;
    }
}
