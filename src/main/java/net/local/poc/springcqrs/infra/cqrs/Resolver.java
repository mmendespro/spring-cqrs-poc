package net.local.poc.springcqrs.infra.cqrs;

public interface Resolver<T extends Query> {
    void resolve(T query);
}
