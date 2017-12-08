package com.bezszachy.models.figures;

import com.bezszachy.Constants;
import com.bezszachy.models.enums.Color;
import com.bezszachy.models.enums.FigureTypes;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Figure // Królowa
{
    public Queen(Position position, Color color) {
        super(position, color, FigureTypes.Q, generatePossibleMoves());
    }

    private static PossibleMove[] generatePossibleMoves() {
        List<PossibleMove> possibleMoves = new ArrayList<>();

        for (int i = 1; i < Constants.getInstance().getFieldSize(); i++) {
            possibleMoves.add(new PossibleMove(i, i));
            possibleMoves.add(new PossibleMove(-i, i));
            possibleMoves.add(new PossibleMove(i, -i));
            possibleMoves.add(new PossibleMove(-i, -i));
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

        if (move.getI() != 0 && move.getJ() != 0) {
            getBishopLikePositions(move, positions);
        } else {
            getRookLikePositions(move, positions);
        }

        return positions;
    }

    private void getRookLikePositions(PossibleMove move, List<Position> positions) {
        move = getNewRookLikeMove(move);

        while (Math.abs(move.getI()) >= 1 || Math.abs(move.getJ()) >= 1) {
            positions.add(super.getFuturePosition(move));
            move = getNewRookLikeMove(move);
        }
    }

    private PossibleMove getNewRookLikeMove(PossibleMove move) {
        return new PossibleMove(
                move.getI() > 0 ? decrement(move.getI()) : move.getI() < 0 ? increment(move.getI()) : 0,
                move.getJ() > 0 ? decrement(move.getJ()) : move.getJ() < 0 ? increment(move.getJ()) : 0);
    }

    private void getBishopLikePositions(PossibleMove move, List<Position> positions) {
        move = getNewBishopLikeMove(move);

        while (Math.abs(move.getI()) >= 1 && Math.abs(move.getJ()) >= 1) {
            positions.add(super.getFuturePosition(move));
            move = getNewBishopLikeMove(move);
        }
    }

    private PossibleMove getNewBishopLikeMove(PossibleMove move) {
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
