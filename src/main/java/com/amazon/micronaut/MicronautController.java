// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package com.amazon.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller
public class MicronautController {

    private final MicronautService springService;

    @Inject
    public MicronautController(MicronautService springService) {
        this.springService = springService;
    }

    @Get
    public String sayHello() {
        return this.springService.sayHello();
    }

}
