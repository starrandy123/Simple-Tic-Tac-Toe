import java.util.Objects; //importing Object class
import java.util.Scanner; //importing Scanner class

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Command;
        char[][] board = {{' ', ' ', ' '}, //board layout
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        while (true) { //loop until the right command is chosen
            System.out.println("Usage: java TicTacToe [-c [1|2]]");
            Command = scanner.nextLine();

            if (Objects.equals(Command, "java TicTacToe -c 1")) { //runs computer(P1) versus human player(P2)
                BaseGame.PrintBoard(board);
                CompvP(board, scanner);
                break;
            }

            if (Objects.equals(Command, "java TicTacToe -c 2")) { //runs human(P1) versus computer(P2)
                BaseGame.PrintBoard(board);
                PvComp(board, scanner);
                break;
            }

            if (Objects.equals(Command, "java TicTacToe -c")) { //runs computer versus computer
                BaseGame.PrintBoard(board);
                CompToe(board, scanner);
                break;
            }

            if (Objects.equals(Command, "java TicTacToe")) { //runs human player versus human player
                BaseGame.PrintBoard(board);
                PvP(board, scanner);
                break;
            }
        }
    }

    public static void PvP(char [][] board, Scanner scanner) //function for Player V Player
    {
        System.out.println("Welcome to PvP TicTacToe");
        while (true)
        {
            BaseGame.PlayerTurn(board, scanner);
            if(PvP.PvPGameOver(board))
            {break;}
            BaseGame.PrintBoard(board);

            PvP.Player2Turn(board, scanner);
            if(PvP.PvPGameOver(board))
                break;
            BaseGame.PrintBoard(board);
        }
    }

    public static void PvComp(char [][] board, Scanner scanner) //function for Player V Computer
    {
        System.out.println("Welcome to Player vs Computer TicTacToe");
        while (true)
        {
            BaseGame.PlayerTurn(board, scanner);
            if(BaseGame.GameOver(board))
            {break;}
            BaseGame.PrintBoard(board);

            BaseGame.ComputerTurn(board);
            if(BaseGame.GameOver(board))
                break;
            BaseGame.PrintBoard(board);
        }
    }

    public static void CompvP(char [][] board, Scanner scanner) //function for Computer V Player
    {
        System.out.println("Welcome to Player vs Computer TicTacToe");
        while (true)
        {
            CompVplayer.Computer1Turn(board);
            if(CompVplayer.CompGameOver(board))
            {break;}
            BaseGame.PrintBoard(board);

            CompVplayer.Player2Turn(board,scanner);
            if(CompVplayer.CompGameOver(board))
                break;
            BaseGame.PrintBoard(board);
        }
    }

    public static void CompToe(char [][] board, Scanner scanner) //Function for computer vs player
    {
        System.out.println("Welcome to Computer vs Player TicTacToe");
        while (true)
        {
            CompVplayer.Computer1Turn(board);
            if(BaseGame.GameOver(board))
            {break;}
            BaseGame.PrintBoard(board);

            CompVplayer.Player2Turn(board, scanner);
            if(BaseGame.GameOver(board))
                break;
            BaseGame.PrintBoard(board);
        }
    }
}

