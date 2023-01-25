package net.local.poc.springcqrs.infra.generators;

import java.util.UUID;

import org.springframework.stereotype.Component;

import net.local.poc.springcqrs.application.ports.generators.IdGenerator;

@Component
public class UuidBookGenerator implements IdGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
    
}
