package tests.bezszachy.figures;

import com.bezszachy.models.enums.Color;
import com.bezszachy.models.enums.FigureTypes;
import com.bezszachy.models.figures.Figure;
import com.bezszachy.models.figures.Position;
import com.bezszachy.models.figures.PossibleMove;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import tests.bezszachy.figures.helpers.FigureForTestImpl;

import java.util.List;
import java.util.Optional;

@RunWith(Theories.class)
public class FigureTest{

    @DataPoints("gettersTestPositions")
    public static Position[] positions = {
        new Position(2,5),
        new Position(3, 12),
        new Position(200, 7)
    };

    @DataPoints("gettersTestColors")
    public static Color[] colors = {
        Color.W,
        Color.B
    };

    @DataPoints("gettersTestFigureTypes")
    public static FigureTypes[] figureTypes = {
      FigureTypes.J,
      FigureTypes.B,
      FigureTypes.K,
      FigureTypes.Q,
      FigureTypes.R
    };

    @Theory
    public void Given_SpecifiedParameters_When_CreatingFigure_Then_GettersShouldReturnThem(
            @FromDataPoints("gettersTestPositions") Position position,
            @FromDataPoints("gettersTestColors") Color color,
            @FromDataPoints("gettersTestFigureTypes") FigureTypes figureType) {
        // arrange
        PossibleMove[] possibleMoves = {};

        // act
        Figure figure = new FigureForTestImpl(position, color, figureType, possibleMoves);

        // assert
        Assert.assertEquals(position, figure.getPosition());
        Assert.assertEquals(color, figure.getColor());
        Assert.assertEquals(figureType.name() + "-" + color.name(), figure.toString());
    }

    @Theory
    public void Given_EmptyPossibleMoves_When_CallingToMove_ShouldReturnEmptyOptional()
    {
        // arrange
        PossibleMove[] emptyPossibleMove = {};

        FigureForTestImpl figureForTest = new FigureForTestImpl(new Position(1, 2), Color.W, FigureTypes.B, emptyPossibleMove);

        // act
        Optional<Position> result = figureForTest.move(List.of());

        // assert
        Assert.assertEquals(result, Optional.empty());
    }
}