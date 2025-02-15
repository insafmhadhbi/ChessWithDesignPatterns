// Source code is decompiled from a .class file using FernFlower decompiler.
package com.chess.pieces;

import com.chess.board.Square;
import com.chess.patterns.MovementStrategy;

class KnightMovementStrategy implements MovementStrategy {
    KnightMovementStrategy() {
    }

    public boolean isValidMove(Square var1, Square var2, Square[][] var3) {
        int var4 = Math.abs(var2.getRow() - var1.getRow());
        int var5 = Math.abs(var2.getCol() - var1.getCol());
        return var4 == 2 && var5 == 1 || var4 == 1 && var5 == 2;
    }
}
