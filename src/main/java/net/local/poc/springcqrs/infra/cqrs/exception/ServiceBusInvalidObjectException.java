package net.local.poc.springcqrs.infra.cqrs.exception;

import net.local.poc.springcqrs.infra.cqrs.events.InternalEvent;

public class ServiceBusInvalidObjectException extends RuntimeException {

    public ServiceBusInvalidObjectException(InternalEvent event) {
        super(String.format("ServiceBus does not recognizes Object of type: %s",
                event.getSource().getClass().getCanonicalName()));
    }
}
