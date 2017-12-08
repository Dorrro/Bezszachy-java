package com.bezszachy.models.figures;

import com.bezszachy.Constants;
import com.bezszachy.models.enums.Color;
import com.bezszachy.models.enums.FigureTypes;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Figure // Goniec
{
    public Bishop(Position position, Color color) {
        super(position, color, FigureTypes.B, generatePossibleMoves());
    }

    private static PossibleMove[] generatePossibleMoves() {
        List<PossibleMove> possibleMoves = new ArrayList<>();

        for (int i = 1; i < Constants.getInstance().getFieldSize(); i++) {
            possibleMoves.add(new PossibleMove(i, i));
            possibleMoves.add(new PossibleMove(-i, i));
            possibleMoves.add(new PossibleMove(i, -i));
            possibleMoves.add(new PossibleMove(-i, -i));
        }

        PossibleMove[] moves = new PossibleMove[possibleMoves.size()];

        return possibleMoves.toArray(moves);
    }

    @Override
    protected List<Position> getVariations(PossibleMove move) {
        List<Position> positions = new ArrayList<>();
        move = getNewMove(move);

        while (Math.abs(move.getI()) >= 1 && Math.abs(move.getJ()) >= 1) {
            positions.add(super.getFuturePosition(move));
            move = getNewMove(move);
        }

        return positions;
    }

    private PossibleMove getNewMove(PossibleMove move) {
        return new PossibleMove(
                move.getI() > 0 ? decrement(move.getI()) : increment(move.getI()),
                move.getJ() > 0 ? decrement(move.getJ()) : increment(move.getJ()));
    }

    private int increment(int i) {
        return i + 1;
    }

    private int decrement(int i) {
        return i - 1;
    }
}
