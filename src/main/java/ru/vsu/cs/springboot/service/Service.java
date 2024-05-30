package ru.vsu.cs.springboot.service;

import ru.vsu.cs.springboot.entity.Identifiable;

import java.util.List;

public interface Service<T extends Identifiable<Id>, Id> {

    T add(T entity);

    T update(T entity);

    void delete(Id id);

    T getById(Id id);

    List<T> getAll();
}
