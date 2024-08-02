package org.camunda.bpm.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;

public class App
{
    public static void main( String[] args ) throws FileNotFoundException {
        final String DMN_PATH = "CheckOrder.dmn";
        //InputStream file = new FileInputStream(DMN_PATH);             //NOT found during execution
        //InputStream file = App.class.getResourceAsStream("/CheckOrder.dmn");
        //InputStream file = new FileInputStream("/" + DMN_PATH);     // ALWAYS null
        //InputStream file = new FileInputStream("../../../../" + DMN_PATH);
        //InputStream file = new FileInputStream("../../../" + DMN_PATH);
        //InputStream file = new FileInputStream("." + DMN_PATH);
        InputStream file = new FileInputStream("classpath:" + DMN_PATH);

        // configure and build the DMN engine
        DmnEngine dmnEngine = DmnEngineConfiguration.createDefaultDmnEngineConfiguration().buildEngine();

        // parse a decision
        DmnDecision decision = dmnEngine.parseDecision("orderDecision", file);

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("status", "gold");
        data.put("sum", 354.12d);

        // evaluate a decision
        DmnDecisionTableResult result = dmnEngine.evaluateDecisionTable(decision, data);
    }
}
