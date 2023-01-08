import java.util.Random;
import java.util.Scanner;

public class BaseGame //main game code
{
    public static void ComputerTurn(char[][] board) { //function for computers turn
        int compTurn; //integer for board space
        while (true)
        {
            compTurn = BestMove(board,'X','O'); //making sure the computer makes the best move
            if (ifSpaceOpen(board,Integer.toString(compTurn))) //if the space is available
                break;
        }
        System.out.println("Computer chose "+compTurn); //prints which space the computer chose
        PlayerMove(board, Integer.toString(compTurn), 'O'); //implements the computers turn
    }

    public static int BestMove(char[][] board, char symbol, char player)
    {
        int point = 5; //default position for computer
        if((board[0][0]==symbol && board[0][1]==symbol) //chooses spot 3 when it is the best move
                ||(board[2][0]==symbol && board[1][1]==symbol)
                ||(board[1][2]==symbol && board[2][2]==symbol)
                ||(board[1][1]==symbol)
                ||(board[1][1]==player && board[2][2]==player)
                ||(board[1][1]=='O' && board[2][2]==' ')
                ||(board[0][0]==player && board[0][1]==player)
                ||(board[2][0]==player && board[1][1]==player)
                ||(board[1][2]==player && board[2][2]==player)
        )
        {point=3;}

        if((board[0][1]==symbol && board[0][2]==symbol) //chooses spot 1 when it is the best move
                ||(board[1][0]==symbol && board[2][0]==symbol)
                ||(board[1][1]==symbol && board[2][2]==symbol)
                ||(board[0][1]==player && board[0][2]==player)
                ||(board[1][0]==player && board[2][0]==player)
                ||(board[1][1]==player && board[2][2]==player)
        )
        {point=1;}

        if((board[1][0]==symbol && board[1][1]==symbol) //chooses spot 6 when it is the best move
                ||(board[0][2]==symbol && board[2][2]==symbol)
                ||(board[1][0]==player && board[1][1]==player)
                ||(board[0][2]==player && board[2][2]==player)
        )
        {point=6;}

        if((board[1][1]==symbol && board[1][2]==symbol) //chooses spot 6 when it is the best move
                ||(board[0][0]==symbol && board[2][0]==symbol)
                ||(board[1][1]==player && board[1][2]==player)
                ||(board[0][0]==player && board[2][0]==player))
        {point=4;}

        if((board[0][0]==symbol && board[0][2]==symbol) //chooses spot 2 when it is the best move
                ||(board[1][1]==symbol && board[2][1]==symbol)
                ||(board[0][0]==player && board[0][2]==player)
                ||(board[1][1]==player && board[2][1]==player))
        {point=2;}

        if((board[0][1]==symbol && board[1][1]==symbol) //chooses spot 8 when it is the best move
                ||(board[2][0]==symbol && board[2][2]==symbol)
                ||(board[0][1]==player && board[1][1]==player)
                ||(board[2][0]==player && board[2][2]==player))
        {point=8;}
      //second row block
        if((board[2][0]==symbol && board[2][1]==symbol) //chooses spot 9 when it is the best move
                ||(board[0][2]==symbol && board[1][2]==symbol)
                ||(board[0][0]==symbol && board[1][1]==symbol)
                ||(board[2][0]==player && board[2][1]==player)
                ||(board[0][2]==player && board[1][2]==player)
                ||(board[0][0]==player && board[1][1]==player))
        {point=9;}

        if((board[2][1]==symbol && board[2][2]==symbol) //chooses spot 7 when it is the best move
                ||(board[0][0]==symbol && board[1][0]==symbol)
                ||(board[1][1]==symbol && board[0][2]==symbol)
                ||(board[2][1]==player && board[2][2]==player)
                ||(board[0][0]==player && board[1][0]==player)
                ||(board[1][1]==player && board[0][2]==player))
        {point=7;}

        Random rand = new Random(); //if all else fails, choose a random spot
        point = rand.nextInt(9) + 1;

        return point;
    }

    public static boolean GameOver(char[][] board) //loops until game is over
    {
        if (Winner(board,'X')) //prints if the human player has won
        {
            PrintBoard(board);
            System.out.println("Player has won! ");
            return true;
        }

        if (Winner(board,'O')) //prints of the computer has won
        {
            PrintBoard(board);
            System.out.println("Computer has won! ");
            return true;
        }

        for (int i=0; i<board.length;i++) //checks the whole board to find if there is space available
        {
            for (int j=0;j<board[i].length;j++)
            {
                if (board[i][j]==' ')
                    return false; //returns false if there is space
            }
        }
        PrintBoard(board);
        System.out.println("It's a Tie!");
        return true ; //returns true if there isn't space
    }

    public static boolean Winner(char[][] board, char symbol) { //checks for all winning combinations
        if ((board[0][0]==symbol && board[0][1]==symbol&& board[0][2]==symbol)||
                (board[1][0]==symbol&& board[1][1]==symbol&& board[1][2]==symbol)||
                (board[2][0]==symbol&& board[2][1]==symbol&& board[2][2]==symbol)||
                //checking for vertical collumns
                (board[0][0]==symbol&& board[1][0]==symbol&& board[2][0]==symbol)||
                (board[0][1]==symbol&& board[1][1]==symbol&& board[2][1]==symbol)||
                (board[0][2]==symbol&& board[1][2]==symbol&& board[2][2]==symbol)||
                //checking for rows
                (board[0][0]==symbol&& board[1][1]==symbol&& board[2][2]==symbol)||
                (board[0][2]==symbol&& board[1][1]==symbol&& board[2][0]==symbol))
        //checking for diagonals
        {
            return true;
        }
        return false;
    }

    public static boolean ifSpaceOpen(char[][] board, String space) { //checks if the space is available
        switch (space) {
            case "1":
                return (board[0][0] == ' ');

            case "2":
                return (board[0][1] == ' ');

            case "3":
                return (board[0][2] == ' ');

            case "4":
                return (board[1][0] == ' ');

            case "5":
                return (board[1][1] == ' ');

            case "6":
                return (board[1][2] == ' ');

            case "7":
                return (board[2][0] == ' ');

            case "8":
                return (board[2][1] == ' ');

            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    public static void PlayerTurn(char[][] board, Scanner scanner) {
        String UserInput;
        while (true) { //loops until the player chooses a valid space
            System.out.println("Player 1: Please choose a spot (1-9)");
            UserInput = scanner.nextLine();
            if (ifSpaceOpen(board, UserInput))
                break;
            else System.out.println("Please use an empty space. "+UserInput+" is taken");
        }
        PlayerMove(board, UserInput, 'X'); //implements player move to board
    }

    public static void PlayerMove(char[][] board, String spot, char sign) {
        switch (spot) { //implements the space chosen by the player or computer
            case "1":
                board[0][0] = sign;
                break;
            case "2":
                board[0][1] = sign;
                break;
            case "3":
                board[0][2] = sign;
                break;
            case "4":
                board[1][0] = sign;
                break;
            case "5":
                board[1][1] = sign;
                break;
            case "6":
                board[1][2] = sign;
                break;
            case "7":
                board[2][0] = sign;
                break;
            case "8":
                board[2][1] = sign;
                break;
            case "9":
                board[2][2] = sign;
                break;
            default:
                System.out.println("Wrong Input");

        }
    }

    public static void PrintBoard(char[][] board) //prints board layout
    {
        System.out.println(board[0][0]+ "|" + board[0][1]+ "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0]+ "|" + board[1][1]+ "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0]+ "|" + board[2][1]+ "|" + board[2][2]);
    }
}
