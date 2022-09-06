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
