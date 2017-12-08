package com.bezszachy.models.figures;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Position) {
            Position position = (Position) obj;
            return position.getX() == this.x && position.getY() == this.y;
        }

        return false;
    }
}
