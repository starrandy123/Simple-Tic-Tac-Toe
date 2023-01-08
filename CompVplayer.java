import java.util.Scanner;

public class CompVplayer extends BaseGame //inherits from BaseGame class
{
    public static void Computer1Turn(char[][] board) { //Function for the first computer turn
        int compTurn;
        while (true)
        {
            compTurn = BestMove(board,'X','O');
            if (ifSpaceOpen(board,Integer.toString(compTurn)))
                break;
        }
        System.out.println("Computer chose "+compTurn);
        PlayerMove(board, Integer.toString(compTurn), 'X');
    }

    public static void Player2Turn(char[][] board, Scanner scanner) { //Function for the second computer turn
        String UserInput;
        while (true) {
            System.out.println("Player 1: Please choose a spot (1-9)");
            UserInput = scanner.nextLine();
            if (ifSpaceOpen(board, UserInput))
                break;
            else System.out.println("Please use an empty space. "+UserInput+" is taken");
        }
        PlayerMove(board, UserInput, 'O');
    }

    public static boolean CompGameOver(char[][] board) //checks if the game is over and loop if not
    {
        if (Winner(board,'X'))
        {
            PrintBoard(board);
            System.out.println("Computer has won! ");
            return true;
        }

        if (Winner(board,'O'))
        {
            PrintBoard(board);
            System.out.println("Player has won! ");
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
