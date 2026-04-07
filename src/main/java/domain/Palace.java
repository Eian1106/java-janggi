package domain;

import domain.pieces.MoveDirection;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Palace {
    private static final Position HAN_GENERAL_POSITION = new Position(4, 1);
    private static final Position CHO_GENERAL_POSITION = new Position(4, 8);

    public static boolean isPalacePosition(Position position) {
        Set<Position> palacePositions = new HashSet<>();
        palacePositions.add(HAN_GENERAL_POSITION);
        palacePositions.add(CHO_GENERAL_POSITION);

        List<List<Direction>> allAround = MoveDirection.ofAllAround();
        for (List<Direction> directions : allAround) {
            palacePositions.add(HAN_GENERAL_POSITION.move(directions.getFirst()));
            palacePositions.add(CHO_GENERAL_POSITION.move(directions.getFirst()));
        }

        return palacePositions.contains(position);
    }

    public static boolean isGeneralPosition(Position position) {
        return position.equals(CHO_GENERAL_POSITION) || position.equals(HAN_GENERAL_POSITION);
    }
}
