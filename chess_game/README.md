# Chess Game Implementation in Java

This project is a fully functional chess game built in Java, featuring a **graphical user interface (GUI)** using Java Swing. It adheres to all standard chess rules and incorporates **design patterns** for modularity, maintainability, and scalability.

---

## Key Features

- **Complete Chess Rules**:
  - Standard piece movements, castling, en passant, and pawn promotion.
  - Check, checkmate, and stalemate detection.
- **Interactive Gameplay**:
  - Two players take turns making moves.
  - Visual feedback for valid and invalid moves.
- **Graphical User Interface (GUI)**:
  - Built using Java Swing for a user-friendly experience.
- **Modular Design**:
  - Organized into packages and classes for easy extension or modification.
- **Customizable Board**:
  - Programmatic representation of the chessboard and pieces for future enhancements (e.g., AI, online multiplayer).

---

## Design Patterns Used

### 1. **Singleton Pattern**
   - Ensures only one instance of `ChessGame` and `PieceFactory` exists.

### 2. **Factory Pattern**
   - Centralizes piece creation in the `PieceFactory` class.

### 3. **Observer Pattern**
   - Updates the board state using `Subject` and `Observer` interfaces for loose coupling.

### 4. **Strategy Pattern**
   - Defines movement rules for each piece, allowing flexible and interchangeable strategies.

---

## Project Structure

### 1. **Board Package**
   - `ChessBoard`: Manages the 8x8 board and piece positions.
   - `Square`: Represents individual squares on the board.

### 2. **Pieces Package**
   - `Piece`: Abstract base class for all pieces.
   - Subclasses like `King`, `Queen`, `Rook`, `Bishop`, `Knight`, and `Pawn` implement specific movement rules.

### 3. **Game Package**
   - `ChessGame`: Manages game flow, player turns, and game state.
   - `GameRules`: Handles move validation and state checks.
   - `GameState`: Tracks game state (e.g., check, checkmate, stalemate).

### 4. **Players Package**
   - `Player`: Represents a player, including their color (white or black).

### 5. **Utils Package**
   - `MoveValidator`: Validates legal moves.
   - `GameUtils`: Helper methods for game operations.

### 6. **Patterns Package**
   - Implements advanced mechanics like castling and en passant using move patterns or strategies.
