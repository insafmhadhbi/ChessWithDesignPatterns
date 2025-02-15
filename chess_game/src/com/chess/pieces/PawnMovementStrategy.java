// Source code is decompiled from a .class file using FernFlower decompiler.
package com.chess.pieces;

import com.chess.board.Square;
import com.chess.patterns.MovementStrategy;
import com.chess.players.Player;

class PawnMovementStrategy implements MovementStrategy {
    PawnMovementStrategy() {
    }

    public boolean isValidMove(Square var1, Square var2, Square[][] var3) {
        int var4 = var1.getPiece().getPlayer() == Player.WHITE ? -1 : 1;
        int var5 = var2.getRow() - var1.getRow();
        int var6 = Math.abs(var2.getCol() - var1.getCol());
        if (var6 == 0 && var5 == var4 && var2.getPiece() == null) {
            return true;
        } else if (var6 == 0
                && (var1.getPiece().getPlayer() == Player.WHITE && var1.getRow() == 6 && var5 == -2
                        || var1.getPiece().getPlayer() == Player.BLACK && var1.getRow() == 1 && var5 == 2)
                && var2.getPiece() == null && var3[var1.getRow() + var4][var1.getCol()].getPiece() == null) {
            return true;
        } else {
            return var6 == 1 && var5 == var4 && var2.getPiece() != null
                    && var2.getPiece().getPlayer() != var1.getPiece().getPlayer();
        }
    }
}
