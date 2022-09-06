// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package com.amazon.micronaut;

import jakarta.inject.Singleton;

@Singleton
public class MicronautService {

    public String sayHello() {
        return "Hello from Micronaut";
    }

}
