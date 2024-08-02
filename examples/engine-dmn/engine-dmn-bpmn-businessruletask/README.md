# Goal
* "engine-dmn" / BPMN Business Rule Task

## How has it been created?
* `mvn archetype:generate -DgroupId=org.camunda.bpm.example -DartifactId=engine-dmn-bpmn-businessruletask -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`
* Follow "engine-dmn"'s README.md

## How to run it locally?
* Place the cursor | "engine-dmn-bpmn-businessruletask/src/main/java"
* via 
  * Maven
    * `mvn clean compile`
    * `mvn exec:java -Dexec.mainClass="org.camunda.bpm.example.App"`
      * Problems:
        * Problem1: "Error setting driver on UnpooledDataSource. Cause: java.lang.ClassNotFoundException: org.h2.Driver"
          * Solution: TODO:
  * Java
    * `javac org/camunda/bpm/example/App.java`
      * Problems:
        * Problem1: "error: package org.camunda.bpm.dmn.engine does not exist"
          * Solution: TODO:
          