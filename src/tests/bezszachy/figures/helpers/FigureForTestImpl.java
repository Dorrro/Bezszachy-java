package tests.bezszachy.figures.helpers;

import com.bezszachy.models.enums.Color;
import com.bezszachy.models.enums.FigureTypes;
import com.bezszachy.models.figures.Figure;
import com.bezszachy.models.figures.Position;
import com.bezszachy.models.figures.PossibleMove;

public class FigureForTestImpl extends Figure {
    public FigureForTestImpl(Position position, Color color, FigureTypes figureType, PossibleMove[] possibleMoves) {
        super(position, color, figureType, possibleMoves);
    }
}
