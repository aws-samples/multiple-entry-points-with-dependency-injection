This repo is a proof of concept demonstrating how to invoke multiple entry points using popular dependency injection frameworks
such as Spring, Micronaut, and Guice with Java Spark.  Follow the steps below to complete the demonstrations.

### Build the jar
1. `cd` to the project's root directory.
2. Run `mvn clean install`.

#### Spring Boot
1. `cd` to the project's root directory.
2. Run `export ALTERNATIVE_ENTRY_POINT=periodicRun && export AMOUNT_TO_TAX=10`.
3. Run `java -cp ./target/multiple-entry-points-with-dependency-injection-1.0-SNAPSHOT.jar com.amazon.spring.SpringBootEntryPoint`.  You should see
   `Tax is 0.7` among the output and the Spring app and JVM should exit.
4. Run `unset ALTERNATIVE_ENTRY_POINT && unset AMOUNT_TO_TAX`.
5. Run `java -cp ./target/multiple-entry-points-with-dependency-injection-1.0-SNAPSHOT.jar com.amazon.spring.SpringBootEntryPoint` again.
6. Open another terminal and run `curl http://localhost:8080?amountToTax=10`.  You should see `0.7` as the output.
7. Close the app by pressing Ctrl+C.

#### Micronaut
1. `cd` to the project's root directory.
2. Run `export ALTERNATIVE_ENTRY_POINT=periodicRun && export AMOUNT_TO_TAX=10`.
3. Run `java -cp ./target/multiple-entry-points-with-dependency-injection-1.0-SNAPSHOT.jar com.amazon.micronaut.MicronautEntryPoint`.  You should see
   `Tax is 0.7` among the output and the Micronaut app and JVM should exit.
4. Run `unset ALTERNATIVE_ENTRY_POINT && unset AMOUNT_TO_TAX`.
5. Run `java -cp ./target/multiple-entry-points-with-dependency-injection-1.0-SNAPSHOT.jar com.amazon.micronaut.MicronautEntryPoint` again.
6. Open another terminal and run `curl http://localhost:8080?amountToTax=10`.  You should see `0.7` as the output.
7. Close the app by pressing Ctrl+C.

#### Guice with Spark Java
1. `cd` to the project's root directory.
2. Run `export ALTERNATIVE_ENTRY_POINT=periodicRun && export AMOUNT_TO_TAX=10`.
3. Run `java -cp ./target/multiple-entry-points-with-dependency-injection-1.0-SNAPSHOT.jar com.amazon.guice.GuiceEntryPoint`.  You should see
   `Tax is 0.7` among the output and the Guice and Java Spark app and JVM should exit.
4. Run `unset ALTERNATIVE_ENTRY_POINT && unset AMOUNT_TO_TAX`.
5. Run `java -cp ./target/multiple-entry-points-with-dependency-injection-1.0-SNAPSHOT.jar com.amazon.guice.GuiceEntryPoint` again.
6. Open another terminal and run `curl http://localhost:8080?amountToTax=10`.  You should see `0.7` as the output.
7. Close the app by pressing Ctrl+C.

#### Kubernetes 
**Note:** In order to complete the steps below, you will need a Kubernetes cluster.  One of the simplest solutions is, if 
you have Docker Desktop, you can enable a local Kubernetes cluster.  Follow these directions to do so: https://docs.docker.com/desktop/kubernetes/#enable-kubernetes  

### CronJob
1. `cd` to the project's root directory.
2. Build the docker image by running `docker build -t "$(whoami)"/multiple-entry-points:local .`.
3. Run `docker images`.  You should see the image in the output.
4. Run `k8s/replace_username.sh k8s/cronjob.yml | kubectl apply -f -` to create the Kubernetes CronJob resource that executes every 1 minute.
5. Run `kubectl get jobs --watch` to watch the jobs that the CronJob resource creates.
6. Once a job is created, get job's pod name by running `pods=$(kubectl get pods --selector=job-name={job name goes here} --output=jsonpath={.items[*].metadata.name})`.
Be sure to replace the placeholder with the name of the job.  For example, if the job name is `my-service-27808790`, then the command would be
`pods=$(kubectl get pods --selector=job-name=my-service-27808790 --output=jsonpath={.items[*].metadata.name})`.
7. Run `kubectl logs $pods` to see the logs of the job's pod.  You should see `Tax is 0.7` among the output.
8. Clean up the CronJob resource by running `k8s/replace_username.sh k8s/cronjob.yml | kubectl delete -f -`.

### REST API Pod
1. Run `k8s/replace_username.sh k8s/pod.yml | kubectl apply -f -` to create a pod for the REST API.
2. Run `kubectl apply -f k8s/service.yml` to create a service that exposes the REST API pod to clients outside the Kubernetes cluster.
3. Run `curl http://localhost:30000?amountToTax=10`.  You should see `0.7` as the output.
4. Clean up the Service and Pod resources by running `kubectl delete -f k8s/service.yml && k8s/replace_username.sh k8s/pod.yml | kubectl delete -f -`.