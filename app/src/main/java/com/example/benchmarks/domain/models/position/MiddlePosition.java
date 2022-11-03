package com.example.benchmarks.domain.models.position;

public class MiddlePosition implements Position {
    public int getPosition(int size) {
        return size / 2 - 1;
    }
}
