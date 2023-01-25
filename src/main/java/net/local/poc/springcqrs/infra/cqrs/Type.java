package net.local.poc.springcqrs.infra.cqrs;

public enum Type {

    COMMAND("Command"),
    QUERY("Query");

    private String typeName;

    Type(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }
}
