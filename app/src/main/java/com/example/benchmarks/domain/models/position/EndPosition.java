package com.example.benchmarks.domain.models.position;

public class EndPosition implements Position {
    public int getPosition(int size) {
        return size - 1;
    }
}
