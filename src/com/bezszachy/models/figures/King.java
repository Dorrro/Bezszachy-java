package com.bezszachy.models.figures;

import com.bezszachy.models.enums.Color;
import com.bezszachy.models.enums.FigureTypes;

public class King extends Figure // Król
{
    public King(Position position, Color color) {
        super(position, color, FigureTypes.K, new PossibleMove[]{
                new PossibleMove(1, 1),
                new PossibleMove(-1, 1),
                new PossibleMove(-1, -1),
                new PossibleMove(1, -1),
                new PossibleMove(0, -1),
                new PossibleMove(0, 1),
                new PossibleMove(1, 0),
                new PossibleMove(-1, 0)
        });
    }
}
