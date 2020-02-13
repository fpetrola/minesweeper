package com.minesweeper;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.validation.ValidationExceptionMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import(value = {ApiServerConfiguration.class})
@EnableConfigurationProperties
public class ServiceConfiguration {

    @Bean
    public Server checkoutServiceServer(ApiServerBuilder apiServerBuilder) {
        MineSweeperApi checkoutApi = new MineSweeperApiImpl(new GameRepository());

        Server server = apiServerBuilder
                .withProviders(new ValidationExceptionMapper())
                .withJaxrsClassesPackagePrefix("com.minesweeper")
                .withApplicationName("test1")
                .forServices(checkoutApi)
                .build();

        return server;
    }
}
