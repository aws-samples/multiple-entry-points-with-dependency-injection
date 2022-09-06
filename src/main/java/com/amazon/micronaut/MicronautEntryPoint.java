package com.amazon.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

import java.util.Optional;

public class MicronautEntryPoint {

    public static void main(String[] args) {
        ApplicationContext applicationContext = Micronaut.run(MicronautEntryPoint.class, args);

        /*
         * If an alternative entry point property exists, then determine if there is business logic that is mapped to
         * that property.  If so, run the logic and exit.  If an alternative entry point property does not exist, then
         * allow the spring application to run as normal.
         */
        Optional.ofNullable(System.getenv("alternativeEntryPoint"))
                .ifPresent(
                        arg -> {
                            int exitCode = 0;

                            try(applicationContext) {
                                if (arg.equals("helloService")) {
                                    String hello = applicationContext.getBean(MicronautService.class).sayHello();
                                    System.out.println(hello);
                                }
                                else {
                                    throw new IllegalArgumentException(
                                            String.format("Did not recognize alternativeEntryPoint, %s", arg)
                                    );
                                }
                            }
                            catch (Exception e) {
                                exitCode = 1;
                                e.printStackTrace();
                            }
                            finally {
                                System.out.println("Closing application context");
                            }

                            /*
                            If there is an alternative entry point listed, then we always want to exit the JVM so the
                            spring app does not throw an exception after we close the applicationContext.  Both the
                            applicationContext and JVM should be closed/exited to prevent exceptions.
                            */
                            System.out.println("Exiting JVM");
                            System.exit(exitCode);
                        });
    }

}