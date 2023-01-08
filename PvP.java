import java.util.Scanner;
public class PvP extends BaseGame { //Inherits from BaseGame
    public static void Player2Turn(char[][] board, Scanner scanner) { //Function for second human turn
        String UserInput;
        while (true) {
            System.out.println("Player 2: Please choose a spot (1-9)");
            UserInput = scanner.nextLine();
            if (ifSpaceOpen(board, UserInput))
                break;
            else System.out.println("Please use an empty space. "+UserInput+" is taken");
        }
        PlayerMove(board, UserInput, 'O');
    }

    public static boolean PvPGameOver(char[][] board) //loops until game is finished
    {
        if (Winner(board,'X'))
        {
            PrintBoard(board);
            System.out.println("Player 1 has won! ");
            return true;
        }

        if (Winner(board,'O'))
        {
            PrintBoard(board);
            System.out.println("Player 2 has won! ");
            return true;
        }

        for (int i=0; i<board.length;i++)
        {
            for (int j=0;j<board[i].length;j++)
            {
                if (board[i][j]==' ')
                    return false;
            }
        }
        PrintBoard(board);
        System.out.println("It's a Tie!");
        return true ;
    }
}
