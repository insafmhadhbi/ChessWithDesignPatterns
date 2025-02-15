// Source code is decompiled from a .class file using FernFlower decompiler.
package com.chess.pieces;

import com.chess.board.Square;
import com.chess.patterns.MovementStrategy;

class RookMovementStrategy implements MovementStrategy {
    RookMovementStrategy() {
    }

    public boolean isValidMove(Square var1, Square var2, Square[][] var3) {
        if (var1.getRow() != var2.getRow() && var1.getCol() != var2.getCol()) {
            return false;
        } else {
            int var4 = Integer.compare(var2.getRow(), var1.getRow());
            int var5 = Integer.compare(var2.getCol(), var1.getCol());
            int var6 = var1.getRow() + var4;

            for (int var7 = var1.getCol() + var5; var6 != var2.getRow() || var7 != var2.getCol(); var7 += var5) {
                if (var3[var6][var7].getPiece() != null) {
                    return false;
                }

                var6 += var4;
            }

            return true;
        }
    }
}
