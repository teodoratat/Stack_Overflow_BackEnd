package com.utcn.demo.Persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

    /** Creates a bean that customizes the ObjectMapper used by Jackson.
     In this case, the mixIn() method is called to specify
     that a HibernateProxyMixin should be mixed in with all objects. */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
        return builder -> builder.mixIn(Object.class, HibernateProxyMixin.class);
    }


    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    public static class HibernateProxyMixin {
    }
}