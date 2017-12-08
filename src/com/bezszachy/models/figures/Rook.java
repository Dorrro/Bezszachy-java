package com.bezszachy.models.figures;

import com.bezszachy.Constants;
import com.bezszachy.models.enums.Color;
import com.bezszachy.models.enums.FigureTypes;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Figure// wieża
{
    public Rook(Position position, Color color) {
        super(position, color, FigureTypes.R, generatePossibleMoves());
    }

    private static PossibleMove[] generatePossibleMoves() {
        List<PossibleMove> possibleMoves = new ArrayList<>();

        for (int i = 1; i < Constants.getInstance().getFieldSize(); i++) {
            possibleMoves.add(new PossibleMove(i, 0));
            possibleMoves.add(new PossibleMove(0, i));
            possibleMoves.add(new PossibleMove(-i, 0));
            possibleMoves.add(new PossibleMove(0, -i));
        }

        PossibleMove[] moves = new PossibleMove[possibleMoves.size()];

        return possibleMoves.toArray(moves);
    }

    protected List<Position> getVariations(PossibleMove move) {
        List<Position> positions = new ArrayList<>();

        move = getNewMove(move);

        while (Math.abs(move.getI()) >= 1 || Math.abs(move.getJ()) >= 1) {
            positions.add(super.getFuturePosition(move));
            move = getNewMove(move);
        }

        return positions;
    }

    private PossibleMove getNewMove(PossibleMove move) {
        return new PossibleMove(
                move.getI() > 0 ? decrement(move.getI()) : move.getI() < 0 ? increment(move.getI()) : 0,
                move.getJ() > 0 ? decrement(move.getJ()) : move.getJ() < 0 ? increment(move.getJ()) : 0);
    }

    private int increment(int i) {
        return i + 1;
    }

    private int decrement(int i) {
        return i - 1;
    }
}
