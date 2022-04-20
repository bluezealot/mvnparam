# Description

For the sake of https://stackoverflow.com/questions/71938015/how-to-pass-command-line-arument-in-spring-boot-app-when-running-from-command-li/71939103#71939103
Demonstrate how to pass arguments as environment variables to spring boot started by maven run goal.Firstly, add the following configuration into pom file.
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <environmentVariables>
                <CALLBACK_PORT>${env.callbackport}</CALLBACK_PORT>
                </environmentVariables>
            </configuration>
        </plugin>
    </plugins>
</build>

Secondly, when you run your application, add the corresponding parameter to fill in the placeholder in the pom file say "${env.callbackport}".
Then run the following command line, 
mvn spring-boot:run -Denv.callbackport="3221"
This terminal will have the output:
20:24:50.851 [main] INFO com.hoperun.java2ets.java2ets.Java2etsApplication - CALLBACK_PORT: 3221