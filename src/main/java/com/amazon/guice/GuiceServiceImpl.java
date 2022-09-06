// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package com.amazon.guice;

public class GuiceServiceImpl implements GuiceService {

    @Override
    public String sayHello() {
        return "Hello from Guice & Java Spark";
    }

}
