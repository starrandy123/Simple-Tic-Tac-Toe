public class CompVComp extends BaseGame //inherits from BaseGame
{
    public static void FirstComputerTurn(char[][] board) { //function for first computer turn
        int compTurn;
        while (true)
        {
            compTurn = BestMove(board,'X','O');
            if (ifSpaceOpen(board,Integer.toString(compTurn)))
                break;
        }
        System.out.println("First Computer chose "+compTurn);
        PlayerMove(board, Integer.toString(compTurn), 'X');
    }

    public static boolean CompGameOver(char[][] board) //loops until the game is over
    {
        if (Winner(board,'X'))
        {
            PrintBoard(board);
            System.out.println("Computer 1 has won! ");
            return true;
        }

        if (Winner(board,'O'))
        {
            PrintBoard(board);
            System.out.println("Computer 2 has won! ");
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
