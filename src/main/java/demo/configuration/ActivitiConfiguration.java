package demo.configuration;

import java.util.Collections;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.impl.rules.RulesDeployer;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitiConfiguration {

    @Bean
    StandaloneProcessEngineConfiguration standaloneProcessEngineConfiguration() {
        StandaloneProcessEngineConfiguration standaloneProcessEngineConfiguration = new StandaloneProcessEngineConfiguration();
        standaloneProcessEngineConfiguration.setJdbcUrl("jdbc:h2:mem:activiti;DB_CLOSE_DELAY=1000");
        standaloneProcessEngineConfiguration.setJdbcDriver("org.h2.Driver");
        standaloneProcessEngineConfiguration.setJdbcUsername("sa");
        standaloneProcessEngineConfiguration.setJdbcPassword("");
        standaloneProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
        standaloneProcessEngineConfiguration.setAsyncExecutorActivate(false);
        standaloneProcessEngineConfiguration.setCustomPostDeployers(Collections.singletonList(new RulesDeployer()));
        return standaloneProcessEngineConfiguration;
    }

    @Bean
    ProcessEngineFactoryBean processEngineFactoryBean() {
        ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
        factoryBean.setProcessEngineConfiguration(standaloneProcessEngineConfiguration());
        return factoryBean;
    }

    @Bean
    ProcessEngine processEngine() throws Exception {
        return processEngineFactoryBean().getObject();
    }

    @Bean
    RepositoryService repositoryService() throws Exception {
        RepositoryService repositoryService = processEngine().getRepositoryService();
        repositoryService
                .createDeployment()
                .addClasspathResource("diagrams/flow.bpmn")
                .addClasspathResource("rules/bankruptcy_rule.drl")
                .enableDuplicateFiltering().name("valera").deploy();
        return repositoryService;
    }

    @Bean
    RuntimeService runtimeService() throws Exception {
        return processEngine().getRuntimeService();
    }
}
