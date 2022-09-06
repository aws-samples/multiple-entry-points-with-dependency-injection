// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package com.amazon.spring;

import org.springframework.stereotype.Service;

@Service
public class SpringService {

    public String sayHello() {
        return "Hello from Spring";
    }

}
