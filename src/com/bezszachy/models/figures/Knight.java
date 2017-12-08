package com.bezszachy.models.figures;

import com.bezszachy.models.enums.Color;
import com.bezszachy.models.enums.FigureTypes;

public class Knight extends Figure// skoczek
{
    public Knight(Position position, Color color) {
        super(position, color, FigureTypes.J, new PossibleMove[]{
                new PossibleMove(2, 1),
                new PossibleMove(2, 1),
                new PossibleMove(-2, 1),
                new PossibleMove(2, -1),
                new PossibleMove(-2, -1),
                new PossibleMove(1, 2),
                new PossibleMove(-1, 2),
                new PossibleMove(1, -2),
                new PossibleMove(-1, -2)
        });
    }
}
