import java.util.Scanner;
public class TicTacToe
{
	static boolean AI_MODE = false;
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String board = "abcdefghi";
		boolean over = false;
		if(AI_MODE)
		{
		}
		else
		{
			boolean valid = false;
			String player = "X";
			while(!over)
			{
				String input;
				do
				{
					printBoard(board);
					System.out.print("Player "+player + " go: ");
					input = getInput(scan);
					valid = validInput(input,board);
				}while(!valid);
				board = board.replace(input,player);
				if(gameWon(board))
				{
					System.out.println(player + " wins!\n");
					over = true;
				}
				else if(gameTie(board))
				{
					System.out.println("Tie!\n");
					over = true;
				}
				if(player.equals("X")){player="O";}
				else{player="X";}
			}
			printBoard(board);
		}

	}

	public static String getInput(Scanner s)
	{
		return s.next();
	}

	public static boolean validInput(String input, String board)
	{
		if(board.contains(input) && input.matches("[abcdefghi]"))
		{
			return true;
		}
		else{return false;}
	}

	public static boolean gameWon(String board)
	{
		/*
		0 1 2
		3 4 5
		6 7 8
		*/
		char[] b = board.toCharArray();
		if(b[0]==b[1] && b[1]==b[2]){return true;} //top hor
		if(b[3]==b[4] && b[4]==b[5]){return true;} //mid hor
		if(b[6]==b[7] && b[7]==b[8]){return true;} //low hor
		if(b[0]==b[3] && b[3]==b[6]){return true;} //L vert
		if(b[1]==b[4] && b[4]==b[7]){return true;} //mid vert
		if(b[2]==b[5] && b[5]==b[8]){return true;} //R vert
		if(b[0]==b[4] && b[4]==b[8]){return true;} //down diag
		if(b[2]==b[4] && b[4]==b[6]){return true;} //up diag
		return false;
	}
	public static boolean gameTie(String board)
	{
		//System.out.println(board);
		if(board.replaceAll("[XO]","").length()==0)
		{
			//System.out.println(board.replaceAll("[XO]","").length());
			return true;
		}
		else return false;
	}

	public static void printBoard(String board)
	{
		/*
		0 1 2
		3 4 5
		6 7 8
		*/
		char[] b = board.toCharArray();
		System.out.println(" "+b[0]+" | "+b[1]+" | "+b[2]);
		System.out.println("-----------");
		System.out.println(" "+b[3]+" | "+b[4]+" | "+b[5]);
		System.out.println("-----------");
		System.out.println(" "+b[6]+" | "+b[7]+" | "+b[8]+"\n");
	}
}