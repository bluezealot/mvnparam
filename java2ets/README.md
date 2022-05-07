# Description

For the sake of https://stackoverflow.com/questions/71938015/how-to-pass-command-line-arument-in-spring-boot-app-when-running-from-command-li/71939103#71939103

Demonstrate how to pass arguments as environment variables to spring boot started by maven run goal.

Firstly, add the following configuration into pom file.
```xml
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
```

Secondly, 
Then run the following command line, 

```mvn spring-boot:run -Denv.callbackport="3221"```

Don't forget to add the corresponding argument to fill in the placeholder in the pom file, in this example it is "${env.callbackport}".</br>
The terminal will have the output:

```20:24:50.851 [main] INFO com.hoperun.java2ets.java2ets.Java2etsApplication - CALLBACK_PORT: 3221```

# Add docker compose
cd to java2ets folder, follow the instructions below(in your terminal).
1. Build the docker compose.
```docker-compose build```
2. Run the docker image with docker-compose.
```docker-compose run -p 8080:8080 web```
   The spring boot web application is started up, access http://localhost:8080/my/firstget in web browser you will get "compose"(The environment variable value) in the screen.
3. Press Ctrl+C in the terminal of previous step to stop the running service.
4. Run the docker image with docker-compose by setting environment variable.
```docker-compose run -e CALLBACK_PORT=modified -p 8080:8080 web```
    Same with step2, access http://localhost:8080/my/firstget in web browser you will get "modified" (The environment variable value) in the screen.