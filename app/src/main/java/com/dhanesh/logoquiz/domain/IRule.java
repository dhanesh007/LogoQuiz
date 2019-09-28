package com.dhanesh.logoquiz.domain;

public interface IRule<T> {
    ValidationResult validate(T obj1, T obj2);
}
