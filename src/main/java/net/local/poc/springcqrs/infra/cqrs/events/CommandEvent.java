package net.local.poc.springcqrs.infra.cqrs.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.local.poc.springcqrs.infra.cqrs.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandEvent extends InternalEvent {

    private final Command command;

    public CommandEvent(Command command) {
        startTimer();
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    @Override
    public Object getSource() {
        return getCommand();
    }

    public String toJson() {

        try {
            var mapper = new ObjectMapper();
            Map<String, Object> message = new HashMap<>(Map.of("event", getOrigin()));
            message.put("content", getCommand());
            message.put("elapsedTimeInMilli", getElapsedTimeInMilli());
            if (hasError()) {
                message.put("message", getException().getMessage());
            }
            return mapper.writeValueAsString(message);
        } catch (JsonProcessingException jsonException) {
            return String.format("%s - %s", command, jsonException);
        }
    }
}
