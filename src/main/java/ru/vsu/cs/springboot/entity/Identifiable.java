package ru.vsu.cs.springboot.entity;

public interface Identifiable<T> {
    void setId(T id);
    T getId();
}
