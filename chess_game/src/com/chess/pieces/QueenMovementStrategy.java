// Source code is decompiled from a .class file using FernFlower decompiler.
package com.chess.pieces;

import com.chess.board.Square;
import com.chess.patterns.MovementStrategy;

class QueenMovementStrategy implements MovementStrategy {
    private final RookMovementStrategy rookStrategy = new RookMovementStrategy();
    private final BishopMovementStrategy bishopStrategy = new BishopMovementStrategy();

    QueenMovementStrategy() {
    }

    public boolean isValidMove(Square var1, Square var2, Square[][] var3) {
        return this.rookStrategy.isValidMove(var1, var2, var3) || this.bishopStrategy.isValidMove(var1, var2, var3);
    }
}
