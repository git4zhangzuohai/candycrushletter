package com.example;

import java.util.List;

public interface Command<T> {
    T execute();
}
