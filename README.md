## Multiple Entry Points with Java Dependency Injection Frameworks

At a high level, this repo is a proof of concept demonstrating how to invoke multiple entry points using popular dependency injection frameworks
such as Spring, Micronaut, and Guice with Java Spark.

More specifically, each of the examples below demonstrates how you can invoke a bean's logic, which says `hello`, directly or through 
a RESTful API by setting the environment variable, `alternativeEntryPoint`.

### Build the jar
1. `cd` to the project's root directory.
2. Run `mvn clean install`.

#### Spring Boot
1. `cd` to the project's root directory.
2. Run `export alternativeEntryPoint=helloService`.
3. Run `java -cp ./target/multiple-entry-points-with-dependency-injection-1.0-SNAPSHOT.jar com.amazon.spring.SpringBootEntryPoint`.  You should see
   `Hello from Spring` among the output and the Spring app and JVM should exit.
4. Run `unset alternativeEntryPoint`.
5. Run `java -cp ./target/multiple-entry-points-with-dependency-injection-1.0-SNAPSHOT.jar com.amazon.spring.SpringBootEntryPoint` again.
6. Open another terminal and run `curl http://localhost:8080`.  You should see `Hello from Spring` as the output.
7. Close the app by pressing Ctrl+C.

#### Micronaut
1. `cd` to the project's root directory.
2. Run `export alternativeEntryPoint=helloService`.
3. Run `java -cp ./target/multiple-entry-points-with-dependency-injection-1.0-SNAPSHOT.jar com.amazon.micronaut.MicronautEntryPoint`.  You should see
   `Hello from Micronaut` among the output and the Micronaut app and JVM should exit.
4. Run `unset alternativeEntryPoint`.
5. Run `java -cp ./target/multiple-entry-points-with-dependency-injection-1.0-SNAPSHOT.jar com.amazon.micronaut.MicronautEntryPoint` again.
6. Open another terminal and run `curl http://localhost:8080`.  You should see `Hello from Micronaut` as the output.
7. Close the app by pressing Ctrl+C.

#### Guice with Spark Java
1. `cd` to the project's root directory.
2. Run `export alternativeEntryPoint=helloService`.
3. Run `java -cp ./target/multiple-entry-points-with-dependency-injection-1.0-SNAPSHOT.jar com.amazon.guice.GuiceEntryPoint`.  You should see
   `Hello from Guice & Java Spark` among the output and the Guice and Java Spark app and JVM should exit.
4. Run `unset alternativeEntryPoint`.
5. Run `java -cp ./target/multiple-entry-points-with-dependency-injection-1.0-SNAPSHOT.jar com.amazon.guice.GuiceEntryPoint` again.
6. Open another terminal and run `curl http://localhost:8080`.  You should see `Hello from Guice & Java Spark` as the output.
7. Close the app by pressing Ctrl+C.

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This library is licensed under the MIT-0 License. See the LICENSE file.

