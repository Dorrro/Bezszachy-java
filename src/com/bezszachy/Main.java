package com.bezszachy;

import com.bezszachy.models.enums.Color;
import com.bezszachy.models.figures.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        new Bezszachy(new ArrayList() {
            {
                add(new Rook(new Position(0, 0), Color.W));
                add(new Knight(new Position(1, 0), Color.W));
                add(new Bishop(new Position(2, 0), Color.W));
                add(new Queen(new Position(3, 0), Color.W));
                add(new King(new Position(4, 0), Color.W));
                add(new Bishop(new Position(5, 0), Color.W));
                add(new Knight(new Position(6, 0), Color.W));
                add(new Rook(new Position(7, 0), Color.W));

                add(new Rook(new Position(0, Constants.getInstance().getFieldSize() - 1), Color.B));
                add(new Knight(new Position(1, Constants.getInstance().getFieldSize() - 1), Color.B));
                add(new Bishop(new Position(2, Constants.getInstance().getFieldSize() - 1), Color.B));
                add(new Queen(new Position(3, Constants.getInstance().getFieldSize() - 1), Color.B));
                add(new King(new Position(4, Constants.getInstance().getFieldSize() - 1), Color.B));
                add(new Bishop(new Position(5, Constants.getInstance().getFieldSize() - 1), Color.B));
                add(new Knight(new Position(6, Constants.getInstance().getFieldSize() - 1), Color.B));
                add(new Rook(new Position(7, Constants.getInstance().getFieldSize() - 1), Color.B));
            }
        }, 200).printField().play();
    }
}
