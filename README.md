# TicTacToe Game

## Overview

Welcome to the TicTacToe game! This is a simple yet engaging graphical version of the classic TicTacToe game implemented in Java using Swing. The game allows you to play against the computer, with adjustable settings for line thickness and player colors.

## Features
- Interactive Gameplay: Click on the grid to make your move.
- Adjustable Line Thickness: Use the slider to adjust the thickness of the grid lines.
- Customizable Colors: Choose different colors for 'O' and 'X' using the color picker.
- Game Statistics: Keep track of your wins, losses, and draws.
- Computer Opponent: Play against an AI that tries to block your moves and win the game.

## Getting Started
## Prerequisites
- Java Development Kit (JDK) installed on your computer.
## Running the Game
1. Save the code to a file named TicTacToe.java.
2. Open a terminal or command prompt.
3. Navigate to the directory where TicTacToe.java is saved.
4. Compile the Java file using the command:

Copy code - javac TicTacToe.java

5. Run the compiled Java program using the command:

Copy code - java TicTacToe

## How to Play
- Start the Game: Launch the game to see the TicTacToe grid.
- Make a Move: Click on an empty cell to place your 'O'.
- Computer's Turn: After you place 'O', the computer will automatically make its move as 'X'.
- Win, Lose, or Draw: The game checks for a win, loss, or draw after each move. If the game ends, a dialog box will show the result and ask if you want to play again.
- Adjust Settings:
   - Use the Line Thickness slider to change the thickness of the grid lines.
   - Click on the O Color button to choose a new color for 'O'.
   - Click on the X Color button to choose a new color for 'X'.
     
## Code Explanation
## Main Class: TicTacToe
- TicTacToe(): The constructor initializes the game window, adding the slider, color buttons, and the game board.
- stateChanged(ChangeEvent e): Adjusts the line thickness based on the slider's value.
- actionPerformed(ActionEvent e): Opens a color chooser dialog to change the color of 'O' or 'X'.
## Inner Class: Board
- Board(): Adds a mouse listener to handle user clicks on the game board.
- paintComponent(Graphics g): Draws the TicTacToe grid and the 'O' and 'X' marks.
- mouseClicked(MouseEvent e): Handles user clicks to place 'O' and triggers the computer's move.
- putX(): Manages the computer's moves and checks for game over conditions.
- won(char player): Checks if the specified player has won the game.
- testRow(char player, int a, int b): Tests if a player has completed a row.
- nextMove(): Determines the best move for the computer.
- findRow(char player): Finds a row where the specified player can win or block.
- find1Row(char player, int a, int b): Finds a blank spot in a row where the player can win or block.
- isDraw(): Checks if the game is a draw.
- newGame(char winner): Resets the board and starts a new game, showing the result of the previous game.
  
## Customization
You can easily customize the game by modifying the following parts of the code:

- Initial Line Thickness: Change the initial value of lineThickness in the TicTacToe constructor.
- Initial Colors: Change the initial values of oColor and xColor in the TicTacToe constructor.
- Board Size: Adjust the size of the game window by changing the dimensions in the setSize() method call.

# Conclusion
Enjoy playing this graphical TicTacToe game against the computer. Customize the game settings to your liking and see how many times you can win against the AI!

# ScreenShots

![Screenshot (274)](https://github.com/SumitSharma2000/JAVA-PROJECT-2023/assets/94536005/ceea9937-90f6-4e79-b4fb-656b529b6e53)
![Screenshot (275)](https://github.com/SumitSharma2000/JAVA-PROJECT-2023/assets/94536005/0e2894e1-01ba-4ca8-be83-d407fd22eeaa)
![Screenshot (276)](https://github.com/SumitSharma2000/JAVA-PROJECT-2023/assets/94536005/f4fc284e-c5ff-4f32-8ca1-b16ef41eb255)
![Screenshot (277)](https://github.com/SumitSharma2000/JAVA-PROJECT-2023/assets/94536005/e4df59f9-60e8-4b70-9910-421ecac93d80)
![Screenshot (278)](https://github.com/SumitSharma2000/JAVA-PROJECT-2023/assets/94536005/5dc1741f-c2f1-4f3b-9900-2a960b82aadb)
![Screenshot (279)](https://github.com/SumitSharma2000/JAVA-PROJECT-2023/assets/94536005/e1a5fca8-39d7-4871-8105-708041744fad)
![Screenshot (280)](https://github.com/SumitSharma2000/JAVA-PROJECT-2023/assets/94536005/a7d4eddb-2da1-4cdc-a5a0-34c6b93d8447)
![Screenshot (281)](https://github.com/SumitSharma2000/JAVA-PROJECT-2023/assets/94536005/dbb20ed2-65a1-48ac-a1ba-204367866535)


