// package com.chess.game;

// import com.chess.board.Square;
// import com.chess.pieces.King;
// import com.chess.pieces.Piece;
// import com.chess.players.Player;

// public class GameRules {
//     private static GameRules instance;

//     private GameRules() {}

//     public static GameRules getInstance() {
//         if (instance == null) {
//             instance = new GameRules();
//         }
//         return instance;
//     }

//     public boolean isKingInCheck(Player player, Square[][] board) {
//         // Find the king's position
//         Square kingSquare = findKing(player, board);
//         if (kingSquare == null) return false;

//         // Check if any opponent's piece can capture the king
//         return canAnyPieceReachSquare(getOpponent(player), kingSquare, board);
//     }

//     public boolean isCheckmate(Player player, Square[][] board) {
//         if (!isKingInCheck(player, board)) {
//             return false;
//         }

//         // If king is in check and has no valid moves, it's checkmate
//         return !hasAnyValidMove(player, board);
//     }

//     public boolean isStalemate(Player player, Square[][] board) {
//         if (isKingInCheck(player, board)) {
//             return false;
//         }

//         // If king is not in check but has no valid moves, it's stalemate
//         return !hasAnyValidMove(player, board);
//     }

//     private boolean hasAnyValidMove(Player player, Square[][] board) {
//         for (int fromRow = 0; fromRow < 8; fromRow++) {
//             for (int fromCol = 0; fromCol < 8; fromCol++) {
//                 Square fromSquare = board[fromRow][fromCol];
//                 if (fromSquare.getPiece() != null && fromSquare.getPiece().getPlayer() == player) {
//                     if (hasValidMoves(fromSquare, board)) {
//                         return true;
//                     }
//                 }
//             }
//         }
//         return false;
//     }

//     private boolean hasValidMoves(Square fromSquare, Square[][] board) {
//         for (int toRow = 0; toRow < 8; toRow++) {
//             for (int toCol = 0; toCol < 8; toCol++) {
//                 Square toSquare = board[toRow][toCol];
//                 if (isValidMove(fromSquare, toSquare, board)) {
//                     // Try the move and see if it leaves king in check
//                     if (!wouldMoveLeaveKingInCheck(fromSquare, toSquare, board)) {
//                         return true;
//                     }
//                 }
//             }
//         }
//         return false;
//     }

//     public boolean wouldMoveLeaveKingInCheck(Square from, Square to, Square[][] board) {
//         // Save current state
//         Piece originalFromPiece = from.getPiece();
//         Piece originalToPiece = to.getPiece();

//         // Make move
//         to.setPiece(from.getPiece());
//         from.setPiece(null);

//         // Check if king is in check
//         boolean kingInCheck = isKingInCheck(originalFromPiece.getPlayer(), board);

//         // Restore original state
//         from.setPiece(originalFromPiece);
//         to.setPiece(originalToPiece);

//         return kingInCheck;
//     }

//     private Square findKing(Player player, Square[][] board) {
//         for (int row = 0; row < 8; row++) {
//             for (int col = 0; col < 8; col++) {
//                 Piece piece = board[row][col].getPiece();
//                 if (piece instanceof King && piece.getPlayer() == player) {
//                     return board[row][col];
//                 }
//             }
//         }
//         return null;
//     }

//     private boolean canAnyPieceReachSquare(Player player, Square targetSquare, Square[][] board) {
//         for (int row = 0; row < 8; row++) {
//             for (int col = 0; col < 8; col++) {
//                 Square square = board[row][col];
//                 Piece piece = square.getPiece();
//                 if (piece != null && piece.getPlayer() == player) {
//                     if (isValidMove(square, targetSquare, board)) {
//                         return true;
//                     }
//                 }
//             }
//         }
//         return false;
//     }

//     public boolean isValidMove(Square from, Square to, Square[][] board) {
//         Piece piece = from.getPiece();
//         if (piece == null) return false;

//         // Basic move validation
//         if (!piece.isValidMove(from, to, board)) {
//             return false;
//         }

//         // Cannot capture own piece
//         if (to.getPiece() != null && to.getPiece().getPlayer() == piece.getPlayer()) {
//             return false;
//         }

//         return true;
//     }

//     private Player getOpponent(Player player) {
//         return player == Player.WHITE ? Player.BLACK : Player.WHITE;
//     }
// }
package com.chess.game;

import com.chess.board.Square;
import com.chess.pieces.King;
import com.chess.pieces.Piece;
import com.chess.players.Player;

public class GameRules {
    private static GameRules instance;

    private GameRules() {
    }

    public static GameRules getInstance() {
        if (instance == null) {
            instance = new GameRules();
        }
        return instance;
    }

    // Check if the king is in check
    public boolean isKingInCheck(Player player, Square[][] board) {
        Square kingSquare = findKing(player, board);
        if (kingSquare == null)
            return false;
        return canAnyPieceReachSquare(getOpponent(player), kingSquare, board);
    }

    // Check if the player is in checkmate
    public boolean isCheckmate(Player player, Square[][] board) {
        // The player is in check and has no valid moves
        return isKingInCheck(player, board) && !hasAnyValidMove(player, board);
    }

    // Check if the game is in stalemate
    public boolean isStalemate(Player player, Square[][] board) {
        // The player is not in check but has no valid moves
        return !isKingInCheck(player, board) && !hasAnyValidMove(player, board);
    }

    // Check if a player has any valid moves
    private boolean hasAnyValidMove(Player player, Square[][] board) {
        for (int fromRow = 0; fromRow < 8; fromRow++) {
            for (int fromCol = 0; fromCol < 8; fromCol++) {
                Square fromSquare = board[fromRow][fromCol];
                Piece piece = fromSquare.getPiece();
                if (piece != null && piece.getPlayer() == player) {
                    if (hasValidMoves(fromSquare, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Check if a piece has valid moves
    private boolean hasValidMoves(Square fromSquare, Square[][] board) {
        for (int toRow = 0; toRow < 8; toRow++) {
            for (int toCol = 0; toCol < 8; toCol++) {
                Square toSquare = board[toRow][toCol];
                if (isValidMove(fromSquare, toSquare, board)) {
                    if (!wouldMoveLeaveKingInCheck(fromSquare, toSquare, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Simulate a move and check if it leaves the king in check
    public boolean wouldMoveLeaveKingInCheck(Square from, Square to, Square[][] board) {
        Piece movingPiece = from.getPiece();
        Piece capturedPiece = to.getPiece();

        // Perform the move
        to.setPiece(movingPiece);
        from.setPiece(null);

        boolean isCheck = isKingInCheck(movingPiece.getPlayer(), board);

        // Revert the move
        from.setPiece(movingPiece);
        to.setPiece(capturedPiece);

        return isCheck;
    }

    // Find the king's square for a given player
    private Square findKing(Player player, Square[][] board) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col].getPiece();
                if (piece instanceof King && piece.getPlayer() == player) {
                    return board[row][col];
                }
            }
        }
        return null;
    }

    private boolean canAnyPieceReachSquare(Player opponent, Square targetSquare, Square[][] board) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Square fromSquare = board[row][col];
                Piece piece = fromSquare.getPiece();
                if (piece != null && piece.getPlayer() == opponent) {
                    if (isValidMove(fromSquare, targetSquare, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Validate if a move is legal
    public boolean isValidMove(Square from, Square to, Square[][] board) {
        Piece piece = from.getPiece();
        if (piece == null)
            return false;

        // Check if the piece's move is valid
        if (!piece.isValidMove(from, to, board)) {
            return false;
        }

        // Prevent capturing a piece from the same player
        if (to.getPiece() != null && to.getPiece().getPlayer() == piece.getPlayer()) {
            return false;
        }

        return true;
    }

    // Get the opponent of a player
    private Player getOpponent(Player player) {
        return player == Player.WHITE ? Player.BLACK : Player.WHITE;
    }

    // Check the current game status (checkmate, stalemate, or game over)
    public String checkGameStatus(Player currentPlayer, Square[][] board) {
        // Check if king is captured
        if (findKing(currentPlayer, board) == null) {
            return "Game Over! " + getOpponent(currentPlayer) + " wins. The king has been captured.";
        }
        // Check if checkmate or stalemate occurs
        if (isCheckmate(currentPlayer, board)) {
            return "Checkmate! " + getOpponent(currentPlayer) + " wins.";
        } else if (isStalemate(currentPlayer, board)) {
            return "Stalemate! The game ends in a draw.";
        }
        return null; // Game is still ongoing
    }
}
