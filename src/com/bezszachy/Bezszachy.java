package com.bezszachy;

import com.bezszachy.models.enums.Color;
import com.bezszachy.models.figures.Figure;
import com.bezszachy.models.figures.Position;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Bezszachy {
    private int movesLimit = 300;
    private Color side = Color.W;
    private List<Figure> figures;

    public Bezszachy(List<Figure> figures, int movesLimit, Color side) {
        this.movesLimit = movesLimit;
        this.side = side;
        this.figures = figures;
    }

    public Bezszachy(List<Figure> figures, int movesLimit) {
        this(figures, movesLimit, Color.W);
    }

    public Bezszachy(List<Figure> figures) {
        this(figures, 1000, Color.W);
    }

    public void play() {
        List<Figure> shuffledFigures = figures.stream().filter(f -> f.getColor() == this.side).collect(Collectors.toList());
        Collections.shuffle(shuffledFigures);

        System.out.println();
        System.out.println();
        boolean couldMove = CanMoveAnyFigure(shuffledFigures);

        this.switchSides();

        if (!couldMove) {
            System.out.println(String.format("Koniec gry. Z powodu braku mozliwosci ruchu przeciwnika zwycieza kolor %s", this.side));
        } else {
            this.movesLimit--;
            this.printField();
            System.out.println(String.format("Pozostało ruchów: %d", this.movesLimit));

            if (this.movesLimit == 0) {
                System.out.println("Koniec gry. Limit ruchów wykorzystany. Remis");
            } else {
                this.play();
            }
        }
    }

    private boolean CanMoveAnyFigure(List<Figure> shuffledFigures) {
        for (Figure figure :
                shuffledFigures) {
            Optional<Position> newFigurePosition = figure.move(this.figures);
            if (newFigurePosition.isPresent()) {
                return true;
            }
        }
        return false;
    }

    private void switchSides() {
        this.side = this.side == Color.W ? Color.B : Color.W;
    }

    public Bezszachy printField() {
        String[][] tmpField = PrepareField();

        applyExistingFigures(tmpField);

        System.out.println();
        for (int row = 0; row < Constants.getInstance().getFieldSize(); row++) {
            System.out.print('|');
            for (int column = 0; column < Constants.getInstance().getFieldSize(); column++) {
                System.out.print(String.format(" %s |", tmpField[column][row]));
            }
            System.out.println();
            for (int i = 0; i <= Constants.getInstance().getFieldSize() * 6; i++) {
                System.out.print('_');
            }
            System.out.println();
        }

        return this;
    }

    private void applyExistingFigures(String[][] tmpField) {
        for (Figure figure :
                this.figures) {
            Position figurePosition = figure.getPosition();
            tmpField[figurePosition.getX()][figurePosition.getY()] = figure.toString();
        }
    }

    private String[][] PrepareField() {
        String[][] tmpField = new String[Constants.getInstance().getFieldSize()][Constants.getInstance().getFieldSize()];
        for (int row = 0; row < Constants.getInstance().getFieldSize(); row++) {
            for (int column = 0; column < Constants.getInstance().getFieldSize(); column++) {
                tmpField[row][column] = "...";
            }
        }
        return tmpField;
    }
}
