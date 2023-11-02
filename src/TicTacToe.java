import java.util.Scanner;

public class TicTacToe
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    //class TicTacToe
    //Main()
        //boolean finish = true;
    //        boolean playing = true;
    //        Scanner in = new Scanner(System.in);
    //        String play = "X";
    //        int moveCnt = 0;
    //        int row = -1;
    //        int col = -1;
    //        final int Moves_To_win = 5;
    //        final int Moves_To_Tie = 7;
    //        do
    //
    //            play = "X"
    //            playing = true
    //            moveCnt = 0
    //            clearBoard()
    //            do
    //                do
    //                    display();
    //                    System.out.println("Enter a move: " + play);
    //                    row = SafeInput.getRangedInt(in, "Enter row ", 1,3);
    //                    col = SafeInput.getRangedInt(in, "Enter col ", 1,3);
    //                    row--;
    //                    col--;
    //                while !isValidMove(row, col)
    //
    //                board[row][col] = play
    //                moveCnt++
    //
    //                if moveCnt >= Moves_To_win
    //
    //                    if(isWin(play))
    //
    //                        display();
    //                        System.out.println("Player " + play + "wins!");
    //                        playing = false;
    //
    //                    else if (moveCnt >= Moves_To_Tie)
    //
    //                        if(isTie())
    //
    //                            display()
    //                            System.out.println("Its a tie!")
    //                            playing = false
    //
    //
    //
    //                if play == X
    //
    //                    play = O
    //
    //                else
    //
    //                    play = X
    //
    //             while(playing)
    //
    //            finish = SafeInput.getYNConfirm(in, "Do you want to play again? ")
    //        }while !finish
    //return
    //endClass




    public static void main(String[] args)
    {
        boolean finish = true;
        boolean playing = true;
        Scanner in = new Scanner(System.in);
        String play = "X";
        int moveCnt = 0;
        int row = -1;
        int col = -1;
        final int Moves_To_win = 5;
        final int Moves_To_Tie = 7;
        do{

            play = "X";
            playing = true;
            moveCnt = 0;
            clearBoard();
            do{
                do{
                    display();
                    System.out.println("Enter a move: " + play);
                    row = SafeInput.getRangedInt(in, "Enter row ", 1,3);
                    col = SafeInput.getRangedInt(in, "Enter col ", 1,3);
                    row--;
                    col--;
                }while(!isValidMove(row, col));

                board[row][col] = play;
                moveCnt++;

                if(moveCnt >= Moves_To_win)
                {
                    if(isWin(play))
                    {
                        display();
                        System.out.println("Player " + play + " wins!");
                        playing = false;
                    }
                    else if (moveCnt >= Moves_To_Tie)
                    {
                        if(isTie())
                        {
                            display();
                            System.out.println("Its a tie!");
                            playing = false;
                        }
                    }
                }
                if(play.equals("X"))
                {
                    play = "O";
                }
                else
                {
                    play = "X";
                }
            }while(playing);

            finish = SafeInput.getYNConfirm(in, "Do you want to play again? ");
        }while(!finish);



    }
    private static void clearBoard()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                board[row][col] = " ";
            }
        }
    }

    private static void display()
    {
        for(int row = 0; row < ROW; row++)
        {
            System.out.print("| ");
            for(int col = 0; col < COL; col++)
            {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col)
    {
        boolean retVal = false;
        if(board[row][col].equals(" "))
        {
            retVal = true;
        }
        else
        {
            System.out.println("Please enter a different move");
        }

        return retVal;
    }

    private static boolean isWin(String play)
    {
        if(isColWin(play) || isRowWin(play) || isDiagWin(play))
        {
            return true;
        }
        return false;
    }

    private static boolean isColWin(String play)
    {
        for(int col=0; col < COL; col++)
        {
            if(board[0][col].equals(play) &&
               board[1][col].equals(play) &&
               board[2][col].equals(play))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String play)
    {
        for(int row=0; row < ROW; row++)
        {
            if(board[0][row].equals(play) &&
                    board[1][row].equals(play) &&
                    board[2][row].equals(play))
            {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagWin(String play)
    {
        if(board[0][0].equals(play) &&
                board[1][1].equals(play) &&
                board[2][2].equals(play))
        {
            return true;
        }
        if(board[0][2].equals(play) &&
                board[1][1].equals(play) &&
                board[2][0].equals(play))
        {
            return true;
        }
        return false;
    }

    private static boolean isTie()
    {
        int xCheck = 0;
        int oCheck = 0;
        int ties = 0;

        for(int row = 0; row < ROW; row++)
        {
            if(board[row][0].equals("X") ||
                    board[row][1].equals("X") ||
                    board[row][2].equals("X"))
            {
                xCheck++;
            }
            if(board[row][0].equals("O") ||
                    board[row][1].equals("O") ||
                    board[row][2].equals("O"))
            {
                oCheck++;
            }
            for(int col = 0; col< COL; col++)
            {
                if(board[col][0].equals("X") ||
                        board[col][1].equals("X") ||
                        board[col][2].equals("X"))
                {
                    xCheck++;
                }
                if(board[row][0].equals("O") ||
                        board[row][1].equals("O") ||
                        board[row][2].equals("O"))
                {
                    oCheck++;
                }
                if(xCheck >= 1 || oCheck >= 1)
                {
                    ties++;
                }



            }
            if(ties >= 3)
            {
                return true;
            }

        }
        return false;
    }
}
