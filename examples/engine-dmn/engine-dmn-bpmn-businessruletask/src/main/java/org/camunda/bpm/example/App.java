package org.camunda.bpm.example;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineConfiguration;
import org.camunda.bpm.engine.variable.Variables;

public class App
{
    public static void main( String[] args ) {
        ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration()
                .buildProcessEngine();
        try {
            processEngine.getRepositoryService()
                    .createDeployment()
                    .name("invoice deployment")
                    .addClasspathResource("invoice.bpmn")
                    .addClasspathResource("assign-approver-groups.dmn")
                    .deploy();

            processEngine.getRuntimeService()
                    .startProcessInstanceByKey("invoice", createVariables()
                            .putValue("invoceNumber", "2323"));
        }
        finally {
            processEngine.close();
        }
    }

    private static Variables createVariables() {
        return (Variables) Variables.createVariables();
    }
}
