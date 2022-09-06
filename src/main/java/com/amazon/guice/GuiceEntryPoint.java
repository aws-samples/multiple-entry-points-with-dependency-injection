// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package com.amazon.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Optional;

import static spark.Spark.get;
import static spark.Spark.port;

public class GuiceEntryPoint {

    private static Injector injector;

    public static void main(String[] args) {
        GuiceEntryPoint.injector = Guice.createInjector(new GuiceModule());

        /*
         * If an alternative entry point property exists, then determine if there is business logic that is mapped to
         * that property.  If so, run the logic and exit.  If an alternative entry point property does not exist, then
         * allow the spring application to run as normal.
         */
        Optional.ofNullable(System.getenv("alternativeEntryPoint"))
                .ifPresent(
                        arg -> {
                            int exitCode = 0;

                            try {
                                if (arg.equals("helloService")) {
                                    String hello = injector.getInstance(GuiceService.class).sayHello();
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

        /*
        Run the Java Spark RESTful API.
         */
        injector.getInstance(GuiceEntryPoint.class)
                .run(8080);
    }

    void run(final int port) {
        final GuiceService guiceService = GuiceEntryPoint.injector.getInstance(GuiceService.class);

        port(port);

        get("/", (req, res) -> {
            return guiceService.sayHello();
        });
    }

}
