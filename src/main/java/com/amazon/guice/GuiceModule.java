// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package com.amazon.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GuiceService.class).to(GuiceServiceImpl.class);
        bind(GuiceEntryPoint.class).in(Singleton.class);
    }
}
