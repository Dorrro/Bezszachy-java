package com.bezszachy.models.figures;

import com.bezszachy.Constants;
import com.bezszachy.models.enums.Color;
import com.bezszachy.models.enums.FigureTypes;

import java.util.*;
import java.util.stream.Collectors;

public class Figure {
    protected PossibleMove[] possibleMoves;
    protected FigureTypes figureType;
    private Position position;
    private Color color;

    protected Figure(Position position, Color color, FigureTypes figureType, PossibleMove[] possibleMoves) {
        this.position = position;
        this.color = color;
        this.figureType = figureType;
        this.possibleMoves = possibleMoves;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.figureType.name() + "-" + this.color.name();
    }

    public Optional<Position> move(List<Figure> figures) {
        List<PossibleMove> shuffledMoves = Arrays.asList(this.possibleMoves);
        Collections.shuffle(shuffledMoves);

        for (PossibleMove move : shuffledMoves) {
            Position futurePosition = getFuturePosition(move);
            List<Position> variations = getVariations(move);

            if (isOutOfBounds(futurePosition) || isOpponentOnTheWay(figures, variations)) {
                continue;
            }

            System.out.println(String.format("%s rusza się z (x: %d, y: %d) na (x: %d, y: %d)", this.toString(), this.position.getX(), this.position.getY(), futurePosition.getX(), futurePosition.getY()));

            Optional<Figure> opponent = figures
                    .stream()
                    .filter(f -> HasExactPostion(futurePosition, f))
                    .filter(f -> f.getColor() != this.getColor())
                    .findFirst();

            if (opponent.isPresent()) {
                figures.remove(opponent.get());
                System.out.println(String.format("%s zbija %s", this.toString(), opponent.get().toString()));
            }

            this.position = futurePosition;

            return Optional.of(futurePosition);
        }

        return Optional.empty();
    }

    private boolean isOpponentOnTheWay(List<Figure> figures, List<Position> variations) {

        for (Position pos :
                figures.stream().map(f -> f.position).collect(Collectors.toList())) {
            for (Position pos2 :
                    variations) {
                if (pos.equals(pos2)) {
                    return true;
                }
            }
        }

        return false;
//        return figures.stream().anyMatch(f -> variations.stream().anyMatch(v -> v.equals(f)));
    }

    protected List<Position> getVariations(PossibleMove move) {
        return new ArrayList<>();
    }

    protected Position getFuturePosition(PossibleMove move) {
        return new Position(this.position.getX() + move.getI(), this.position.getY() + move.getJ());
    }

    private boolean HasExactPostion(Position futurePosition, Figure f) {
        return f.getPosition().getX() == futurePosition.getX() && f.getPosition().getY() == futurePosition.getY();
    }

    private boolean isOutOfBounds(Position futurePosition) {
        return futurePosition.getX() >= Constants.getInstance().getFieldSize() || futurePosition.getX() < 0
                || futurePosition.getY() >= Constants.getInstance().getFieldSize() || futurePosition.getY() < 0;
    }
}
