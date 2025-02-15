// Source code is decompiled from a .class file using FernFlower decompiler.
package com.chess.pieces;

import com.chess.board.Square;
import com.chess.patterns.MovementStrategy;

class BishopMovementStrategy implements MovementStrategy {
    BishopMovementStrategy() {
    }

    public boolean isValidMove(Square var1, Square var2, Square[][] var3) {
        int var4 = Math.abs(var2.getRow() - var1.getRow());
        int var5 = Math.abs(var2.getCol() - var1.getCol());
        if (var4 != var5) {
            return false;
        } else {
            int var6 = Integer.compare(var2.getRow(), var1.getRow());
            int var7 = Integer.compare(var2.getCol(), var1.getCol());
            int var8 = var1.getRow() + var6;

            for (int var9 = var1.getCol() + var7; var8 != var2.getRow() && var9 != var2.getCol(); var9 += var7) {
                if (var3[var8][var9].getPiece() != null) {
                    return false;
                }

                var8 += var6;
            }

            return true;
        }
    }
}
