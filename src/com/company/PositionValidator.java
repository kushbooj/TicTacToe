package com.company;

public class PositionValidator implements Validator {
    @Override
    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }
}
