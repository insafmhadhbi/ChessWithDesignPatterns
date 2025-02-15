# Chess Game Implementation

Welcome to the **Chess Game Implementation**! This project is a fully functional chess game built in Java, designed to simulate the classic game of chess with all its rules and mechanics. The game features a **graphical user interface (GUI)** using Java Swing and incorporates several **design patterns** to ensure modularity, maintainability, and scalability.

---

## Key Features

- **Complete Chess Rules**:
  - All standard chess rules are implemented, including piece movements, castling, en passant, and pawn promotion.
  - Check, checkmate, and stalemate detection.
- **Interactive Gameplay**:
  - Two players can take turns making moves on the chessboard.
  - Visual feedback for valid and invalid moves.
- **Graphical User Interface (GUI)**:
  - Built using Java Swing for an intuitive and user-friendly experience.
- **Modular Design**:
  - The code is organized into packages and classes, making it easy to extend or modify.
- **Customizable Board**:
  - The chessboard and pieces are represented programmatically, allowing for potential future enhancements (e.g., AI opponents, online multiplayer).

---

## Design Patterns Used

This project demonstrates the effective use of **design patterns** to create a modular and maintainable application. The following patterns were implemented:

### 1. **Singleton Pattern**
   - Used in the `ChessGame` class to ensure that only one instance of the game exists at any time.
   - Also implemented in the `PieceFactory` class for centralized creation of chess pieces.

### 2. **Factory Pattern**
   - The `PieceFactory` class centralizes the creation of chess pieces, allowing for easy modifications and extensions of piece types.

### 3. **Observer Pattern**
   - Employed for updating the board state.
   - Implemented through `Subject` and `Observer` interfaces to maintain loose coupling between the board state and UI updates.

### 4. **Strategy Pattern**
   - Used to define the movement rules for different chess pieces, allowing for flexible and interchangeable movement strategies.

---

## Project Structure

The project is organized into the following key packages and classes:

### 1. **Board Package**
   - `ChessBoard`: Manages the 8x8 chessboard and tracks the positions of pieces.
   - `Square`: Represents individual squares on the board, which can hold a chess piece.

### 2. **Pieces Package**
   - `Piece`: Abstract base class for all chess pieces.
   - Subclasses like `King`, `Queen`, `Rook`, `Bishop`, `Knight`, and `Pawn` implement specific movement rules and behaviors.

### 3. **Game Package**
   - `ChessGame`: The main class that manages the game flow, player turns, and game state.
   - `GameRules`: Contains core game logic, including move validation and state checks.
   - `GameState`: Tracks the current state of the game (e.g., check, checkmate, stalemate).

### 4. **Players Package**
   - `Player`: Represents a player, including their color (white or black) and available moves.

### 5. **Utils Package**
   - `MoveValidator`: Validates whether a move is legal based on chess rules.
   - `GameUtils`: Contains helper methods for game-related operations.

### 6. **Patterns Package**
   - Includes classes for defining move patterns or strategies:
     - Used to implement advanced chess mechanics like castling and en passant.

---

## Installation and Usage

### Prerequisites
- Ensure you have **Java SE 8 or higher** installed on your system.
- Clone this repository to your local machine.

